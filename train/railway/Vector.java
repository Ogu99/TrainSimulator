/*
 * This class is part of the "Train Simulation" application.
 * Copyright (c) 2020, Ogu99
 */

package train.railway;

/**
 * This interface contains the main functionality for a vector. It
 * can be made up of points but also for instance ints, strings etc. 
 * The vector is mainly used in the 2-dimensionaly space but might be also
 * used in the 3-dimensional space.
 * 
 * @author Ogu99
 * @version 1.0
 *
 * @param <T> - The type of the Element the vector is composed of.
 */
public interface Vector<T> {

    /**
     * Get the head of this vector. For instance if the vector would be
     * (1,1) -> (2,1) then the head is (1,1).
     * 
     * @return the head.
     */
    T head();
	
    /**
     * Get the tail of this vector. For instance if the vector would be
     * (0,0) -> (5,6) then the tail is (5,6)
     * 
     * @return
     */
    T tail();

    /**
     * Get the length of this vector.
     * 
     * @return the length as int.
     */
    int length();
}