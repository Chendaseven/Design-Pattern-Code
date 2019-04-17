package b_ObserverPattern.UseJavaTemplate;


import org.junit.Test;

import java.util.Observer;

/*
 * @author Chenpeng
 * @date
 * @param  * @param null
 * @return
 * 编写观察者模式测试类，
 */

public class TestFor2 {

    @Test
    public void test(){
        WechatServer2 wechatServer2 = new WechatServer2();
        //定义三个观察者
        //每构造一个观察者将会把该对象添加到观察者数组中，抽象主题中：wechatServer2
        Observer userZS = new User2("ZS",wechatServer2);
        Observer userLS = new User2("LS",wechatServer2);
        Observer userWW = new User2("WW",wechatServer2);

        //设置观察者信息
        //信息输出为逆序输出
        wechatServer2.setMeasurements("今天全体放假！");

        System.out.println("===================");
        //将其中一个观察者移除
        wechatServer2.deleteObserver(userWW);
        wechatServer2.setMeasurements("今天继续加班！");

    }



}
