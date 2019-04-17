package b_ObserverPattern.UseJavaTemplate;

import java.util.Observable;
import java.util.Observer;

public class WechatServer2 extends Observable {

    private String message;

    public WechatServer2(){};

    public String getMessage() {
        return message;
    }

    //在调用notifyObservers之前需要先调用setChanged来指示状态已经改变
    public void measurementsChanged(){
        setChanged();
        notifyObservers();
    }

    public void setMeasurements(String message){
        this.message = message;
        measurementsChanged();
    }

    @Override
    public synchronized void addObserver(Observer o) {
        super.addObserver(o);
    }

    @Override
    public synchronized void deleteObserver(Observer o) {
        super.deleteObserver(o);
    }
    //此方法会循环观察者数组，会调用每个观察者的update方法
    @Override
    public void notifyObservers() {
        super.notifyObservers();
    }

    @Override
    protected synchronized void setChanged() {
        super.setChanged();
    }
}
