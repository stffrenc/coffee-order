package edu.iu.stffrenc.coffeeorder.repository;

import edu.iu.stffrenc.coffeeorder.model.*;
import org.springframework.stereotype.Repository;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

@Repository
public class OrderRepository {
    private static final String DATABASE_FILE = "db.txt";
    public Receipt add(OrderData order) throws Exception {
        Random rand = new Random();
        Beverage beverage = null;
        switch (order.beverage().toLowerCase()) {
            case "dark roast":
                beverage = new DarkRoast();
                break;
            case "house blend":
                beverage = new HouseBlend();
                break;
            case "espresso":
                beverage = new Espresso();
                break;
            case "decaf":
                beverage = new Decaf();
                break;
        }
        if (beverage == null) {
            throw new Exception("Beverage type '%s' is not valid!".formatted(order.beverage()));
        }
        for(String condiment : order.condiments()) {
            switch (condiment.toLowerCase()) {
                case "milk":
                   beverage = new Milk(beverage);
                   break;
                case "mocha":
                    beverage = new Mocha(beverage);
                    break;
                case "soy":
                    beverage = new Soy(beverage);
                    break;
                case "whip":
                    beverage = new Whip(beverage);
                    break;
                default:
                    throw new Exception("Condiment type '%s' is not valid".formatted(condiment));
            }
        }
        int id = rand.nextInt(1000) + 1;
        Receipt receipt = new Receipt(id ,beverage.getDescription(), beverage.cost());
        try (FileWriter writer = new FileWriter(DATABASE_FILE, true)) {
            // Append the beverage information to the file
            writer.write(id + ", " + beverage.getDescription() + ", " + beverage.cost() + "\n");
            System.out.println("Beverage added to the database.");
        } catch (IOException e) {
            System.out.println("Error writing to the database file.");
            e.printStackTrace();
        }
        return receipt;
    }
}
