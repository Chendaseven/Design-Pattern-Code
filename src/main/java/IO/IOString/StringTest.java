package IO.IOString;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.junit.Test;

public class StringTest {
	/**
	 * Reader字符输入流 
		Writer字符输出流 
		专门用于字符的形式读取和写入数据
	 */
	@Test
	public void test1() {
		// 准备文件lol.txt其中的内容是AB
        File f = new File("G:\\temp\\lol.txt");
        // 创建基于文件的Reader
        try (FileReader fr = new FileReader(f)) {
            // 创建字符数组，其长度就是文件的长度
            char[] all = new char[(int) f.length()];
            // 以字符流的形式读取文件所有内容
            fr.read(all);
            for (char b : all) {
                // 打印出来是A B
                System.out.println(b);
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
	}
	
	//写入文件
	@Test
	public void test2() {
		// 准备文件lol2.txt
        File f = new File("G:\\temp\\lol2.txt");
        // 创建基于文件的Writer
        try (FileWriter fr = new FileWriter(f)) {
            // 以字符流的形式把数据写入到文件中
            String data="abcdefg1234567890";
            char[] cs = data.toCharArray();
            fr.write(cs);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
	}

}
