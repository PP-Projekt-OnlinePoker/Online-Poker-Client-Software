package de.szut.onlinepoker.communication;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class Protocoll {

	public final int PORT = 6666;
	
	private Socket sock;
	private OutputStream out;
	private InputStream in;
	
	public Protocoll(InetAddress ip) throws IOException{

		sock = new Socket(ip, PORT);
		out = sock.getOutputStream();
			
		
	}
	
	public void sendPacket(String jsonObj) throws IOException{
		out.write(jsonObj.getBytes());
	}
	
	
	
}



