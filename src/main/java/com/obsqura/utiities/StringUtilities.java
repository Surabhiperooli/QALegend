package com.obsqura.utiities;

public class StringUtilities {
	// utilities that can be used for string manipulation functions

	public boolean stringEquals(String str1, String str2) {
		if (str1.equals(str2)) {
			return true;
		} else {
			return false;
		}

	}

	public String stringConcat(String str1, String str2) {
		String newString = str1.concat(str2);
		return newString;

	}

	public char stringCharAt(String str1, String str2) {
		char strChar = str1.charAt(9);
		return strChar;

	}

	public int stringLength(String str1) {
		int length = str1.length();
		return length;

	}

	public String stringtoLowerCase(String str1) {
		String tolower = str1.toLowerCase();
		return tolower;

	}

	public String stringtoUpperCase(String str1) {
		String toUpper = str1.toUpperCase();
		return toUpper;

	}

	// Retrieve the Index of first 'i' character.
	public int stringIndexOf(String str1) {
		int indexofChar = str1.indexOf('i');
		return indexofChar;

	}

	// Retrieve the index of 2nd most 'i' character.
	public int stringIndexOfSpecificPos(String str1) {
		int indexofChar = str1.indexOf('i', 3);
		return indexofChar;

	}

	// Converting value From int to string.
	public String intoToString(int str1) {
		String intoToString = String.valueOf(str1);
		return intoToString;

	}

	// Converting string to integer.
	public int stringToInteger(String str1) {
		int stringToInteger = Integer.parseInt(str1);
		return stringToInteger;

	}

	// Trim String.
	public String stringTrim(String str1) {
		String stringTrim = str1.trim();
		return stringTrim;

	}

}
