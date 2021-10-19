// Source : https://leetcode.com/problems/valid-anagram/

// Author : Jackwin Hui

// Date : 2021-10-18

/*

Given two strings s and t, return true if t is an anagram of s, and false otherwise.

 
Example 1:
Input: s = "anagram", t = "nagaram"
Output: true

Example 2:
Input: s = "rat", t = "car"
Output: false


*/

class Solution {
    public boolean isAnagram(String s, String t) {
        char[] sCharArr = s.toCharArray();
        char[] tCharArr = t.toCharArray();

        Arrays.sort(sCharArr);
        Arrays.sort(tCharArr);

        return Arrays.equals(sCharArr, tCharArr);
    }
}