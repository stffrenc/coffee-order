package edu.iu.stffrenc.coffeeorder.model;

public class Decaf extends Beverage{
    @Override
    public String getDescription() {
        return "Decaf";
    }
    @Override
    public float cost() {
        return 1.28F;
    }
}
