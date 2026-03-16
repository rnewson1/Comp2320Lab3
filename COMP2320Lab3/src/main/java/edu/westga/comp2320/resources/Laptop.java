package edu.westga.comp2320.resources;

import static edu.westga.comp2320.SimulationParameters.LAPTOP_CHECKOUT_DURATION;

/**
 * The Laptop class represents a laptop resource in the resource center.
 * Each laptop has a unique code and a defined checkout duration.
 *
 * @author COMP2320
 */
public class Laptop extends Resource {
    private static final String TYPE = "Laptop";

    private static int laptopCount = 0;
    private String code;

    /**
     * Creates a new Laptop with a unique code.
     */
    public Laptop() {
        laptopCount++;
        this.code = TYPE + "-" + laptopCount;
    }

    @Override
    public String getCode() {
        return this.code;
    }

    @Override
    public String getType() {
        return TYPE;
    }

    @Override
    public int getCheckoutDuration() {
        return LAPTOP_CHECKOUT_DURATION;
    }
}