public class Main {
    public static void main(String[] args){
        System.out.println("Hello");

        JChannel channel=new JChannel("/home/bela/udp.xml");
        channel.setReceiver(new ReceiverAdapter() {
            public void receive(Message msg) {
                System.out.println("received msg from " + msg.getSrc() + ": " + msg.getObject());
            }
        });
        channel.connect("MyCluster");
        channel.send(new ObjectMessageSerializable(null, "hello world"));
        // channel.close();
    }
}
