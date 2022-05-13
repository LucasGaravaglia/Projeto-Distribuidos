package com.mycompany.app;

import org.jgroups.JChannel;
import org.jgroups.Message;
import org.jgroups.ObjectMessage;

public class JGroupsServer {
    JChannel channel;

    // public static void main(String[] args) throws Exception{
    // JGroupsServer s = new JGroupsServer();
    // s.connect();
    // }

    public void connect() throws Exception {
        channel = new JChannel();
        channel.connect("dashboard");
    }

    public void sendMsg(String a) throws Exception {
        Message msg = new ObjectMessage(null, a);
        this.channel.send(msg);
    }
}
