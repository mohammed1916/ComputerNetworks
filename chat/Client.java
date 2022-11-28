import java.io.*;
import java.net.*;

public class Client {
    public static void main(String args[]) throws Exception {
        Socket sock = new Socket("127.0.0.1", 3000);
        BufferedReader KeyRead = new BufferedReader(new InputStreamReader(System.in));
        OutputStream ofstream = sock.getOutputStream();
        PrintWriter pwrite = new PrintWriter(ofstream, true);
        InputStream istream = sock.getInputStream();
        BufferedReader receivedread = new BufferedReader(new InputStreamReader(istream));
        System.out.println("client ready for chatting");
        String receivemessage, sendmessage;
        while (true) {
            sendmessage = KeyRead.readLine();
            pwrite.println(sendmessage);
            System.out.flush();
            if ((receivemessage = receivedread.readLine()) != null) {
                System.out.println(receivemessage);
            }
        }
    }
}
