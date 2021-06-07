// Source : https://leetcode.com/problems/reverse-integer/

// Author : Jackwin Hui

// Date : 2021-05-10

/*

Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.

Assume the environment does not allow you to store 64-bit integers (signed or unsigned).
 

Example 1:
Input: x = 123
Output: 321

Example 2:
Input: x = -123
Output: -321

Example 3:
Input: x = 120
Output: 21

Example 4:
Input: x = 0
Output: 0


*/

class Solution {
    public int reverse(int x) {
        int ret = 0;
        while (x != 0) {
            int end = x % 10;
            int newRet = ret * 10 + end;
            if ((newRet - end) / 10 != ret)
                return 0;
            ret = newRet;
            x /= 10;
        }

        return ret;
    }
}