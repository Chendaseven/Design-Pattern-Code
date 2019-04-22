package c_DecoratorPattern.Beverage;



//实现具体饮料描述：Espresso
public class Espresso extends Beverage {
    public Espresso(){
        description="Espresso";
    }

    //定义Espresso的价格
    public double cost(){
        return 1.99;
    }
}
