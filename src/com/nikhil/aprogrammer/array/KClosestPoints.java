package com.nikhil.aprogrammer.array;

import java.util.Arrays;

/**
 * Implementing a program to find the K closest Points from the origin.
 *
 * @author Nikhil Kumar Mengani.
 */
public class KClosestPoints {

    /**
     * This method takes the array of points and return the K closest points to the origin. The origin here is [0, 0].
     * Using {@link java.util.Comparator} to sort the given array of points based on the distance from origin.
     *
     * @param points Given Array of points.
     * @param K      Number of closest points to origin to be returned.
     * @return Returns the K closest points to origin.
     */
    public int[][] kClosest(int[][] points, int K) {
        if (points == null || points.length == 0) {
            return points;
        }
        int[][] result = new int[K][2];

        Arrays.sort(points, (a, b) -> {
            int aDist = a[0] * a[0] + a[1] * a[1];
            int bDist = b[0] * b[0] + b[1] * b[1];
            return aDist - bDist;
        });

        for (int i = 0; i < K; i++) {
            result[i][0] = points[i][0];
            result[i][1] = points[i][1];
        }

        return result;
    }
}
