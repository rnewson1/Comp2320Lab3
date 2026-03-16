package edu.westga.comp2320.events;

import java.util.Random;

import edu.westga.comp2320.manager.ResourceManager;
import edu.westga.comp2320.resources.Resource;

import static edu.westga.comp2320.SimulationParameters.MIN_CHECKOUT_DURATION;
import static edu.westga.comp2320.SimulationParameters.PROBABILITY_OF_LAPTOP;
import static edu.westga.comp2320.SimulationParameters.PROBABILITY_OF_TABLET;

/**
 * The CheckoutEvent represents the event when a resource
 * is checked out from the resource center.
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
        String resourceType = this.generateRandomResourceType();
        Resource resource = this.resourceManager.getResourceByType(resourceType);

        if (resource == null) {
            System.out.println("*** resource not available at time " + this.getTime());
            return null;
        }

        resource.borrow();
        System.out.println("Checkout of " + resource + " at time " + this.getTime());

        Random rand = new Random();
        int returnTime = this.getTime() + MIN_CHECKOUT_DURATION
                + rand.nextInt(resource.getCheckoutDuration() - MIN_CHECKOUT_DURATION + 1);

        return new ReturnEvent(returnTime, resource);
    }

    private String generateRandomResourceType() {
        Random rand = new Random();
        int randomNumber = rand.nextInt(100);

        if (randomNumber < PROBABILITY_OF_LAPTOP) {
            return "Laptop";
        }
        if (randomNumber < PROBABILITY_OF_LAPTOP + PROBABILITY_OF_TABLET) {
            return "Tablet";
        }
        return "StudyRoom";
    }
}