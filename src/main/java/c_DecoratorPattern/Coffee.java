package c_DecoratorPattern;

import c_DecoratorPattern.Beverage.Beverage;
import c_DecoratorPattern.Beverage.Espresso;
import c_DecoratorPattern.Condiment.Mocha;
import c_DecoratorPattern.Condiment.Whip;
import org.junit.Test;

public class Coffee {

    @Test
    public void coffeeTest(){
        //订一杯Espresso，不需要调料
        Beverage beverage = new Espresso();
        System.out.println("订购的饮料是："+beverage.getDescription() + ","+"价格为："+beverage.cost());
    }

    //利用Condiment装饰饮料
    //搭配一杯两份mocha和一份whip的Espresso，并计算价格
    @Test
    public void coffeeTest2(){
        Beverage beverage = new Espresso();
        //使用Mocha装饰Espresso
        beverage = new Mocha(beverage);
        //使用第二个Mocha装饰Espresso
        beverage = new Mocha(beverage);
        //使用Whip装饰Espresso
        beverage = new Whip(beverage);
        System.out.println("订购的饮料是:"+beverage.getDescription()+",价格为："+beverage.cost());
    }
}
