package NetSocket;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

import org.junit.Test;

public class TCPServer {
	
	@Test
	public void serverTest() throws IOException {
		//服务器开启一个监听端口
		ServerSocket serverSocket = new ServerSocket(6666);
		System.out.println("开启服务器");
		while(true) {
			//等待客户端链接
			Socket socket = serverSocket.accept();
			System.out.println("有一个链接过来了");
			//获得客户端的输入
			InputStream inputStream = socket.getInputStream();
			//包装成DataInputStream流
			DataInputStream dataInputStream = new DataInputStream(inputStream);
			//通过流读取信息
			String s = dataInputStream.readUTF();
			System.out.println(s);
		}
	}
}
