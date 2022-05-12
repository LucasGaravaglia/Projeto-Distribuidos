package com.mycompany.app;

import org.jgroups.JChannel;
import org.jgroups.Message;
import org.jgroups.Receiver;
import org.jgroups.ObjectMessage;


public class Client implements Receiver {
    JChannel channel;
    public static void main (String[] args) throws Exception{
        System.out.println("ClientAAAA");

        Client c = new Client();
        c.connect();
        c.sendMsg("AAIAIAIAIAI");
    }

    public void receive(Message msg) {
        String a = (String) msg.getObject();
        System.out.println(a);
    }

    private void connect() throws Exception {
        channel = new JChannel().setReceiver(this).connect("dashboard"); // use the default config, udp.xml
    }

    private void sendMsg(String a) throws Exception{
        Message msg = new ObjectMessage(null, a);
        this.channel.send(msg);
    }
}
