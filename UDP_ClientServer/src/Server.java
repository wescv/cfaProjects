import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.*;

public class Server {



    private static InetAddress host;
    private static String hostName;
    private static int portNumber;
    private static String receivedMessage;
    private static String sentMessage;
    public static void main(String[] args) throws IOException {


        DatagramSocket socket = new DatagramSocket(8085);
        //portNumber = 8080;
       // System.out.println(portNumber);
        host = InetAddress.getLocalHost();
        System.out.println(host);

        byte[] sendBuffer = new byte[1024];
        byte[] recieveBuffer = new byte[1024];

        DatagramPacket receivePacket = new DatagramPacket(recieveBuffer, recieveBuffer.length);
        socket.receive(receivePacket);
        recieveBuffer = receivePacket.getData();
        receivedMessage = new String(recieveBuffer, 0, recieveBuffer.length);
        DatagramPacket sendPacket = new DatagramPacket(sendBuffer, sendBuffer.length, inteAddress.getByName(hostName), portNumber);
        socket.send(sendPacket);

        System.out.println("Received message: " + receivedMessage + ".");


    }
}
