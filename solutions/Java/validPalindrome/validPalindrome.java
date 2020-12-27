// Source : https://leetcode.com/problems/valid-palindrome/

// Author : Jackwin Hui

// Date : 2020-12-4

/*

Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

Note: For the purpose of this problem, we define empty string as valid palindrome.

Example 1:
Input: "A man, a plan, a canal: Panama"
Output: true

Example 2:
Input: "race a car"
Output: false

*/

class Solution {
    public boolean isPalindrome(String s) {
        if (s == null || s.isEmpty())
            return true;
        
        int left = 0, right = s.length()-1;
        
        while (left < right) {
            char l = s.charAt(left);
            char r = s.charAt(right);
            
            if(Character.isLetterOrDigit(l))
            {
                if(Character.isLetterOrDigit(r)) {
                    if(Character.toLowerCase(l) != Character.toLowerCase(r))
                        return false;
                    else {
                        left++;
                        right--;
                    }
                }
                else
                    right--;
            }
            else
                left++;
            
        }
        
        return true;
    }
}