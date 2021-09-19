// Source : https://leetcode.com/problems/majority-element/

// Author : Jackwin Hui

// Date : 2021-09-19

/*

Given an array nums of size n, return the majority element.

The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.


Example 1:
Input: nums = [3,2,3]
Output: 3

Example 2:
Input: nums = [2,2,1,1,1,2,2]
Output: 2


*/

class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> elements = new HashMap<Integer, Integer>();
        
        int ret = 0;
        
        for (int i : nums){
            elements.put(i, elements.getOrDefault(i,0)+1);
            
            if (elements.get(i) > nums.length/2){
                ret = i;
                break;
            }
        }
        
        return ret;
    }
}