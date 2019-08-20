package NetSocket;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import org.junit.Test;

public class TCPClient {
	@Test
	public void ClientTest() throws IOException{
		//创建同一连接
        Socket s = new Socket("127.0.0.1",6666);
        DataOutputStream dos = new DataOutputStream(s.getOutputStream());
        dos.writeUTF("hello,world！");

	}
}
