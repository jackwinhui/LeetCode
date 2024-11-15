// Source : https://leetcode.com/problems/merge-two-sorted-lists/

// Author : Jackwin Hui

// Date : 2024-3-20

/*

Merge two sorted linked lists and return it as a sorted list. The list should be made by splicing together the nodes of the first two lists.


Example 1:
Input: l1 = [1,2,4], l2 = [1,3,4]
Output: [1,1,2,3,4,4]

Example 2:
Input: l1 = [], l2 = []
Output: []

Example 3:
Input: l1 = [], l2 = [0]
Output: [0]


*/

# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution(object):
    #recursive solution
    def mergeTwoLists_recursive(self, list1, list2):
        """
        :type list1: Optional[ListNode]
        :type list2: Optional[ListNode]
        :rtype: Optional[ListNode]
        """
        if list1 == None:
            return list2
        if list2 == None:
            return list1
        if (list1.val < list2.val):
            list1.next = self.mergeTwoLists_recursive(list1.next, list2)
            return list1
        else:
            list2.next = self.mergeTwoLists_recursive(list1, list2.next)
            return list2
            
    #iterative solution
    def mergeTwoLists_iterative(self, list1, list2):
        """
        :type list1: Optional[ListNode]
        :type list2: Optional[ListNode]
        :rtype: Optional[ListNode]
        """
        ret = ListNode()
        head = ret
        
        while list1 != None or list2 != None:
            if list2 == None or list1 != None and list1.val <= list2.val:
                ret.next = list1
                list1 = list1.next
            else:
                ret.next = list2
                list2 = list2.next
            ret = ret.next
        return head.next