// Source : https://leetcode.com/problems/course-schedule/

// Author : Jackwin Hui

// Date : 2020-10-31

/*

There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.

    For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.

Return true if you can finish all courses. Otherwise, return false.

 

Example 1:
Input: numCourses = 2, prerequisites = [[1,0]]
Output: true
Explanation: There are a total of 2 courses to take. 
To take course 1 you should have finished course 0. So it is possible.

Example 2:
Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
Output: false
Explanation: There are a total of 2 courses to take. 
To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.



*/

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses < 1 || prerequisites == null || prerequisites.length == 0)
            return true;

        int[] degree = new int[numCourses];
        List<Integer>[] graph = new ArrayList[numCourses];

        for (int i = 0; i < graph.length; i++)
            graph[i] = new ArrayList();

        for (int i = 0; i < prerequisites.length; i++) {
            degree[prerequisites[i][0]]++;
            graph[prerequisites[i][1]].add(prerequisites[i][0]);
        }

        Queue<Integer> queue = new LinkedList();
        for (int i = 0; i < degree.length; i++)
            if (degree[i] == 0)
                queue.offer(i);

        int num = 0;

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            num++;
            for (int neighbor : graph[curr]) {
                degree[neighbor]--;
                if (degree[neighbor] == 0)
                    queue.offer(neighbor);
            }
        }
        return num == numCourses;
    }
}