import React, { createContext, useState, useEffect, useContext } from "react";
import mqtt from "mqtt";
import AuthContext from "./AuthContext";
import { color } from "@chakra-ui/react";
const MqttContext = createContext();

const MqttContextProvider = ({ children }) => {
  const [client, setClient] = useState(null);
  const [connectStatus, setConnectStatus] = useState(false);
  const [msgBuffer, setMsgBuffer] = useState(null);
  const [queueBuffer, setQueueBuffer] = useState(null);
  const [tweetsList, setTweetsList] = useState([]);
  const [msgQueue, setMsgQueue] = useState([]);
  const [msgPrivate, setMsgPrivate] = useState([]);
  const [idSetTimeout, setIdSetTimeout] = useState(null);

  const { user, isAuthenticated } = useContext(AuthContext);

  const mqttConnect = (host, mqttOption) => {
    // setConnectStatus("Connecting");
    setClient(mqtt.connect(host, mqttOption));
  };

  const sendAllMessages = () => {
    SetIdSetTimeout(
      setTimeout(() => {
        client.publish(`online/${msgPrivate[0].clientId}`, msgPrivate.msg);
      }, 1000)
    );
  };

  useEffect(() => {
    if (!idSetTimeout && msgPrivate.length > 0) sendAllMessages();
    else if (msgPrivate.length == 0) setIdSetTimeout(null);
  }, [msgPrivate]);

  useEffect(() => {
    if (client) {
      client.on("connect", () => {
        setConnectStatus(true);
      });
      client.on("error", (err) => {
        console.error("Connection error: ", err);
        client.end();
      });
      client.on("reconnect", () => {
        setConnectStatus(false);
      });
      client.on("message", (topic, message) => {
        const payload = { topic, message: message.toString() };
        const payloadMessage = payload.message.split("&");

        if (topic === "feed") {
          setMsgBuffer({
            msg: payloadMessage[0],
            name: payloadMessage[1],
            color: payloadMessage[2],
            timestamp: payloadMessage[3],
          });
        }
        if (
          !!`online/${msgPrivate[0].clientId}` &&
          topic === `online/${msgPrivate[0].clientId}`
        ) {
          msgPrivate.shift();
        }
        if (topic === `online/${client.option.clientId}`) {
          console.log(message)
        }
        if (topic === "messages/queue") {
          const queue = payload.message.split("¿");
          // console.log(queue);
          setQueueBuffer(queue);
        }
      });
    }
  }, [client]);

  function publish(topic, msg) {
    if (connectStatus) {
      client.subscribe(topic, function (err) {
        if (!err) {
          client.publish(topic, msg);
        }
      });
    } else {
      msgQueue.push({
        topic,
        msg,
      });

      if (topic === "feed") {
        setMsgBuffer({
          msg: msg.split("&")[0],
          name: user.name,
          color: user.color,
          timestamp: Date.now(),
        });
      }
    }
    // console.log("publishing", connectStatus);
  }

  function publishInPrivate(msg, clientId) {
    msgPrivate.push({
      msg: msg,
      client: clientId,
    });
  }

  function publishInFeed(msg) {
    publish("feed", `${msg}&${user.name}&${user.color}&${Date.now()}`);
  }

  function publishNewConnection(msg) {
    publish("connection/new", `${user.email}`);

    client.subscribe("messages/queue", function (err) {
      if (err) {
        console.log(err);
      }
    });
  }

  function connectMqtt() {
    mqttConnect("mqtt://localhost:9001");
  }

  useEffect(() => {
    if (!!msgBuffer) {
      setTweetsList((t) => [msgBuffer, ...t]);
    }
  }, [msgBuffer]);

  useEffect(() => {
    if (connectStatus && msgQueue.length > 0) {
      setTweetsList([]);
      setTimeout(() => {
        msgQueue.forEach((item) => {
          publish(item.topic, item.msg);
        });
        setMsgQueue([]);
      }, 3000 + (Date.now() % 3000));
    }
  }, [connectStatus]);

  useEffect(() => {
    if (!!queueBuffer) {
      const list = [];
      queueBuffer.forEach((item) => {
        const payloadMessage = item.split("&");
        list.unshift({
          msg: payloadMessage[0],
          name: payloadMessage[1],
          color: payloadMessage[2],
          timestamp: payloadMessage[3],
        });
      });
      setTweetsList(list);
    }
  }, [queueBuffer]);

  useEffect(() => {
    if (isAuthenticated) {
      connectMqtt();
    }
  }, [isAuthenticated]);

  useEffect(() => {
    if (connectStatus) {
      publishNewConnection();
    }
  }, [connectStatus]);
  return (
    <MqttContext.Provider
      value={{
        connectStatus,
        connectMqtt,
        publishInFeed,
        tweetsList,
      }}
    >
      {children}
    </MqttContext.Provider>
  );
};
export { MqttContextProvider };
export default MqttContext;
