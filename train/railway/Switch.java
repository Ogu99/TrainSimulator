/*
 * This class is part of the "Train Simulation" application.
 * Copyright (c) 2020, Ogu99
 */

package train.railway;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import train.Sys;

/**
 * This class represents a switch on the railtrack.
 * 
 * @author Ogu99
 * @version 1.0
 */
public class Switch implements Vector<Point> {

    /**
     * The head of the switch.
     */
    private final Point head;
    
    /**
     * The tails of the switch.
     */
    private final Queue<Point> ends;

    /**
     * Creates a new switch.
     * 
     * @param head - The head of the switch.
     * @param end1 - The first end of the switch.
     * @param end2 - The second end of the switch.
     */
    public Switch(final Point head, final Point end1, final Point end2) {
        this.head = head;
   
        this.ends = new LinkedList<>();
        this.ends.addAll(Arrays.asList(null, end1, end2)); //null stands for not initialized.
    }
   
    /**
     * Set the switch to the given end point.
     * 
     * @param point - The end point to switch to.
     */
    public void setSwitch(final Point point) {
    	if (!this.ends.contains(point))
    		throw new IllegalArgumentException("invalid end point for this switch!");
    	
        if (this.ends.peek() != null) {
        	setSwitchTo(point);
        } else {
            this.ends.remove();
            setSwitchTo(point);  
        }
    }
    
    /**
     * Set the switch to the given end point.
     * 
     * @param point - The end to switch to.
     */
    private void setSwitchTo(final Point point) {
        if (!this.ends.peek().equals(point)) {
            this.ends.add(this.ends.remove());
        }
    }
    
	@Override
	public Point head() {
		return this.head;
	}

    @Override
    public Point tail() {
	    return this.ends.peek();
    }

    /**
     * {@inheritDoc}
     * <p>
     * <b>NOTE</b>: Length in this case means that the length of the current
     * set part is being calculated. 
     * For instance, if we have the switch (0,0) -> (1,0),(0,2) and the switch is set 
     * to (1,0) then this method returns the length of (0,0) -> (1,0).
     */
    @Override
    public int length() {
        if (this.ends.peek() != null)
	        return (int) sqrt(pow(head.getX() - tail().getX(), 2) +  pow(head.getY() - tail().getY(), 2));
        else
	        return -1;
	}
	
    @Override
    public String toString() {
        final Point[] ends = this.ends.toArray(Point[]::new);
        /* 
         * What this does is basically when the switch is not set it won't return
         * the length of the switch.
         */
        if (length() == -1) {
            return Sys.join(" ", "s", this.head.toString(), "->", ends[1]) + "," + ends[2];
        }
        return Sys.join(" ", "s" , this.head.toString(), "->", ends[0]) + "," + Sys.join(" ", ends[1], length());
    }
}