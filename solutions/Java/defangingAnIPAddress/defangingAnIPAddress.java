// Source : https://leetcode.com/problems/defanging-an-ip-address/

// Author : Jackwin Hui

// Date : 2020-10-30

/*

Given a valid (IPv4) IP address, return a defanged version of that IP address.

A defanged IP address replaces every period "." with "[.]".


Example 1:
Input: address = "1.1.1.1"
Output: "1[.]1[.]1[.]1"

Example 2:
Input: address = "255.100.50.0"
Output: "255[.]100[.]50[.]0"


*/

class Solution {
    public String defangIPaddr(String address) {
        String newAddress = "";
        for (int i = 0; i < address.length(); i++) {
            if (address.substring(i, i + 1).equals("."))
                newAddress += "[.]";
            else
                newAddress += address.substring(i, i + 1);
        }
        return newAddress;
    }
}