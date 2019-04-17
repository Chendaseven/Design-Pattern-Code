package b_ObserverPattern.UsePerTemplate;

import org.junit.Test;

/*
 * @author Chenpeng
 * @date
 * @param  * @param null
 * @return
 * 编写观察者模式测试类，
 */

public class TestFor {

    @Test
    public void test(){
        WechatServer wechatServer = new WechatServer();
        //定义三个观察者
        Observer userZS = new User("ZS");
        Observer userLS = new User("LS");
        Observer userWW = new User("WW");

        //将观察者注册
        wechatServer.registerObserver(userZS);
        wechatServer.registerObserver(userLS);
        wechatServer.registerObserver(userWW);
        wechatServer.setMessage("今天全体放假！");

        System.out.println("===================");
        //将其中一个观察者移除
        wechatServer.removeObserver(userWW);
        wechatServer.setMessage("今天继续加班！");

    }



}
