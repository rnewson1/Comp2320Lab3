package edu.westga.comp2320.manager;

import java.util.ArrayList;

import edu.westga.comp2320.resources.Laptop;
import edu.westga.comp2320.resources.Resource;
import edu.westga.comp2320.resources.StudyRoom;
import edu.westga.comp2320.resources.Tablet;

import static edu.westga.comp2320.SimulationParameters.*;

/**
 * The ResourceManager class manages the inventory of resources in the resource center.
 * It allows for generating inventories of different resource types and retrieving available resources.
 * The different types of resources are laptops, tablets, and study rooms.
 * The number of each resource type is defined in the SimulationParameters class.
 *
 * @author COMP2320
 */
public class ResourceManager {
    private ArrayList<Resource> inventory;

    /**
     * Constructs a ResourceManager and generates the initial inventory of resources.
     */
    public ResourceManager() {
        this.inventory = new ArrayList<Resource>();
        this.generateLaptopInventory();
        this.generateTabletInventory();
        this.generateStudyRoomInventory();
    }

    private void generateLaptopInventory() {
        for (int i = 0; i < NUMBER_OF_LAPTOPS; i++) {
            this.inventory.add(new Laptop());
        }
    }

    private void generateTabletInventory() {
        for (int i = 0; i < NUMBER_OF_TABLETS; i++) {
            this.inventory.add(new Tablet());
        }
    }

    private void generateStudyRoomInventory() {
        for (int i = 0; i < NUMBER_OF_STUDY_ROOMS; i++) {
            this.inventory.add(new StudyRoom());
        }
    }

    /**
     * Returns a resource from the inventory.
     *
     * @return a resource, or null if the inventory is empty
     */
    public Resource getResource() {
        if (this.inventory.isEmpty()) {
            return null;
        }
        return this.inventory.getFirst();
    }

    /**
     * Retrieves an available resource of the specified type from
     * the inventory.
     *
     * @param resourceType the type of resource to retrieve
     * ("Laptop", "Tablet", "StudyRoom")
     * @return an available Resource of the specified type, or null
     * if no resource of the given type is available
     */
    public Resource getResourceByType(String resourceType) {
        for (Resource resource : this.inventory) {
            if (resource.getType().equals(resourceType)) {
                return resource;
            }
        }
        return null;
    }
}