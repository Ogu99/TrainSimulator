/*
 * This class is part of the "Train Simulation" application.
 * Copyright (c) 2020-2021, Ogu99
 */

package train.railroad;

import train.EStringTable;
import train.Sys;

/**
 * This class represents a switch rail on a railroad. You can switch between both possible ends.
 * 
 * @author Ogu99
 * @version 2.0
 * @since 1.0
 */
public class Switch implements IRail {

	/**
	 * The start point.
	 */
	public Point _start;
	
	/**
	 * The first end.
	 */
	public Point _firstEnd;
	
	/**
	 * The second end.
	 */
	public Point _secondEnd;
	
	/**
	 * The current end the switch is set to.
	 */
	public Point _currentEnd;
	
	/**
	 * Creates a new switch with a start and two end points.
	 * 
	 * @param start - The start point.
	 * @param firstEnd - The first end.
	 * @param secondEnd - The second end.
	 * @see Point
	 */
	public Switch(Point start, Point firstEnd, Point secondEnd) {
		if (!isStraight(start, firstEnd) || !isStraight(start, secondEnd) || firstEnd.equals(secondEnd)) {
			throw new IllegalArgumentException("your rail is not straight! It has to be int he format (x,y1) -> (x, y2) or (x1,y) -> (x2,y)!");
		} else {
			this._start = start;
			this._firstEnd = firstEnd;
			this._secondEnd = secondEnd;
		}
	}
	
	/**
	 * Sets the current end of this switch.
	 * 
	 * @param end - The end to switch to.
	 * @see Point
	 */
	public void setTo(Point end) {
		if (end.equals(this._firstEnd) || end.equals(this._secondEnd)) {
			this._currentEnd = end;
		}
	}
	
	@Override
	public int length() {
		if (this._currentEnd != null) {
			return distanceOf(this._start, this._currentEnd);
		}
		throw new IllegalStateException("you're switch is not set!");
	}

	@Override
	public Point getStart() {
		return this._start;
	}

	@Override
	public Point getEnd() {
		return this._currentEnd;
	}
	
	@Override
	public String toString() {
		if (this._currentEnd != null) {
			return Sys.join(EStringTable.WHITESPACE.toString(), this._start, EStringTable.ARROW, this._currentEnd);
		}
		final String bothEnds = Sys.join(this._firstEnd, EStringTable.COMMA, this._secondEnd);
		return Sys.join(EStringTable.WHITESPACE.toString(), this._start, EStringTable.ARROW, bothEnds);
	}
}