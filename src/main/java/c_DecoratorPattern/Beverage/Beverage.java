package c_DecoratorPattern.Beverage;

/*
 * @Author Chenpeng
 * @Date
 * @Param  * @param null
 * @return
 */
public abstract class Beverage {
    String description = "Unknown Beverage";


    public String getDescription(){
        return description;
    }

    //定义计算价格的方法，必须在子类中实现
    public abstract double cost();
}
