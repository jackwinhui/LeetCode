// Source : https://leetcode.com/problems/valid-parentheses/

// Author : Jackwin Hui

// Date : 2024-9-26

/*

Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:
1. Open brackets must be closed by the same type of brackets.
2. Open brackets must be closed in the correct order.
3. Every close bracket has a corresponding open bracket of the same type.


Example 1:
Input: s = "()"
Output: true

Example 2:
Input: s = "()[]{}"
Output: true

Example 3:
Input: s = "(]"
Output: false


*/

class Solution(object):
    def isValid(self, s):
        """
        :type s: str
        :rtype: bool
        """
        stack = []
        
        parDict = {'(':')', '[':']', '{':'}'}

        
        for char in s:
            if char in parDict:
                stack.append(parDict[char])
            elif len(stack) == 0 or char != stack.pop():
                return False
                
        return len(stack) == 0