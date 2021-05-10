// Source : https://leetcode.com/problems/valid-palindrome-ii/

// Author : Jackwin Hui

// Date : 2020-12-4

/*

Given a string s, return true if the s can be palindrome after deleting at most one character from it.


Example 1:
Input: s = "aba"
Output: true

Example 2:
Input: s = "abca"
Output: true
Explanation: You could delete the character 'c'.

Example 3:
Input: s = "abc"
Output: false


*/

class Solution {
    public boolean validPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left) != s.charAt(right))
                return palinMinus(s, left + 1, right) || palinMinus(s, left, right - 1);
            else {
                left++;
                right--;
            }
        }

        return true;
    }

    public boolean palinMinus(String s, int i, int j) {
        int left = i;
        int right = j;

        while (left < right) {
            if (s.charAt(left) != s.charAt(right))
                return false;
            else {
                left++;
                right--;
            }
        }

        return true;

    }

}