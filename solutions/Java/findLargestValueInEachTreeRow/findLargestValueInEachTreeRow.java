// Source : https://leetcode.com/problems/find-largest-value-in-each-tree-row/

// Author : Jackwin Hui

// Date : 2021-10-26

/*

Given the root of a binary tree, return an array of the largest value in each row of the tree (0-indexed).
 

Example 1:
Input: root = [1,3,2,5,3,null,9]
Output: [1,3,9]

Example 2:
Input: root = [1,2,3]
Output: [1,3]

Example 3:
Input: root = [1]
Output: [1]

Example 4:
Input: root = [1,null,2]
Output: [1,2]

Example 5:
Input: root = []
Output: []


*/

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class Solution {
    public List<Integer> largestValues(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        List<Integer> ret = new ArrayList<Integer>();

        queue.add(root);

        int queueSize;
        if (root == null)
            queueSize = 0;
        else
            queueSize = 1;

        while (queueSize > 0) {
            int largestElement = Integer.MIN_VALUE;
            for (int i = 0; i < queueSize; i++) {
                TreeNode curr = queue.poll();
                largestElement = Math.max(curr.val, largestElement);
                if (curr.left != null)
                    queue.add(curr.left);
                if (curr.right != null)
                    queue.add(curr.right);
            }
            ret.add(largestElement);
            queueSize = queue.size();
        }

        return ret;
    }
}