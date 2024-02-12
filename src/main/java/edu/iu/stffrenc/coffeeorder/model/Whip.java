package edu.iu.stffrenc.coffeeorder.model;

public class Whip extends CondimentDecorator{

    public Whip(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public float cost() {
        return  beverage.cost() + 0.3F;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Whip";
    }
}