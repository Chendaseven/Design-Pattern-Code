package c_DecoratorPattern.Condiment;
/*
 * @Author Chenpeng
 * @Date
 * @Param  * @param null
 * @return
 */

import c_DecoratorPattern.Beverage.Beverage;

//定义调料装饰器，默认继承Beverage
public abstract class CondimentDecorator extends Beverage {
    //重构getDercription方法
    public abstract String getDescription();

}
