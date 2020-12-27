// Source : https://leetcode.com/problems/longest-palindromic-substring/

// Author : Jackwin Hui

// Date : 2020-12-3

/*

Given a string s, return the longest palindromic substring in s.

Example 1:
Input: s = "babad"
Output: "bab"
Note: "aba" is also a valid answer.

Example 2:
Input: s = "cbbd"
Output: "bb"

Example 3:
Input: s = "a"
Output: "a"

Example 4:
Input: s = "ac"
Output: "a"

*/

class Solution {    
    public String longestPalindrome(String s) {
        int l = s.length();
        if (l <= 1)
            return s;
        
        String res = "";
        
        boolean[][] dp = new boolean[l][l];

        for (int i = l - 1; i >= 0; i--) {
            for (int j = i; j < l; j++) {
                dp[i][j] = (s.charAt(i) == s.charAt(j)) && (j - i < 3 || dp[i + 1][j - 1]);

                if (dp[i][j] && (res == "" || j - i + 1 > res.length()))
                    res = s.substring(i, j + 1);
            }
        }

        return res;
    }
}