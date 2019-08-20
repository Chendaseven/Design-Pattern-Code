package NetSocket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

import org.junit.Test;


public class UDPReceive {
//	DatagramSocket：用于发送或接收数据包的套接字
//	DatagramPacket：数据包
	@Test
	public void receive() throws IOException {
		//1、开放一个端口
		DatagramSocket datagramSocket = new DatagramSocket(5051);
		//2、准备容器接收
		byte[] receiveBuf = new byte[100];
		//3、接受信息封包到容器
		DatagramPacket datagramPacket = new DatagramPacket(receiveBuf, receiveBuf.length);
		System.out.println("等待包裹发送过来");
		while(true) {
			//4、接受数据包
			datagramSocket.receive(datagramPacket);
			//5、解析数据包
			String receStr = new String(datagramPacket.getData(),0,datagramPacket.getLength());
			System.out.println("收到了："+receStr);
			if(receStr.equals("exut")) {
				break;
			}
			
		}
		datagramSocket.close();
 	}
}
