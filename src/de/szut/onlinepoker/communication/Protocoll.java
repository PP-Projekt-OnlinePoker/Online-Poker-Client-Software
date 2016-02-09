package de.szut.onlinepoker.communication;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

import de.szut.onlinepoker.controller.Controller;

public class Protocoll {

	
	private Socket sock;
	private OutputStream out;
	private InputStream in;
	private UpdateRecieveHandler upr;
	private RecieveHandler re;
	
	public Protocoll(String ip, int port) throws IOException{

		sock = new Socket(ip, port);
		out = sock.getOutputStream();
		in = sock.getInputStream();
		PacketSeperator ps = new PacketSeperator(in);
		re = new RecieveHandler(ps.getAnswerPipe());
		upr = new UpdateRecieveHandler(ps.getUpdatePipe());
		
		
	}
	
	public void sendPacket(String jsonObj) {
		try {
			out.write(jsonObj.getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			Controller.getInstance().error("no connection to server");
		}
	}
	
	public RecieveHandler getRecieveHandler(){
		return re;
	}
	
	public UpdateRecieveHandler getUpdateRecieveHandler(){
		return upr;
	}
	
}



