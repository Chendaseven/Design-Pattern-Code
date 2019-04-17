package b_ObserverPattern.UsePerTemplate;

import java.util.ArrayList;
import java.util.List;

/*
 * @author Chenpeng
 * @date
 * @param  * @param null
 * @return
 * 被观察者，也就是微信公众号服务
 * Subject，Subject
 */
public class WechatServer implements Subject{
    //注意到这个List集合的泛型参数为Observer接口，设计原则：面向接口编程而不是面向实现编程
    private List<Observer> list;
    private String message;

    public WechatServer(){
        list = new ArrayList<Observer>();
    }


    public void registerObserver(Observer o) {
        list.add(o);
    }

    public void removeObserver(Observer o) {
        if(!list.isEmpty()){
            list.remove(o);
        }
    }
    //遍历
    public void notifyObserver() {
        for(int i = 0; i < list.size(); i++) {
            Observer oserver = list.get(i);
            oserver.update(message);
        }
    }

    //设置message
    public void setMessage(String message) {
        this.message = message;
        System.out.println("微信的消息为："+message);
        notifyObserver();
    }
}
