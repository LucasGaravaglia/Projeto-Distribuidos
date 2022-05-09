import mqtt from "mqtt";
import { useEffect, useState } from "react";
// const client = mqtt.connect("mqtt://127.0.0.1");

// client.on("connect", function () {
//   console.log("connect");
// });

export default function Mqtt() {
  const [client, setClient] = useState(null);
  const [connectStatus, setConnectStatus] = useState(null);

  const mqttConnect = (host, mqttOption) => {
    setConnectStatus("Connecting");
    setClient(mqtt.connect(host));
  };

  useEffect(() => {
    if (client) {
      console.log(client);
      client.on("connect", () => {
        setConnectStatus("Connected");
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
        setPayload(payload);
      });
    }
  }, [client]);

  function onClick() {
    mqttConnect("mqtt://127.0.0.1:1883");
  }

  return (
    <div>
      <h1>Helle</h1>
      <button onClick={onClick}>Hello</button>
    </div>
  );
}
