import java.io.*;
import java.net.*;

public class Server {
	public static void main(String args[]) throws Exception {
		ServerSocket sersock = new ServerSocket(3000);
		System.out.println("Server ready for chatting");
		Socket sock = sersock.accept();
		BufferedReader KeyRead = new BufferedReader(new InputStreamReader(System.in));
		OutputStream ofstream = sock.getOutputStream();
		PrintWriter pwrite = new PrintWriter(ofstream, true);
		InputStream istream = sock.getInputStream();
		BufferedReader receivedread = new BufferedReader(new InputStreamReader(istream));
		String receivemessage, sendmessage;
		while (true) {
			if ((receivemessage = receivedread.readLine()) != null) {
				System.out.println(receivemessage);
			}
			sendmessage = KeyRead.readLine();
			pwrite.println(sendmessage);
			System.out.flush();
		}
	}
}
