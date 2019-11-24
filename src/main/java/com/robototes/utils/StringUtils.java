package com.robototes.utils;

import java.text.DecimalFormat;

/**
 * A bunch of useful string functions
 * 
 * @author OroArmor
 */
public class StringUtils {

	/**
	 * Prevents an instance of this class
	 */
	private StringUtils() {
	};

	/**
	 * 
	 * @param string  The string to be repeated
	 * @param repeats The number of repeats
	 * @return The repeated string
	 */
	public static String repeatString(String string, int repeats) {
		String returnString = "";
		for (int i = 0; i < repeats; i++) {
			returnString += string;
		}
		return returnString;
	}

	/**
	 * 
	 * @param valueLength The number of wanted decimal places (Should be a value
	 *                    above 0)
	 * @return A formatted value as a string
	 */
	public static String getFormattedValue(double value, int valueLength) {
		DecimalFormat formatter = new DecimalFormat("#." + StringUtils.repeatString("#", valueLength));
		return formatter.format(value);
	}
}
