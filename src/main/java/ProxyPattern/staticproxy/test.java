package ProxyPattern.staticproxy;

import java.lang.reflect.Proxy;
import java.util.Date;

import org.junit.Test;

import ProxyPattern.CglibProxy.CglibProxy;
import ProxyPattern.DynamicProxy.DynamicProxyHandler;
import ProxyPattern.reflect.User;

public class test {
	@Test
	public void test() {
		BuyHouse buyHouse = new BuyHouseImpl();
		buyHouse.buyHouse();
		BuyHouseProxy buyHouseProxy = new BuyHouseProxy(buyHouse);
		buyHouseProxy.buyHouse();
	}
	
	// 测试动态代理
	/*
	 * 注意Proxy.newProxyInstance()方法接受三个参数：
	 * ClassLoader loader:指定当前目标对象使用的类加载器,获取加载器的方法是固定的 Class<?>[]
	 * interfaces:指定目标对象实现的接口的类型,使用泛型方式确认类型
	 * InvocationHandler:指定动态处理器，执行目标对象的方法时,会触发事件处理器的方法
	 */
	@Test
	public void test1() {
		BuyHouse buyHouse = new BuyHouseImpl();
		BuyHouse proxyBuyHouse = (BuyHouse) Proxy.newProxyInstance(BuyHouse.class.getClassLoader(), new
		             Class[]{BuyHouse.class}, new DynamicProxyHandler(buyHouse));
		proxyBuyHouse.buyHouse();
	}
	
	//测试CGLIB
	@Test
	public void test3(){
		BuyHouse buyHouse = new BuyHouseImpl();
		CglibProxy cglibProxy = new CglibProxy();
		BuyHouseImpl buyHouseCglibProxy = (BuyHouseImpl) cglibProxy.getInstance(buyHouse);
		buyHouseCglibProxy.buyHouse();
	}
	
	//测试反射
	@Test
	public void test4() {
		Date d = new Date();
		Class d1 = d.getClass();
		System.out.println(d1.getName());
		User user = new User("kobe","23");
		Class u = user.getClass();
		System.out.println(user.getName()+"===="+u.getName());
	}
	
	
}