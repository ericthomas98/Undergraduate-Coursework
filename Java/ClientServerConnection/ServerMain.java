import java.net.*;
import java.io.*;

public class ServerMain {

	public static void main(String[] args) throws IOException {

		ServerSocket serverSocket = new ServerSocket(4999);
		Socket socket = serverSocket.accept();
		
		System.out.println("Successfully connected to server");

	}
}
