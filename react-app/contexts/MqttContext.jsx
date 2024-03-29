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
  const [msgPrivateView, setMsgPrivateView] = useState([]);
  const [usersQueue, setusersQueue] = useState({});
  const [newQueueMsg, setNewQueueMsg] = useState();

  const { user, isAuthenticated } = useContext(AuthContext);

  const mqttConnect = (host, mqttOption) => {
    // setConnectStatus("Connecting");
    setClient(mqtt.connect(host, mqttOption));
  };

  const sendAllMessages = (id) => {
    if (usersQueue[id]) {
      if (usersQueue[id].length > 0) {
        client.subscribe(`online/response/${id}`, function (err) {
          if (err) {
            console.log(err);
          }
        });
        client.publish(`online/${id}`, "online");
        setTimeout(() => sendAllMessages(id), 1000);
      }
    } else {
      setTimeout(() => sendAllMessages(id), 1000);
    }
  };

  function sendQueuedMsg(id) {
    if (usersQueue[id] && usersQueue[id].length > 0) {
      const msg = usersQueue[id].shift();

      client.publish(
        `online/message/${id}`,
        msg + "&" + user.name + "&" + user.color
      );
    }
  }

  useEffect(() => {
    if (msgPrivate.length > 0) sendAllMessages();
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
        // console.log(topic, payloadMessage);
        if (topic === "feed") {
          setMsgBuffer({
            msg: payloadMessage[0],
            name: payloadMessage[1],
            color: payloadMessage[2],
            timestamp: payloadMessage[3],
            mqttId: payloadMessage[4],
          });
        }
        if (topic === `online/message/${client.options.clientId}`) {
          console.log("New MSG:", payloadMessage);
          setNewQueueMsg({
            msg: payloadMessage[0],
            name: payloadMessage[1],
            color: payloadMessage[2],
          });
        }

        if (topic.includes("online/response")) {
          const id = topic.split("/")[2];
          sendQueuedMsg(id);
        }
        if (topic === `online/${client.options.clientId}`) {
          client.publish(
            `online/response/${client.options.clientId}`,
            "response"
          );
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
    if (usersQueue[clientId]) {
      usersQueue[clientId].push(msg);
    } else {
      usersQueue[clientId] = [];
      usersQueue[clientId].push(msg);
    }
    sendAllMessages(clientId);
  }

  function publishInFeed(msg) {
    publish(
      "feed",
      `${msg}&${user.name}&${user.color}&${Date.now()}&${
        client.options.clientId
      }`
    );
  }

  function publishNewConnection(msg) {
    publish("connection/new", `${user.name}`);

    client.subscribe("messages/queue", function (err) {
      if (err) {
        console.log(err);
      }
    });
    client.subscribe("feed", function (err) {
      if (err) {
        console.log(err);
      }
    });
    client.subscribe(`online/${client.options.clientId}`, function (err) {
      if (err) {
        console.log(err);
      }
    });

    client.subscribe(
      `online/message/${client.options.clientId}`,
      function (err) {
        if (err) {
          console.log(err);
        }
      }
    );
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
          mqttId: payloadMessage[4],
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
        publishInPrivate,
        client,
        newQueueMsg,
      }}
    >
      {children}
    </MqttContext.Provider>
  );
};
export { MqttContextProvider };
export default MqttContext;
