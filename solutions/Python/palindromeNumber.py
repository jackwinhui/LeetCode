// Source : https://leetcode.com/problems/palindrome-number

// Author : Jackwin Hui

// Date : 2024-3-13

/*

Given an integer x, return true if x is a palindrome, and false otherwise.


Example 1:
Input: x = 121
Output: true
Explanation: 121 reads as 121 from left to right and from right to left.

Example 2:
Input: x = -121
Output: false
Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.

Example 3:
Input: x = 10
Output: false
Explanation: Reads 01 from right to left. Therefore it is not a palindrome.


*/

class Solution(object):
    #brute force method of reversing the entire int and comparing it to original
    def isPalindrome(self, x):
        """
        :type x: int
        :rtype: bool
        """
        temp = x
        reverse = 0
        if x < 0:
            return False
        while temp != 0:
            reverse = reverse * 10 + temp % 10
            temp //= 10
        return x == reverse
    
    #slightly optimized to only reverse half of the int and compare the two halves
    def isPalindrome(self, x):
        """
        :type x: int
        :rtype: bool
        """
        temp = x
        reverse = 0
        if x < 0:
            return False
        while x > reverse:
            reverse = reverse * 10 + temp % 10
            temp //= 10
        print reverse
        return x == reverse or x == reverse//10
        
    #optimized to turn int into a string and comparing it to its reverse
    def isPalindrome(self, x):
        """
        :type x: int
        :rtype: bool
        """
        return str(x) == str(x)[::-1]