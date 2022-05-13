package com.mycompany.app;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import java.util.ArrayList;

public class App implements MqttCallback {

    JGroupsServer jSever = null;
    MqttClient client;
    Integer usersN = 0;
    ArrayList<String> messages = new ArrayList<String>();

    public static void main(String[] args) throws Exception {
        App app = new App();
        app.groups();
        app.doDemo();
    }

    public void groups() throws Exception {
        jSever = new JGroupsServer();
        jSever.connect();
    }

    public void doDemo() {
        try {
            client = new MqttClient("tcp://localhost:1883", "Sending");
            client.connect();
            client.setCallback(this);
            client.subscribe("feed");
            client.subscribe("connection/new");
        } catch (MqttException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void connectionLost(Throwable cause) {
        // TODO Auto-generated method stub

    }

    @Override
    public void messageArrived(String topic, MqttMessage message) throws Exception {

        if (topic.equals("connection/new")) {

            this.usersN++;

            MqttMessage msg = new MqttMessage();
            String a = "";

            for (int i = 0; i < this.messages.size(); i++) {
                a = a + this.messages.get(i);

                if (i < this.messages.size() - 1) {
                    a = a + "¿";
                }
            }

            if (!a.equals("")) {
                msg.setPayload(a.toString().getBytes());
                client.publish("messages/queue", msg);
            }
        }

        if (topic.equals("feed")) {
            this.messages.add(message.toString());
        }

        if (jSever != null) {

            String dashboardData = this.usersN.toString() + "&" + this.messages.size();
            if (topic.equals("feed")) {
                this.jSever.sendMsg(
                        dashboardData + "&" + message.toString().split("&")[1] + " "
                                + message.toString().split("&")[0]);
            } else {
                this.jSever.sendMsg(dashboardData);

            }

        }

        System.out.println(topic);
        System.out.println(this.messages);
    }

    @Override
    public void deliveryComplete(IMqttDeliveryToken token) {
        // TODO Auto-generated method stub

    }

}
