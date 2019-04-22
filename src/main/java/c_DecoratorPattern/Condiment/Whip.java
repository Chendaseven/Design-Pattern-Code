package c_DecoratorPattern.Condiment;

import c_DecoratorPattern.Beverage.Beverage;

public class Whip extends CondimentDecorator{
    Beverage beverage;
    public Whip(Beverage beverage){
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ",Whip";
    }

    @Override
    public double cost() {
        return 0.5 + beverage.cost();
    }
}
