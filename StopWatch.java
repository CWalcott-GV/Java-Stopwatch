package projPack1;

import java.io.*;
import java.util.Scanner;

/*****************************************************************
 ********   class description...
 *
 *
 *
 * @author Corey Walcott & Wilson Armstrong
 * @version	V2.2
 *
 * Changes made,
 * 			-Downloaded 1/20/21, no changes made for initial week.
 * 			-Updated to 98% code coverage, changes made to dec() and sub() methods (2/1/21)
 * 			-Updated to 100% code coverage, changes made to fix IOException and object constructor.
 */

public class StopWatch  {


	/** This holds minutes for our stopwatch */
	private int minutes;
	/** this holds seconds for our stopwatch */
	private int seconds;
	/** this holds milliseconds for our stopwatch */
	private int milliseconds;
	/** initialized boolean suspend variable for suspend button functionality */
	private static boolean suspend = false;

	/******************************************************************
	 *
	 *  Default constructor that sets the StopWatch to zero.
	 *
	 */

	public StopWatch() {
		minutes = 0;
		milliseconds = 0;
		seconds = 0;

	}

	/******************************************************************
	 *
	 *  A constructor that initializes the instance variables with
	 *  the provided values.
	 *
	 * @param minutes integer representing number of minutes.
	 * @param seconds integer representing number of seconds.
	 * @param milliseconds representing number of milliseconds.
	 * @throws IllegalArgumentException when passed values fall
	 * out of range. Minutes cannot be negative, seconds cannot
	 * be more than 59 or less than zero, milliseconds cannot be
	 * more than 999 or less than zero.
	 */

	public StopWatch(int minutes, int seconds, int milliseconds) {

		if(minutes < 0 || seconds < 0 || seconds > 59 ||
				milliseconds < 0 || milliseconds > 999)
			throw new IllegalArgumentException("Error input");

		this.milliseconds = milliseconds;
		this.seconds = seconds;
		this.minutes = minutes;

	}

	/******************************************************************
	 *
	 *  A constructor that initializes the instance variables with
	 *  the provided values.
	 *
	 * @param seconds integer representing number of seconds.
	 * @param milliseconds representing number of milliseconds.
	 * @throws IllegalArgumentException when passed values fall
	 * out of range. Seconds cannot be more than 59 or less than
	 * zero, milliseconds cannot be more than 999 or less than zero.
	 */

	public StopWatch(int seconds, int milliseconds) {
		if(seconds < 0 || seconds > 59 || milliseconds < 0
				|| milliseconds > 999)
			throw new IllegalArgumentException("Error input");

		this.seconds = seconds;
		this.milliseconds = milliseconds;
	}

	/******************************************************************
	 *
	 *  A constructor that initializes the instance variables with
	 *  the provided values.
	 *
	 * @param milliseconds representing number of milliseconds.
	 * @throws IllegalArgumentException when passed values fall
	 * out of range. Seconds cannot be more than 59 or less than
	 * zero, milliseconds cannot be more than 999 or less than zero.
	 */

	public StopWatch(int milliseconds) {

		if(milliseconds < 0)
			throw new IllegalArgumentException();

		StopWatch s = new StopWatch();

		s.convertToStopWatch(milliseconds);

		seconds = s.seconds;
		minutes = s.minutes;
		this.milliseconds = s.milliseconds;
	}

	/******************************************************************
	 *
	 *  A constructor that accepts a string as a parameter with the
	 *  following format: "1:21:300"� where 1 indicates minutes, 21
	 *  indicates seconds,  and 300 indicates milliseconds.  OR
	 *  the format "15:200"� where the 15 indicates seconds, and
	 *  200 indicates milliseconds, OR the format “300” where
	 *  300 indicates milliseconds. Passes through to the
	 *  buildFromString() method.
	 *
	 * @param startTime is the input string the represents
	 * the starting time
	 * @throws IllegalArgumentException when the input string
	 * does not match the proper format (see description above)
	 */

	public StopWatch(String startTime) {
		if (startTime == null)
			throw new IllegalArgumentException();

		buildFromString(startTime);
	}

	/******************************************************************
	 *
	 *  A mutator method that takes the string from passed string
	 *  constructor method, relays that data back.
	 *
	 * @param startTime is the input string the represents
	 * the starting time
	 * @throws IllegalArgumentException when the input string
	 * does not match the proper format. Does not allow Seconds
	 * to be more than 60 or less than zero. Does not allow
	 * Milliseconds to be more than 1000 or less than zero.
	 *
	 */

	private void buildFromString(String startTime){

		String[] s = startTime.split(":");

		if(s.length == 3) {
			minutes = Integer.parseInt(s[0]);
			seconds = Integer.parseInt(s[1]);
			milliseconds = Integer.parseInt(s[2]);
		}
		else if(s.length == 2){
			seconds = Integer.parseInt(s[0]);
			milliseconds = Integer.parseInt(s[1]);
		}
		else if(s.length == 1){
			milliseconds = Integer.parseInt(s[0]);
		}
		else
			throw new IllegalArgumentException();

		if(minutes < 0 || minutes > 10000 || seconds < 0 || seconds > 59 ||
				milliseconds < 0 || milliseconds > 999)
			throw new IllegalArgumentException("Error input");

		this.milliseconds = milliseconds;
		this.seconds = seconds;
		this.minutes = minutes;

	}

	/******************************************************************
	 *
	 *  A constructor that initializes the instance variables with
	 *  the provided values.
	 *
	 * @param stopWatch object previously made.
	 * @throws IllegalArgumentException if previously made stopWatch
	 * was/is a null object.
	 */

	public StopWatch(StopWatch stopWatch) {
		if (stopWatch == null)
			throw new IllegalArgumentException();

		this.minutes = stopWatch.minutes;
		this.seconds = stopWatch.seconds;
		this.milliseconds = stopWatch.milliseconds;
	}

	/******************************************************************
	 *
	 *  A constructor that initializes the instance variables with
	 *  the provided values.
	 *
	 * @param object passed to be check if StopWatch object at all
	 * and if those values that belong to that StopWatch are equal
	 * to the values attached to that StopWatch's minutes/seconds/
	 * milliseconds variables.
	 *
	 */

	public boolean equals(Object object) {
		if(object != null && object instanceof StopWatch){
			StopWatch s = (StopWatch) object;
			return minutes == s.minutes && seconds == s.seconds && milliseconds == s.milliseconds;
		}

		return false;

	}

	/******************************************************************
	 *
	 *  A static method that returns true of StopWatch object stopwatch1
	 *  is exactly the same as StopWatch object stopwatch2.
	 *
	 * @param stopWatch1 first stopwatch object from above
	 * @param stopWatch2 the seconds stopwatch object from above
	 * @throws IllegalArgumentException if either stopWatch objects are null,
	 */

	public static boolean equals(StopWatch stopWatch1, StopWatch stopWatch2) {
		if(stopWatch1 == null || stopWatch2 == null)
			throw new IllegalArgumentException();

		StopWatch s = new StopWatch();
		StopWatch s1 = new StopWatch();

		s = stopWatch1;
		s1 = stopWatch2;

		if(s.equals(s1))
			return true;

		return false;
	}

	/******************************************************************
	 *
	 *  A method that returns 1 if "this" StopWatch object is greater
	 *  than the other StopWatch object; returns -1 if the "this"
	 *  StopWatch object is less than the other StopWatch object;
	 *  returns 0 if the "this" StopWatch object is equal to the other
	 *  StopWatch object.
	 *
	 * @param other object previously made StopWatch object.
	 * @throws IllegalArgumentException if previously made stopWatch
	 * was/is a null object.
	 */

	public int compareTo(StopWatch other) {
		if (other == null)
			throw new IllegalArgumentException();

		if(this.minutes > other.minutes)
			return 1;
		else if (this.minutes < other.minutes)
				return -1;	//here
		if(this.seconds > other.seconds)
			return 1;	//here
		else if(this.seconds < other.seconds)
			return -1;
		if(this.milliseconds > other.milliseconds)
			return 1;
		else if(this.milliseconds < other.milliseconds)
			return -1;

		return 0;
	}

	/******************************************************************
	 *
	 *  A method that adds the number of milliseconds to "this"
	 *  StopWatch object.
	 *
	 * @param milliseconds integer of milliseconds passed.
	 * @throws IllegalArgumentException if milliseconds is less than zero.
	 */

	public void add(int milliseconds) {
		if(!suspend) {
			if (milliseconds < 0)
				throw new IllegalArgumentException();

			int temp = convertToMilli(this);
			temp += milliseconds;
			convertToStopWatch(temp);
		}

	}

	/******************************************************************
	 *	Method that adds the milliseconds of a stopWatch object to
	 * the current stopWatch object.
	 *
	 * @param stopWatch object previously made and passed into method.
	 * @throws IllegalArgumentException if passed stopWatch object is
	 * null.
	 */

	public void add(StopWatch stopWatch) {
		if(stopWatch == null)
			throw new IllegalArgumentException();

		if(!suspend) {
			int a = convertToMilli(stopWatch);
			int b = convertToMilli(this);
			int c = a + b;
			convertToStopWatch(c);
		}
	}

	/******************************************************************
	 *	Method converts minutes, seconds and milliseconds of object
	 * passed into milliseconds. Then returns integer of milliseconds
	 *
	 *
	 * @param stopWatch object previously made and passed into method.
	 */

	private static int convertToMilli (StopWatch stopWatch) {

		int tempMilliSeconds = 0;

		tempMilliSeconds += stopWatch.getMinutes() * 60000;
		tempMilliSeconds += stopWatch.getSeconds() * 1000;
		tempMilliSeconds += stopWatch.getMilliseconds();

		return tempMilliSeconds;

	}

	/******************************************************************
	 *	Method converts passed milliseconds into minutes, seconds
	 * and millisecond instance variables.
	 *
	 * @param tempMilliseconds integer passed is milliseconds.
	 */

	private void convertToStopWatch (int tempMilliseconds) {
		minutes = tempMilliseconds / 60000;
		tempMilliseconds %= 60000;

		seconds = tempMilliseconds / 1000;
		tempMilliseconds %= 1000;
		milliseconds = tempMilliseconds;
	}

	/******************************************************************
	 *	Method subtracts passed milliseconds from the "this" object.
	 *	First, a temporary integer is made by passing the "this"
	 *	object into the convertToMilli() method, giving milliseconds.
	 *	Then, temp integer subtracts the value passed. Then is
	 *	recalculated into a StopWatch object with valid minute,
	 *	second and millisecond variables.
	 *
	 * @param milliseconds integer passed is milliseconds.
	 * @throws IllegalArgumentException if passed milliseconds is
	 * less than 0.
	 */

	public void sub(int milliseconds) {
		if(!suspend) {
			if (milliseconds < 0)
				throw new IllegalArgumentException();

			int temp = convertToMilli(this);
			temp -= milliseconds;
			convertToStopWatch(temp);
		}

	}

	/******************************************************************
	 *	Method subtracts passed stopWatch object by converting both
	 *	the "this" object and the passed object into the
	 *	convertToMilli() method and doing simple subtraction
	 *	to a "c" variable, then converts that variable to a stopwatch
	 *	via convertToStopWatch().
	 *
	 * @param stopWatch object previously made.
	 * @throws IllegalArgumentException if passed stopWatch is null
	 * @throws IllegalArgumentException if passed stopwatch method
	 * after conversion is less than the "this" object's milliseconds
	 * conversion.
	 */

	public void sub(StopWatch stopWatch) {
		if (stopWatch == null)
			throw new IllegalArgumentException();

		if(!suspend) {
			int a = convertToMilli(stopWatch);
			int b = convertToMilli(this);

			if (a > b)
				throw new IllegalArgumentException("Math Error, one is bigger than other");

			int c = b - a;
			convertToStopWatch(c);
		}
	}

	/******************************************************************
	 *	A method that decrements the "this" StopWatch by 1 millisecond.
	 */

	public void dec() {
		if(!suspend) {
			if (milliseconds == 0) {

				milliseconds = 999;
				if (seconds == 0) {
					minutes--;
					seconds = 59;
				}
				else
					seconds--;
			} else
				milliseconds--;
		}
	}

	/******************************************************************
	 *	A method that increments the "this" StopWatch by 1 millisecond.
	 */

	public void inc() {
		if (!suspend) {
			if (milliseconds == 999) {
				seconds++;
				milliseconds = 0;

				if (seconds == 60) {
					minutes++;
					seconds = 0;
				}
			} else
				milliseconds++;
		}
	}

	/******************************************************************
	 *	Method that returns a string that represents a StopWatch with
	 *	the following format: "1:06:010".
	 */

	public String toString() {

		if(seconds < 10) {

			if (milliseconds < 10)
				return minutes + ":" + "0" + seconds + ":" + "00" + milliseconds;

			else if (milliseconds < 100)
				return minutes + ":" + "0" + seconds + ":" + "0" + milliseconds;

			else
				return minutes + ":" + "0" + seconds + ":" + milliseconds;
		}
		if (milliseconds < 10)
			return minutes + ":" + seconds + ":" + "00" + milliseconds;

		else if (milliseconds < 100)
			return minutes + ":" + seconds + ":" + "0" + milliseconds;

		else
			return minutes + ":" + seconds + ":" + milliseconds;


	}

	/******************************************************************
	 *	A method that saves the "this" StopWatch to a file.
	 *
	 * @throws IllegalArgumentException if filename is null.
	 * @throws IllegalArgumentException if IOException is caught
	 */

	public void save(String filename) {
		if (filename == null)
			throw new IllegalArgumentException();

		PrintWriter out = null;
		try {
			out = new PrintWriter(new BufferedWriter(new FileWriter(filename)));
			out.println(this.getMinutes() + " " + this.getSeconds() + " " + this.getMilliseconds());
			out.close();

		} catch (IOException e) {
			throw new IllegalArgumentException();
		}

	}

	/******************************************************************
	 *	A method that loads the "this" StopWatch to a file.
	 *
	 * @throws IllegalArgumentException if filename is null.
	 * @throws IllegalArgumentException if FileNotFoundException
	 */

	public void load(String filename)  {
		if (filename == null)
			throw new IllegalArgumentException();

		Scanner scanner = null;
		try {
			scanner = new Scanner(new File(filename));

			this.setMinutes(scanner.nextInt());
			this.setSeconds(scanner.nextInt());
			this.setMilliseconds(scanner.nextInt());

		} catch (FileNotFoundException e) {
			throw new IllegalArgumentException();
		}

	}

	/******************************************************************
	 *	A method that turns on/off ALL StopWatch objects from mutating.
	 */

	public static void setSuspend(boolean on) {
		if(on)
			suspend = true;
		else
			suspend = false;
	}

	/******************************************************************
	 *	A method that returns true if suspended is on, or false if off.
	 */

	public static boolean isSuspended() {
		return suspend;
	}

	/******************************************************************
	 *	Getter for minutes.
	 */

	public int getMinutes() {
		return minutes;
	}

	/******************************************************************
	 *	Setter for minutes.
	 *
	 * @param minutes passed variable minutes sets instance variable
	 * equal to that variable.
	 * @throws IllegalArgumentException if passed minutes is
	 * less than 0.
	 */

	public void setMinutes(int minutes) {
		if(!suspend) {
			if (minutes < 0)
				throw new IllegalArgumentException();

			this.minutes = minutes;
		}
	}

	/******************************************************************
	 *	Getter for milliseconds.
	 */

	public int getMilliseconds() {
		return milliseconds;
	}

	/******************************************************************
	 *	Getter for seconds.
	 */

	public int getSeconds() {
		return seconds;
	}

	/******************************************************************
	 *	Setter for seconds.
	 *
	 * @param seconds passed variable minutes sets instance variable
	 * equal to that variable.
	 * @throws IllegalArgumentException if passed seconds is
	 * less than 0 or more than 59.
	 */

	public void setSeconds(int seconds) {
		if(!suspend) {
			if (seconds < 0 || seconds > 59)
				throw new IllegalArgumentException();

			this.seconds = seconds;
		}
	}

	/******************************************************************
	 *	Setter for milliseconds.
	 *
	 * @param milliseconds passed variable minutes sets instance variable
	 * equal to that variable.
	 * @throws IllegalArgumentException if passed milliseconds is
	 * less than 0 or more than 999.
	 */

	public void setMilliseconds(int milliseconds) {
		if(!suspend) {
			if (milliseconds < 0 || milliseconds > 999)
				throw new IllegalArgumentException();

			this.milliseconds = milliseconds;
		}
	}
}