// Source : https://leetcode.com/problems/longest-arithmetic-subsequence/

// Author : Jackwin Hui

// Date : 2020-12-4

/*

Given an array A of integers, return the length of the longest arithmetic subsequence in A.

Recall that a subsequence of A is a list A[i_1], A[i_2], ..., A[i_k] with 0 <= i_1 < i_2 < ... < i_k <= A.length - 1, and that a sequence B is arithmetic if B[i+1] - B[i] are all the same value (for 0 <= i < B.length - 1).


Example 1:
Input: A = [3,6,9,12]
Output: 4
Explanation: 
The whole array is an arithmetic sequence with steps of length = 3.

Example 2:
Input: A = [9,4,7,2,10]
Output: 3
Explanation: 
The longest arithmetic subsequence is [4,7,10].

Example 3:
Input: A = [20,1,15,3,10,5,8]
Output: 4
Explanation: 
The longest arithmetic subsequence is [20,15,10,5].


*/

class Solution {
    public int longestArithSeqLength(int[] A) {
        int[][] hash = new int[A.length][1001];
        int max = 0;
        for (int i = 1; i < A.length; i++)
            for (int j = i - 1; j >= 0; j--) {
                int diff = A[i] - A[j] + 500;
                int counttillnow = hash[j][diff];
                hash[i][diff] = Math.max(hash[i][diff], counttillnow + 1);
                max = Math.max(max, hash[i][diff]);

            }
        return max + 1;
    }
}