// Source : https://leetcode.com/problems/count-primes/

// Author : Jackwin Hui

// Date : 2021-10-18

/*

Given an integer n, return the number of prime numbers that are strictly less than n.

 
Example 1:
Input: n = 10
Output: 4
Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.

Example 2:
Input: n = 0
Output: 0

Example 3:
Input: n = 1
Output: 0


*/

class Solution {
    public int countPrimes(int n) {
        boolean[] notPrime = new boolean[n];
        int count = 0;

        for (int i = 2; i < n; i++) {
            if (notPrime[i] == false) {
                count++;
                for (int j = 2; i * j < n; j++)
                    notPrime[i * j] = true;
            }
        }

        return count;
    }
}