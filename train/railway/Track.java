/*
 * This class is part of the "Train Simulation" application.
 * Copyright (c) 2020, Ogu99
 */

package train.railway;

import static java.lang.Math.sqrt;
import static java.lang.Math.pow;

import train.Sys;

/**
 * This class represents a straight track on a railway.
 * 
 * @author Ogu99
 * @version 1.0
 */
public class Track implements Vector<Point> {

    /**
     * The head of the track.
     */
    private final Point head;
   
    /**
     * The tail of the track.
     */
    private final Point tail;
    
    /**
     * Creates a new track.
     * 
     * @param head - The head of this track.
     * @param tail - The tail of this track.
     */
    public Track(final Point head, final Point tail) {
        this.head = head;
        this.tail = tail;
    }

    @Override
    public Point head() {
	    return this.head;
    }

    @Override
    public Point tail() {
	    return this.tail;
    }

    @Override
    public int length() {
	    return (int) sqrt(pow(head.getX() - tail.getX(), 2) +  pow(head.getY() - tail.getY(), 2));
    }
	
    @Override
    public String toString() {
        return Sys.join(" ", "t", this.head.toString(), "->", this.tail.toString(), length());
    }
}