/*
 * This class is part of the "Train Simulation" application.
 * Copyright (c) 2020-2021, Ogu99
 */

package train.railroad;

import java.util.Objects;

import train.EStringTable;
import train.Sys;

/**
 * This class represents a point in a two dimensional space/Cartesian coordinate system.
 * 
 * @author Ogu99
 * @version 2.0
 * @since 1.0
 */
public class Point {

	/**
	 * The x coordinate.
	 */
	private final int _x;
	
	/**
	 * The y coordinate.
	 */
	private final int _y;
	
	/**
	 * Creates a new point with the given x and y coordinates.
	 * 
	 * @param x - The x coordinate.
	 * @param y - The y coordinate.
	 */
	public Point(int x, int y) {
		this._x = x;
		this._y = y;
	}
	
	/**
	 * @return the x value of this point.
	 */
	public int getX() {
		return this._x;
	}
	
	/**
	 * @return the y value of this point.
	 */
	public int getY() {
		return this._y;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(this._x, this._y);
	}
	
	@Override
	public boolean equals(Object o) {
		if (o.getClass().equals(getClass())) {
			Point other = (Point) o;
			return (this._x == other._x) && (this._y == other._y);
		}
		return false;
	}
	
	@Override
	public String toString() {
		return Sys.join(EStringTable.COLUMN_L, this._x, EStringTable.COMMA, this._y, EStringTable.COLUMN_R);
	}
}