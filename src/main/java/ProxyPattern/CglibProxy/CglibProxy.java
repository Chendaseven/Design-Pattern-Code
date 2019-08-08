package ProxyPattern.CglibProxy;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class CglibProxy implements MethodInterceptor{
	
		private Object target;
		
		public Object getInstance(final Object target) {
		     this.target = target;
		     Enhancer enhancer = new Enhancer();
		     enhancer.setSuperclass(this.target.getClass());
		     enhancer.setCallback(this);
		     return enhancer.create();
		 }
			 
		
		@Override
		public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
			System.out.println("买房前准备");
		     Object result = proxy.invokeSuper(obj, args);
		     System.out.println("买房后装修");
		     return result;
		}
}
