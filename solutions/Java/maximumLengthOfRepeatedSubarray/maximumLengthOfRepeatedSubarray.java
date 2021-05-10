// Source : https://leetcode.com/problems/maximum-length-of-repeated-subarray/

// Author : Jackwin Hui

// Date : 2020-10-31

/*

Given two integer arrays nums1 and nums2, return the maximum length of a subarray that appears in both arrays.


Example 1:
Input: nums1 = [1,2,3,2,1], nums2 = [3,2,1,4,7]
Output: 3
Explanation: The repeated subarray with maximum length is [3,2,1].

Example 2:
Input: nums1 = [0,0,0,0,0], nums2 = [0,0,0,0,0]
Output: 5


*/

class Solution {
    public int findLength(int[] A, int[] B) {
        int[] length = new int[B.length + 1];
        int max = 0;

        for (int i = 0; i <= A.length; i++) {
            for (int j = B.length; j >= 0; j--) {
                if (i == 0 || j == 0)
                    length[j] = 0;
                else {
                    if (A[i - 1] == B[j - 1]) {
                        length[j] = length[j - 1] + 1;
                        if (length[j] > max)
                            max = length[j];
                    } else
                        length[j] = 0;
                }
            }
        }

        return max;
    }
}