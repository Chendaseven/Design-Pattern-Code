package IO.IOStream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.imageio.stream.FileImageInputStream;

import org.junit.Test;

public class StreamTest {
	
//	InputStream字节输入流 
//	OutputStream字节输出流 
//	用于以字节的形式读取和写入数据
	
	@Test
	public void test() {
		File f1 = new File("G:/temp/apply.jsp");
		try {
			FileImageInputStream fis = new FileImageInputStream(f1);
			System.out.println(fis);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	/**
	 * InputStream是字节输入流，同时也是抽象类，只提供方法声明，不提供方法的具体实现。
	 * FileInputStream 是InputStream子类，以FileInputStream 为例进行文件读取
	 */
	@Test
	public void test1() {
		File f1 = new File("G:/temp/apply.jsp");
		//创建基于文件的输入流
		FileInputStream fileInputStream;
		try {
			fileInputStream = new FileInputStream(f1);
			//创建字节数组，其长度为文件的长度
			byte[] all = new byte[(int)f1.length()];
			//以字节流的形式读取文件所有内容
			fileInputStream.read(all);
			for (byte b : all) {
				System.out.println(b);
			}
			//每次使用完成将其关闭
			fileInputStream.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * OutputStream是字节输出流，同时也是抽象类，只提供方法声明，不提供方法的具体实现。
		FileOutputStream 是OutputStream子类，以FileOutputStream 为例向文件写出数据
	 */
	@Test
	public void test2() {
		try {
            // 准备文件lol2.txt其中的内容是空的
            File f = new File("G:/temp/lol.txt");
            // 准备长度是2的字节数组，用88,89初始化，其对应的字符分别是X,Y
            byte data[] = { 88, 89 };
            // 创建基于文件的输出流
            FileOutputStream fos = new FileOutputStream(f);
            // 把数据写入到输出流
            fos.write(data);
            // 关闭输出流
            fos.close();
             
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
	}
	
	//拆分文件，以100kb为单位
	@Test
	public void test3() {
		File file = new File("F:\\健身\\GZCLP+BOTB训练计划.xlsx");
		//System.out.println(file.exists());
		try {
			FileInputStream fis = new FileInputStream(file);
			FileOutputStream fos;
			int num=1;
			int len=0;
			byte[] b = new byte[102400];
			while((len=fis.read(b))>-1) {
				File fileT = new File("G:/temp/project-"+num);
				fos = new FileOutputStream(fileT);
				fos.write(b, 0,len);
				fos.close();
				num++;
				System.out.println("输出子文件："+fileT.getAbsolutePath()+",文件大小为："+fileT.length()+"字节");
			}
			fis.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//合并文件
	@Test
	public void test4() {
		try {
			File file = new File("G:\\temp\\7-17");
			File[] Files = file.listFiles();
			FileInputStream fis;
			FileOutputStream fos = new FileOutputStream("G:\\temp\\7-17\\temp.java");;
			for (File file2 : Files) {
				byte[] all = new byte[(int) file2.length()];
				
					fis = new FileInputStream(file2);
					fis.read(all);
					fos.write(all);
				}
			fos.close();
			}
			 catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			 }
		
	}
	
	
}
