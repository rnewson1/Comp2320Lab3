package edu.westga.comp2320;

import edu.westga.comp2320.events.CheckoutEvent;
import edu.westga.comp2320.manager.ResourceManager;
import edu.westga.comp2320.events.Event;

import java.util.ArrayList;
import java.util.Random;

import static edu.westga.comp2320.SimulationParameters.*;

/**
 * The ResourceCenter class simulates a resource center where resources can be checked out and returned.
 * It manages the event queue and processes events in chronological order.
 *
 * @author COMP2320
 */
public class ResourceCenter {
    private ArrayList<Event> eventQueue;

    /**
     * Constructs a ResourceCenter and initializes the event queue with checkout events.
     */
    public ResourceCenter() {
        Random rand = new Random();
        this.eventQueue = new ArrayList<Event>();
        ResourceManager resourceManager = new ResourceManager();
        int time = 0;
        while (time < SIMULATION_DURATION) {
            time += MIN_CHECKOUT_INTERVAL + rand.nextInt(MAX_CHECKOUT_INTERVAL - MIN_CHECKOUT_INTERVAL);
           this.eventQueue.add(new CheckoutEvent(time, resourceManager));
        }
    }

    /**
     * Runs the resource center simulation by processing events in chronological order.
     */
    public void runSimulation() {
        while (!this.eventQueue.isEmpty()) {
            Event nextEvent = this.removeNextEvent();
            Event newEvent = nextEvent.processEvent();
            if (newEvent != null) {
                this.eventQueue.add(newEvent);
            }
        }
    }

    private Event removeNextEvent() {
        Event earliestEvent = this.eventQueue.getFirst();
        for (Event event : this.eventQueue) {
            if (event.getTime() < earliestEvent.getTime()) {
                earliestEvent = event;
            }
        }
        this.eventQueue.remove(earliestEvent);
        return earliestEvent;
    }
}
