package IO;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.junit.Test;

public class IOsubject {
	
	//1、创建一个文件对象
	@Test
	public void test1() {
		//绝对路径
		File f1 = new File("G:/temp");
		System.out.println("f1的绝对路径："+f1.getAbsolutePath());
		//相对路径
		File f2 = new File("apply.jsp");
		System.out.println("f2的绝对路径："+f2.getAbsolutePath());
		
		//把f1作为父目录创建文件对象
		File f3 = new File(f1,"apply1.jsp");
		System.out.println("f3的绝对路径："+f3.getAbsolutePath());
	}
	
	//文件对象的常用方法
	@Test
	public void test2() {
		File f1 = new File("G:/temp/apply.jsp");
		System.out.println("当前文件是："+f1);
		//判断文件是否存在
		System.out.println("文件是否存在："+f1.exists());
		//是否是文件夹	以下方法仅针对文件存在的情况下
		System.out.println("是否是文件夹："+f1.isDirectory());
		//是否是文件
		System.out.println("是否是文件："+f1.isFile());
		//文件长度
		System.out.println("文件长度："+f1.length());
		//文件最后修改时间
		long time = f1.lastModified();
		Date Time = new Date(time);
		System.out.println(Time);
		//设置文件修改时间
//		f1.setLastModified(0);
		
		//文件重命名
		File f2 = new File("G:/temp/frame.jsp");
		System.out.println(f2.renameTo(f1));
		System.out.println("把frame改名为apply");
		
		System.out.println("注意： 需要在D:\\LOLFolder确实存在一个LOL.exe,\r\n才可以看到对应的文件长度、修改时间等信息");
	}
	
	//文件对象的常用方法2
	@Test
	public void test3() {
		File f = new File("G:/temp");
		File f2 = new File("G:/temp/frame.jsp");
		File f3 = new File("G:/temp/temp.jsp");
        // 以字符串数组的形式，返回当前文件夹下的所有文件（文件及文件夹名）
		System.out.println("以字符串数组形式");
        f.list();
        for (String file : f.list()) {
			System.out.println(file);
		}
        // 以文件数组的形式，返回当前文件夹下的所有文件（文件及文件夹）
        System.out.println("以文件数组形式");
        File[] fs= f.listFiles();
        for (File file : fs) {
			System.out.println(file);
		}
        
        //获取文件所在文件夹
        System.out.println("以字符串形式返回所在文件夹："+f2.getParent());
        System.out.println("以文件形式返回获取所在文件夹："+f2.getParentFile());
        
        // 创建文件夹，如果父文件夹temp不存在，创建就无效,以temp.jsp命名的文件夹
        f3.mkdir();
        // 创建文件夹，如果父文件夹temp不存在，就会创建父文件夹  以temp.jsp命名的文件夹
        f3.mkdirs();
        // 创建一个空文件,如果父文件夹temp不存在，就会抛出异常 以temp.jsp命名的文件夹
        try {
        	f3.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        // 所以创建一个空文件之前，通常都会创建父目录
        f3.getParentFile().mkdirs();
        
        // 列出所有的盘符c: d: e: 等等
        f.listRoots();
        for (File file : f.listRoots()) {
			System.out.println(file);
		}
        // 刪除文件
        //f.delete();
        // JVM结束的时候，刪除文件，常用于临时文件的删除
       // f.deleteOnExit();
        
        System.out.println("遍历C盘WINDOWS下所有文件，找出最大最小");
        File f1 = new File("C:/Windows/");
        File[] f1s= f1.listFiles();
        String maxFileName = null;
        String minFileName = null;
        long maxFile = f1s[0].length();
        long minFile = f1s[0].length();
        
        for (File file : f1s) {
        	if(file.isFile()) {
        		if(file.length()>= maxFile) {
            		maxFile = file.length();
            		maxFileName=file.getName();
            	}else if(file.length()<minFile) {
            		minFile=file.length();
            		minFileName=file.getName();
            	}
    			System.out.println(file);
        	}
		}
        System.out.println("最大的文件是："+maxFileName+"，文件大小为："+maxFile);
        System.out.println("最小的文件是："+minFileName+"，文件大小为："+minFile);
	}
	
}
