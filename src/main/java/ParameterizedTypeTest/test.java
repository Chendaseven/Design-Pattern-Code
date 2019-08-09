package ParameterizedTypeTest;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import org.junit.Test;

/**
 * 测试ParameterizedType API
 * @author Administrator
 *	Type[] getActualTypeArguments();

    Type getRawType();

    Type getOwnerType();
 */
public class test {
	
	//测试那些是属于ParameterizedType,型如List<String>的类型才属于ParameterizedType
	@Test
	public void test1() {
		Field[] fields = ParameterizedBean.class.getDeclaredFields();
		for(Field f:fields){
		    //是否是ParameterizedType
		    System.out.print(f.getName()+":"+(f.getGenericType() instanceof ParameterizedType)+"\n");
		}
	}
	
	
	//测试getActualTypeArguments方法,获取变量class<T> T的类型
	@Test
	public void test2() {
		Field[] fields = ParameterizedBean.class.getDeclaredFields();
		for(Field f:fields){
		    if(f.getGenericType() instanceof ParameterizedType){
		        ParameterizedType pType =(ParameterizedType) f.getGenericType();
		        System.out.print("变量："+pType.getTypeName()+"     ");
	            Type[] types =pType.getActualTypeArguments();
	            for(Type t:types){
	            	System.out.print("类型："+t.getTypeName()+"  ");
	            }
	            System.out.println("\n");
		    }
		}
	}
	
	//测试getRawType方法,获取class的类型
	@Test
	public void test3() {
		Field[] fields =  ParameterizedBean.class.getDeclaredFields();
	    for(Field f:fields){
		    if(f.getGenericType() instanceof ParameterizedType){
		        ParameterizedType pType = (ParameterizedType) f.getGenericType();
		        System.out.print("变量："+f.getName());
		        System.out.print("RawType："+pType.getRawType().getTypeName()+"\n");
		    }
	    }
	}
	
	//测试getOwnerType方法,如果是顶级类型，那么返回null
	@Test
	public void test4() {
		Field[] fields =  ParameterizedBean.class.getDeclaredFields();
	    for(Field f:fields){
		    if(f.getGenericType() instanceof ParameterizedType){
		        ParameterizedType pType = (ParameterizedType) f.getGenericType();
		        System.out.print("变量："+f.getName());
		        Type t = pType.getOwnerType();
		        if(t == null){
		        	System.out.print("OwnerType:Null     ");
		        }else{
		        	System.out.print("OwnerType："+t.getTypeName());
		        }
		    }
		}
	}
}
