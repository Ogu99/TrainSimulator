/*
 * This class is part of the "Train Simulation" application.
 * Copyright (c) 2020-2021, Ogu99
 */

package train.railroad;

import train.EStringTable;
import train.Sys;

/**
 * Represents a straight rail on the railroad.
 * 
 * @author Ogu99
 * @version 2.0
 * @since 1.0
 */
public class Rail implements IRail {

	/**
	 * The start point of the rail.
	 */
	private Point _start;
	
	/**
	 * The end point of the rail.
	 */
	private Point _end;
	
	/**
	 * Creates a new rail with a start and a end point.
	 * 
	 * @param start - The start point of the rail.
	 * @param end - The end point of the rail.
	 * @see Point
	 */
	public Rail(Point start, Point end) {
		if (!isStraight(start, end)) {
			throw new IllegalArgumentException("your rail is not straight! It has to be int he format (x,y1) -> (x, y2) or (x1,y) -> (x2,y)!");
		} else {
		    this._start = start;
		    this._end = end;
		}
	}
	
	@Override
	public int length() {
		return distanceOf(this._start, this._end);
	}

	@Override
	public Point getStart() {
		return this._start;
	}

	@Override
	public Point getEnd() {
		return this._end;
	}
	
	@Override
	public String toString() {
		return Sys.join(EStringTable.WHITESPACE.toString(), this._start, EStringTable.ARROW, this._end);
	}
}