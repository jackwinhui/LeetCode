// Source : https://leetcode.com/problems/split-a-string-in-balanced-strings/

// Author : Jackwin Hui

// Date : 2020-10-31

/*

Balanced strings are those that have an equal quantity of 'L' and 'R' characters.

Given a balanced string s, split it in the maximum amount of balanced strings.

Return the maximum amount of split balanced strings.

 
Example 1:
Input: s = "RLRRLLRLRL"
Output: 4
Explanation: s can be split into "RL", "RRLL", "RL", "RL", each substring contains same number of 'L' and 'R'.

Example 2:
Input: s = "RLLLLRRRLR"
Output: 3
Explanation: s can be split into "RL", "LLLRRR", "LR", each substring contains same number of 'L' and 'R'.

Example 3:
Input: s = "LLLLRRRR"
Output: 1
Explanation: s can be split into "LLLLRRRR".

Example 4:
Input: s = "RLRRRLLRLL"
Output: 2
Explanation: s can be split into "RL", "RRRLLRLL", since each substring contains an equal number of 'L' and 'R'


*/

class Solution {
    public int balancedStringSplit(String s) {
        int rcount = 0, lcount = 0;
        int result_count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'R')
                rcount++;
            else if (s.charAt(i) == 'L')
                lcount++;
            if (rcount == lcount)
                result_count++;
        }

        return result_count;
    }
}