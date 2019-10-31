package com.nikhil.aprogrammer.sorting;

import java.util.Arrays;

/**
 * Implementing a program to find two strings are anagrams are not.
 */
public class Anagram {

    /**
     * This method is used to check if the given two strings are anagrams.
     *
     * @param s Input String 1.
     * @param t input String 2.
     * @return {@code true} if given strings are anagrams, else returns {@code false}.
     */
    public boolean isAnagram(String s, String t) {
        if (s == null || t == null) {
            return false;
        }

        if (s.length() != t.length()) {
            return false;
        }

        char[] sCharArr = s.toCharArray();
        char[] tCharArr = t.toCharArray();

        Arrays.sort(sCharArr);
        Arrays.sort(tCharArr);

        return Arrays.equals(sCharArr, tCharArr);
    }
}
