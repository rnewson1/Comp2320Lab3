package edu.westga.comp2320.events;

import java.util.Random;

import edu.westga.comp2320.manager.ResourceManager;
import edu.westga.comp2320.resources.Borrowable;
import edu.westga.comp2320.resources.Laptop;

/**
 * Creates checkout events for the resource center simulation.
 *
 * @author COMP2320
 */
public class CheckoutEvent extends Event {

    private ResourceManager resourceManager;

    /**
     * Creates a new CheckoutEvent at the specified time with access
     * to the ResourceManager.
     *
     * @param time The time the event occurs
     * @param resourceManager The ResourceManager from which a
     * resource is checked out
     */
    public CheckoutEvent(int time, ResourceManager resourceManager) {
        super(time);
        this.resourceManager = resourceManager;
    }

    @Override
    public Event processEvent() {
        Laptop resource = this.resourceManager.getResource();

        if (resource == null) {
            System.out.println("*** resource not available at time " + this.getTime());
            return null;
        } else {
            System.out.println("Checkout of " + resource + " at time " + this.getTime());

            Random rand = new Random();
            int returnTime = this.getTime() + 20 + rand.nextInt(41);

            return new ReturnEvent(returnTime, (Borrowable) resource);
        }
    }
}