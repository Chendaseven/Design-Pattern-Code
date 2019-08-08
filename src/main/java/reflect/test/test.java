package reflect.test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.Test;

import reflect.bean.Student;

public class test {
	
	/**
	 * 获取class对象的三种方式
	 */
	@Test
	public void test1() {
//		1、object——>getClass()
		Student stu = new Student();
		Class stuClass1 = stu.getClass();
		System.out.println(stuClass1.getName());
//		2、使用静态数据类型
		Class stuClass2 = Student.class;
		System.out.println(stuClass2.getName());
//		3、使用真实路径获取class对象————常用方法
		try {
			Class stuClass3 = Class.forName("reflect.bean.Student");
			System.out.println(stuClass3.getName());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 通过反射获取构造方法
 
 * 通过Class对象可以获取某个类中的：构造方法、成员变量、成员方法；并访问成员； 
 *  
 * 1.获取构造方法： 
 *      1).批量的方法： 
 *          public Constructor[] getConstructors()：所有”公有的”构造方法 
            public Constructor[] getDeclaredConstructors()：获取所有的构造方法(包括私有、受保护、默认、公有) 
      
 *      2).获取单个的方法，并调用： 
 *          public Constructor getConstructor(Class… parameterTypes):获取单个的”公有的”构造方法： 
 *          public Constructor getDeclaredConstructor(Class… parameterTypes):获取”某个构造方法”可以是私有的，或受保护、默认、公有； 
 *       
 *          调用构造方法： 
 *          Constructor–>newInstance(Object… initargs) 
	 * @throws ClassNotFoundException 
	 * @throws SecurityException 
	 * @throws NoSuchMethodException 
	 * @throws InvocationTargetException 
	 * @throws IllegalArgumentException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
 */  
	@Test
	public void test2() throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		//加载class对象
		Class clazz = Class.forName("reflect.bean.Student");
		
		//1、获取所有的公有构造方法
		System.out.println("=======所有公有构造方法========");
		Constructor[] constructors = clazz.getConstructors();
		for (Constructor constructor : constructors) {
			System.out.println(constructor);
		}
		
		//2、获取所有构造方法（包括私有、受保护等等）
		System.out.println("=======所有构造方法========");
		Constructor[] declaredConstructors = clazz.getDeclaredConstructors();
		for (Constructor constructor : declaredConstructors) {
			System.out.println(constructor);
		}
		
		//3、获取公有、无参的构造方法
		System.out.println("*****************获取公有、无参的构造方法*******************************");
		//1>、因为是无参的构造方法所以类型是一个null,不写也可以：这里需要的是一个参数的类型，切记是类型  
        //2>、返回的是描述这个无参构造函数的类对象。
		Constructor constructor = clazz.getConstructor(null);
		System.out.println("con="+constructor);
		//调用构造方法  
        Object obj = constructor.newInstance();  
		
        //4、获取私有构造方法
        System.out.println("******************获取私有构造方法，并调用*******************************");
        Constructor con = clazz.getConstructor(char.class);
        System.out.println(con);  
        //调用构造方法  
        con.setAccessible(true);//暴力访问(忽略掉访问修饰符)  
        obj = con.newInstance('男');  
        
	}
	
	/**
	 * 获取所有成员变量
 *1.批量的 
 *      1).Field[] getFields():获取所有的”公有字段” 
 *      2).Field[] getDeclaredFields():获取所有字段，包括：私有、受保护、默认、公有； 
 * 2.获取单个的： 
 *      1).public Field getField(String fieldName):获取某个”公有的”字段； 
 *      2).public Field getDeclaredField(String fieldName):获取某个字段(可以是私有的) 
 *  
 *   设置字段的值： 
 *      Field –> public void set(Object obj,Object value): 
 *                  参数说明： 
 *                  1.obj:要设置的字段所在的对象； 
 *                  2.value:要为字段设置的值；
	 * @throws ClassNotFoundException 
	 * @throws Exception 
	 * @throws NoSuchFieldException 
	 */
	@Test
	public void test3() throws ClassNotFoundException, NoSuchFieldException, Exception {
		//加载class对象
		Class clazz = Class.forName("reflect.bean.Student");
		//1、获取所有公有字段
		System.out.println("************获取所有公有的字段********************");  
		Field[] fields = clazz.getFields();
		for (Field field : fields) {
			System.out.println(field);
		}
		
		//2、获取所有字段
		System.out.println("************获取所有字段********************");
		Field[] declaredFields = clazz.getDeclaredFields();
		for (Field field : declaredFields) {
			System.out.println(field);
		}
		
		//3、获取字段并调用
		System.out.println("*************获取公有字段**并调用***********************************");  
		Field f = clazz.getField("name");  
        System.out.println(f);  
        //获取一个对象  
        Object obj = clazz.getConstructor().newInstance();//产生Student对象–》Student stu = new Student();  
        //为字段设置值  
        f.set(obj, "刘德华");//为Student对象中的name属性赋值–》stu.name = ”刘德华”  
        //验证  
        Student stu = (Student)obj;  
        System.out.println("验证姓名：" + stu.name);  
        
        //4、获取私有字段并调用
        System.out.println("*************获取私有字段并调用***********************************");
        f = clazz.getDeclaredField("phoneNum");
        System.out.println(f);
        f.setAccessible(true);//暴力反射，解除私有限定  
        f.set(obj, "18888889999"); 
        System.out.println("验证电话：" + stu);
	}
	
	//获取成员方法并调用
//		1.批量的：
//	 *      public Method[] getMethods():获取所有"公有方法"；（包含了父类的方法也包含Object类）
//	 *      public Method[] getDeclaredMethods():获取所有的成员方法，包括私有的(不包括继承的)
//	 * 2.获取单个的：
//	 *      public Method getMethod(String name,Class<?>... parameterTypes):
//	 *                  参数：
//	 *                      name : 方法名；
//	 *                      Class ... : 形参的Class类型对象
//	 *      public Method getDeclaredMethod(String name,Class<?>... parameterTypes)
//	 * 
//	 *   调用方法：
//	 *      Method --> public Object invoke(Object obj,Object... args):
//	 *                  参数说明：
//	 *                  obj : 要调用方法的对象；
//	 *                  args:调用方式时所传递的实参
	@Test
	public void test4() throws Exception, SecurityException {
		//1.获取Class对象
        Class stuClass = Class.forName("reflect.bean.Student");
        //2.获取所有公有方法
        System.out.println("***************获取所有的”公有“方法*******************");
        stuClass.getMethods();
        Method[] methodArray = stuClass.getMethods();
        for(Method m : methodArray){
            System.out.println(m);
        }
        System.out.println("***************获取所有的方法，包括私有的*******************");
        methodArray = stuClass.getDeclaredMethods();
        for(Method m : methodArray){
            System.out.println(m);
        }
        System.out.println("***************获取公有的show1()方法*******************");
        Method m = stuClass.getMethod("show1", String.class);
        System.out.println(m);
        //实例化一个Student对象
        Object obj = stuClass.getConstructor().newInstance();
        m.invoke(obj, "刘德华");

        System.out.println("***************获取私有的show4()方法******************");
        m = stuClass.getDeclaredMethod("show4", int.class);
        System.out.println(m);
        m.setAccessible(true);//解除私有限定
        Object result = m.invoke(obj, 20);//需要两个参数，一个是要调用的对象（获取有反射），一个是实参
        System.out.println("返回值：" + result);
	}
	
	/**
	 * 获取main方法
	 * @throws Exception 
	 * 
	 */
	@Test
	public void test5() throws Exception {
		//1、获取Student对象的字节码
		Class clazz = Class.forName("reflect.bean.Student");
		
		//2、获取main方法
		Method methodMain = clazz.getMethod("main", String[].class);//第一个参数：方法名称，第二个参数：方法形参的类型，
		//3、调用main方法
		// methodMain.invoke(null, new String[]{"a","b","c"});
		//第一个参数，对象类型，因为方法是static静态的，所以为null可以，第二个参数是String数组，这里要注意在jdk1.4时是数组，jdk1.5之后是可变参数
		//这里拆的时候将  new String[]{"a","b","c"} 拆成3个对象。。。所以需要将它强转。
		methodMain.invoke(null, (Object)new String[]{"a","b","c"});//方式一
		// methodMain.invoke(null, new Object[]{new String[]{"a","b","c"}});//方式二
	}
	
	
}
