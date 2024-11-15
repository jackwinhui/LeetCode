// Source : https://leetcode.com/problems/two-sum/

// Author : Jackwin Hui

// Date : 2024-9-26

/*

Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
You may assume that each input would have exactly one solution, and you may not use the same element twice.
You can return the answer in any order.
 
 
Example 1:
Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Output: Because nums[0] + nums[1] == 9, we return [0, 1].

Example 2:
Input: nums = [3,2,4], target = 6
Output: [1,2]

Example 3:
Input: nums = [3,3], target = 6
Output: [0,1]


*/

class Solution(object):
	#brute force method by checking every pair of elements and their respective sums. O(n^2)
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        n = len(nums)

        for i in range(n):
            key = target-nums[i]
            for j in range(i,n):
                if nums[j] == key and i != j:
                    return [i,j]
	
    #optimized method by using a hashmap and keys. O(n)
    def twoSum_optimized(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        n = len(nums)
        map = {}

        for i in range(n):
            if nums[i] in map:
                return [i, map[nums[i]]]
            else:
                map[target-nums[i]] = i

        return [0,0]