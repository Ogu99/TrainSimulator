/*
 * This class is part of the "Train Simulation" application.
 * Copyright (c) 2020, Ogu99
 */

package train.railway;

import java.util.Objects;

/**
 * This class represents a point in a 2d space.
 * 
 * @author Ogu99
 * @version 1.0
 */
public class Point {

    /**
     * The x coordinate.
     */
    private final int x;
    
    /**
     * The y coordinate.
     */
    private final int y;
    
    /**
     * Create a new point.
     * 
     * @param x - The x coordinate.
     * @param y - The y coordinae.
     */
    public Point(final int x, final int y) {
    	this.x = x;
    	this.y = y;
    }
    
    /**
     * @return the x coordinate.
     */
    public int getX() {
        return this.x;
    }
    
    /**
     * @return the y coordinate.
     */
    public int getY() {
    	return this.y;
    }
    
    @Override
    public int hashCode() {
    	return Objects.hash(this.x, this.y);
    }
    
    @Override
    public boolean equals(final Object o) {
        if (getClass().equals(o.getClass())) {
        	final Point other = (Point) o;
        	return (other.x == this.x) && (other.y == this.y);
        }
        return false;
    }
    
    @Override
    public String toString() {
    	return "(" + this.x + "," + this.y + ")";
    }
}