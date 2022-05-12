package com.mycompany.app;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import java.util.ArrayList; 

public class App implements MqttCallback
{
    MqttClient client;
    ArrayList<String> messages = new ArrayList<String>(); 
    public static void main( String[] args )
    {
        // System.out.println( "Hello World!!!!AA" );
        App app = new App();
        app.doDemo();
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
    public void messageArrived(String topic, MqttMessage message)
            throws Exception {

                if(topic.equals("connection/new")){
                    
            MqttMessage msg = new MqttMessage();
            String a = "";
            for(int i = 0;i < this.messages.size();i++){
                a = a + this.messages.get(i);
                if(i < this.messages.size() - 1){
                    a = a + "¿";
                }
            }
            if(!a.equals("")){
                msg.setPayload(a.toString().getBytes());
                client.publish("messages/queue", msg);   
            }
        }
        
        if(topic.equals("feed")){
            this.messages.add(message.toString());
            
        }
        System.out.println(topic);
        System.out.println(this.messages);   
    }

    @Override
    public void deliveryComplete(IMqttDeliveryToken token) {
        // TODO Auto-generated method stub

    }
}
