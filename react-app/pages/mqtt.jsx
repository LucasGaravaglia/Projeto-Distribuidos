import React, { useEffect, useState } from "react";
import mqtt from "mqtt";

export default () => {
  const [connectionStatus, setConnectionStatus] = React.useState(false);
  const [messages, setMessages] = React.useState([]);
  const [client, setClient] = useState(mqtt.connect("mqtt://127.0.0.1:9001"));

  useEffect(() => {
    client.on("connect", () => setConnectionStatus(true));
    client.on("message", (topic, payload, packet) => {
      console.log("new msg");
      setMessages([...messages, messages.concat(payload.toString())]);
    });
  }, []);

  useEffect(() => {
    console.log(client);
    client.subscribe("foo");
  }, [client]);

  return (
    <>
      {messages.map((message, i) => {
        console.log(messages);
        return <h2 key={i}>{message}</h2>;
      })}

      <button
        onClick={() => {
          console.log(client);
        }}
      >
        Mostrar
      </button>
    </>
  );
};
