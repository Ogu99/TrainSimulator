/*
 * This class is part of the "Train Simulation" application.
 * Copyright (c) 2021, Ogu99
 */

package train.railroad;

/**
 * This interface represents the main functionality of a rail on a railroad.
 * 
 * @author Ogu99
 * @version 1.0
 */
public interface IRail {
	
	/**
	 * @return the length of the rail.
	 */
	int length();
	
	/**
	 * @return the start {@link Point} of the rail.
	 */
	Point getStart();
	
	/**
	 * @return the end {@link Point} of the rail.
	 */
	Point getEnd();
	
	/**
	 * Calculates the distance between two given points and returns the result as {@code int}.
	 * 
	 * @param a - The first point.
	 * @param b - The second point
	 * @return the distance between both points.
	 * @see Point
	 */
	default int distanceOf(Point a, Point b) {
		return (int) Math.sqrt(Math.pow((a.getX() - b.getX()), 2) + Math.pow((a.getY() - b.getY()), 2));
	}
	
	/**
	 * Checks if two given points are in a straight line or not.
	 * 
	 * @param a - The first point.
	 * @param b - The second point.
	 * @return {@code true} if the points are in a straight line.
	 * @see Point
	 */
	default boolean isStraight(Point a, Point b) {
		return (a.getX() == b.getX() || a.getY() == b.getY());
	}
}