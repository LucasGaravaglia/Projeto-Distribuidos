import React, { createContext, useState, useEffect, useContext } from "react";
import mqtt from "mqtt";
import AuthContext from "./AuthContext";
const MqttContext = createContext();

const MqttContextProvider = ({ children }) => {
  const [client, setClient] = useState(null);
  const [connectStatus, setConnectStatus] = useState(false);
  const [msgBuffer, setMsgBuffer] = useState(null);
  const [tweetsList, setTweetsList] = useState([]);

  const { user, isAuthenticated } = useContext(AuthContext);

  const mqttConnect = (host, mqttOption) => {
    // setConnectStatus("Connecting");
    setClient(mqtt.connect(host, mqttOption));
  };
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
        setConnectStatus("Reconnecting");
      });
      client.on("message", (topic, message) => {
        const payload = { topic, message: message.toString() };
        const payloadMessage = payload.message.split("&");

        setMsgBuffer({
          msg: payloadMessage[0],
          userName: payloadMessage[1],
          userEmail: payloadMessage[2],
          photoUrl: payloadMessage[3],
          timestamp: payloadMessage[4],
        });
      });
    }
  }, [client]);

  function publishInFeed(msg) {
    client.subscribe("feed", function (err) {
      if (!err) {
        client.publish(
          "feed",
          `${msg}&${user.displayName}&${user.email}&${
            user.photoURL
          }&${Date.now()}`
        );
      }
    });
  }

  function connectMqtt() {
    mqttConnect("mqtt://127.0.0.1:9001");
  }

  useEffect(() => {
    if (!!msgBuffer) {
      setTweetsList((t) => [msgBuffer, ...t]);
    }
  }, [msgBuffer]);
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
