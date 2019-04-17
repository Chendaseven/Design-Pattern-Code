package b_ObserverPattern.UsePerTemplate;




/**
 * 使用自己定义的观察者模式模型
 * 抽象被观察者接口，即定义主题
 *
 */
public interface Subject {
    public void registerObserver(Observer o);
    public void removeObserver(Observer o);
    public void notifyObserver();
}
