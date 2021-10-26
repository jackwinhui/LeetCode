// Source : https://leetcode.com/problems/k-closest-points-to-origin/

// Author : Jackwin Hui

// Date : 2021-10-25

/*

Given an array of points where points[i] = [xi, yi] represents a point on the X-Y plane and an integer k, return the k closest points to the origin (0, 0).

The distance between two points on the X-Y plane is the Euclidean distance (i.e., √(x1 - x2)2 + (y1 - y2)2).

You may return the answer in any order. The answer is guaranteed to be unique (except for the order that it is in).
 

Example 1:
Input: points = [[1,3],[-2,2]], k = 1
Output: [[-2,2]]
Explanation:
The distance between (1, 3) and the origin is sqrt(10).
The distance between (-2, 2) and the origin is sqrt(8).
Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
We only want the closest k = 1 points from the origin, so the answer is just [[-2,2]].

Example 2:
Input: points = [[3,3],[5,-1],[-2,4]], k = 2
Output: [[3,3],[-2,4]]
Explanation: The answer [[-2,4],[3,3]] would also be accepted.


*/

class Solution {
    // calculates distance of point from origin
    public Double calculateDistance(int[] arr) {
        return Math.sqrt(Math.pow(arr[0], 2) + Math.pow(arr[1], 2));
    }

    // hashmap implementation
    public int[][] kClosestMap(int[][] points, int k) {
        // key: index of point in int[][] points, value: distance of point
        HashMap<Integer, Double> map = new HashMap<>();

        int i = 0;
        for (int[] arr : points) {
            map.put(i, calculateDistance(arr));
            i++;
        }

        List<Map.Entry<Integer, Double>> sortList = new LinkedList<>(map.entrySet());
        Collections.sort(sortList, (a, b) -> a.getValue().compareTo(b.getValue()));

        int[][] ret = new int[k][2];
        i = 0;
        for (Map.Entry entry : sortList) {
            int key = (int) entry.getKey();
            ret[i][0] = points[key][0];
            ret[i][1] = points[key][1];
            i++;
            if (i == k)
                break;
        }

        return ret;
    }

    // sorting implementation
    public int[][] kClosestSort(int[][] points, int k) {
        Double[] distances = new Double[points.length];

        int i = 0;
        for (int[] arr : points) {
            distances[i] = calculateDistance(arr);
            i++;
        }

        Arrays.sort(distances);

        Double kthDistance = distances[k - 1];

        int[][] ret = new int[k][2];

        i = 0;
        for (int[] arr : points) {
            if (calculateDistance(arr) <= kthDistance) {
                ret[i][0] = arr[0];
                ret[i][1] = arr[1];
                i++;
            }
        }

        return ret;
    }
}