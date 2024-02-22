package edu.iu.stffrenc.coffeeorder.model;

public class Espresso extends Beverage{
    @Override
    public String getDescription() {
        return "Espresso";
    }
    @Override
    public float cost() {
        return 1.34F;
    }
}
