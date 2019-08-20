package NetSocket;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;

import org.junit.Test;

public class InetTest {
	
	
	@Test
	public void test1() throws UnknownHostException {
		//获取本机Ip
		InetAddress ip = InetAddress.getLocalHost();
		System.out.println(ip);
		//获取主机名
		System.out.println(ip.getHostName());
		//获取ip地址
		System.out.println(ip.getHostAddress());
	}
	
	@Test
	public void test2() throws UnknownHostException {
		//获取本机Ip
		InetAddress ip = InetAddress.getByName("www.baidu.com");
		System.out.println(ip);
		//获取主机名
		System.out.println(ip.getHostName());
		//获取ip地址
		System.out.println(ip.getHostAddress());
	}
	
	@Test
	public void test3() throws UnknownHostException {
		//获取本机Ip
		InetSocketAddress ip = new InetSocketAddress("127.0.0.1",8082);
		System.out.println(ip.getHostName());
		//获取端口
		System.out.println(ip.getPort());
		System.out.println(ip.getHostString());
		//返回类对象
		InetAddress address = ip.getAddress();
	}
	
	//测试URL类
	@Test
	public void URLTest() throws UnknownHostException, MalformedURLException {
		URL url = new URL("https://www.bilibili.com/");
		//获取授权部分的url
		System.out.println(url.getAuthority());
		//获取url的文件名
		System.out.println(url.getFile());
		//获取端口
		System.out.println(url.getPort());
		//获取主机号
		System.out.println(url.getHost());
		//获取默认端口
		System.out.println(url.getDefaultPort());
		//获取路径
		System.out.println(url.getPath());
		//获取userinfo
		System.out.println(url.getUserInfo());
	}
	
	
}
