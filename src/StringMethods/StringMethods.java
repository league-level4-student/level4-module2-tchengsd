package StringMethods;

import java.util.Arrays;
import java.util.Base64;

/*
Visit the JavaDocs for the String class to view everything you can do with a String.  


HINT:  Here are some String methods you might find useful 
contains
replace
trim
length
getBytes
endsWith
split 
indexOf
lastIndexOf
compareTo(IgnoreCase)
substring


Here are some Character methods you might find useful:
Character.toLowerCase(char c);
Character.isLetter(char c);
Character.isDigit(char c);
Character.getNumericValue(char c);
 */

public class StringMethods {

	// Given Strings s1 and s2, return the longer String
	public static String longerString(String s1, String s2) {
		if(s1.length() > s2.length()) {
			return s1;
		} else if(s1.length() < s2.length()) {
			return s2;
		}
		return "equal";
	}

	
	// if String s contains the word "underscores", change all of the spaces to underscores
	public static String formatSpaces(String s) {
		if(s.contains("underscores")) {
			s = s.replace(' ', '_');
		}
		return s;
	}

	
	// Return the name of the person whose LAST name would appear first if they were in alphabetical order
	// You cannot assume there are no extra spaces around the name, but you can
	// assume there is only one space between the first and last name
	public static String lineLeader(String s1, String s2, String s3) {
		String t1 = s1.trim();
		String t2 = s2.trim();
		String t3 = s3.trim();
		String win = "";
		char f1 = ' ';
		char f2 = ' ';
		char f3 = ' ';
		char[] c1 = t1.toCharArray();
		char[] c2 = t2.toCharArray();
		char[] c3 = t3.toCharArray();
		for(int i = 0; i < c1.length; i++) {
			if(c1[i] == ' ') {
				f1 = c1[i+1];
			}
		}
		for(int i = 0; i < c2.length; i++) {
			if(c2[i] == ' ') {
				f2 = c2[i+1];
			}
		}
		for(int i = 0; i < c2.length; i++) {
			if(c3[i] == ' ') {
				f3 = c3[i+1];
			}
		}
		int v1 = Character.getNumericValue(f1);
		int v2 = Character.getNumericValue(f2);
		int v3 = Character.getNumericValue(f3);
		if(v1 < v2 && v1 < v3) {
			win = t1;
		} else if(v2 < v1 && v2 < v3) {
			win = t2;
		} else if(v3 < v1 && v3 < v2) {
			win = t3;
		}
		return win;
	}
	
	
	// Return the sum of all numerical digits in the String
	public static int numeralSum(String s) {
		int sum = 0;
		char[] sArr = s.toCharArray();
		for(int i = 0; i < sArr.length; i++) {
			if(Character.isDigit(sArr[i])) {
				String c = String.valueOf(sArr[i]);
				int dig = Integer.parseInt(c);
				sum += dig;
			}
		}
		return sum;
	}
	
	
	// Return the number of times String substring appears in String s
	public static int substringCount(String s, String substring) {
		
		return 0;
	}

	// Call Utitilities.encrypt to encrypt String s
	public static String encrypt(String s, char key) {
		String text = Utilities.encrypt(s.getBytes(),(byte) key);
		return text;
	}

	// Call Utilities.decrypt to decrypt the cyphertext
	public static String decrypt(String s, char key) {
		String text = Utilities.decrypt(s,(byte) key);
		return text;
	}


	// Return the number of words in String s that end with String substring
	// You can assume there are no punctuation marks between words
	public static int wordsEndsWithSubstring(String s, String substring) {
		return 0;
	}
	

	// Given String s, return the number of characters between the first occurrence
	// of String substring and the final occurrence
	// You can assume that substring will appear at least twice
	public static int distance(String s, String substring) {
		return 0;
	}


	// Return true if String s is a palindrome
	// palindromes are words or phrases are read the same forward as backward.
	// HINT: ignore/remove all punctuation and spaces in the String
	public static boolean palindrome(String s) {
		
		return true;
	}
	
}

class Utilities {
	// This basic encryption scheme is called single-byte xor. It takes a single
	// byte and uses exclusive-or on every character in the String.
	public static String encrypt(byte[] plaintext, byte key) {
		for (int i = 0; i < plaintext.length; i++) {
			plaintext[i] = (byte) (plaintext[i] ^ key);
		}
		return Base64.getEncoder().encodeToString(plaintext);
	}

	public static String decrypt(String cyphertext, byte key) {
		byte[] b = Base64.getDecoder().decode(cyphertext);
		for (int i = 0; i < b.length; i++) {
			b[i] = (byte) (b[i] ^ key);
		}
		return new String(b);
	}
}
