package b_ObserverPattern.UseJavaTemplate;


import java.util.Observable;
import java.util.Observer;

public class User2 implements Observer {
    private String name;
    private String message;
    Observable observable;
    //创建构造观察者构造函数，每构造一个观察者将会把该对象添加到观察者数组中（将每一个observe加入到其中）
    public User2(String name,Observable observable) {
        this.observable = observable;
        observable.addObserver(this);
        this.name = name;
    }

    public void update(Observable o, Object arg) {
        if(o instanceof WechatServer2){
            WechatServer2 wechatServer = (WechatServer2)o;
            this.observable = o;
            this.message = wechatServer.getMessage();
            read();

        }
    }

    //    public void update(String message) {
//        this.message = message;
//        read();
//    }

    public void read(){
        System.out.println(name + "收到的消息为："+ message);
    }


}
