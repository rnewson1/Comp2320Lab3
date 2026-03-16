package edu.westga.comp2320.resources;

/**
 * The Tablet class represents a tablet resource in the resource center.
 * Each tablet has a unique code.
 *
 * @author COMP2320
 */
public class Tablet extends Resource {
    private static final String TYPE = "Tablet";

    private static int tabletCount = 0;
    private String code;

    /**
     * Creates a new Tablet with a unique code.
     */
    public Tablet() {
        tabletCount++;
        this.code = TYPE + "-" + tabletCount;
    }

    @Override
    public String getCode() {
        return this.code;
    }

    @Override
    public String getType() {
        return TYPE;
    }
}
