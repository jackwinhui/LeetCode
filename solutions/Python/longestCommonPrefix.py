// Source : https://leetcode.com/problems/longest-common-prefix/

// Author : Jackwin Hui

// Date : 2024-3-20

/*

Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".


Example 1:
Input: strs = ["flower","flow","flight"]
Output: "fl"

Example 2:
Input: strs = ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.


*/

class Solution(object):
    #initial solution that sorts list by length, and compares first string index by index to other strings
    def longestCommonPrefix(self, strs):
        """
        :type strs: List[str]
        :rtype: str
        """
        strs.sort(key=len)
        length = len(strs[0])
        prefix = ""
        for i in range(length):
            compare = strs[0][i]
            for inputs in strs:
                if inputs[i] != compare:
                    return prefix
            prefix += compare
        return prefix
    
    #optimized solution that sorts list alphabetically, and compares first and last string index by index (first and last string should be greatest difference)
    def longestCommonPrefix(self, strs):
        """
        :type strs: List[str]
        :rtype: str
        """
        strs.sort()
        length = min(len(strs[0]), len(strs[-1]))
        prefix = ""
        for i in range(length):
            if strs[0][i] != strs[-1][i]:
                return prefix
            prefix += strs[0][i]
        return prefix