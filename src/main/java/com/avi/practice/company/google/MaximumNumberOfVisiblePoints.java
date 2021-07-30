package com.avi.practice.company.google;

import java.util.List;

/**
 * You are given an array points, an integer angle, and your location, where location = [posx, posy] and points[i] = [xi, yi] both denote integral coordinates on the X-Y plane.
 * <p>
 * Initially, you are facing directly east from your position. You cannot move from your position, but you can rotate. In other words, posx and posy cannot be changed. Your field of view in degrees is represented by angle, determining how wide you can see from any given view direction. Let d be the amount in degrees that you rotate counterclockwise. Then, your field of view is the inclusive range of angles [d - angle/2, d + angle/2].
 * <p>
 * <p>
 * You can see some set of points if, for each point, the angle formed by the point, your position, and the immediate east direction from your position is in your field of view.
 * <p>
 * There can be multiple points at one coordinate. There may be points at your location, and you can always see these points regardless of your rotation. Points do not obstruct your vision to other points.
 * <p>
 * Return the maximum number of points you can see.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: points = [[2,1],[2,2],[3,3]], angle = 90, location = [1,1]
 * Output: 3
 * Explanation: The shaded region represents your field of view. All points can be made visible in your field of view, including [3,3] even though [2,2] is in front and in the same line of sight.
 * Example 2:
 * <p>
 * Input: points = [[2,1],[2,2],[3,4],[1,1]], angle = 90, location = [1,1]
 * Output: 4
 * Explanation: All points can be made visible in your field of view, including the one at your location.
 * Example 3:
 * <p>
 * <p>
 * Input: points = [[1,0],[2,1]], angle = 13, location = [1,1]
 * Output: 1
 * Explanation: You can only see one of the two points, as shown above.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= points.length <= 105
 * points[i].length == 2
 * location.length == 2
 * 0 <= angle < 360
 * 0 <= posx, posy, xi, yi <= 100
 */
public class MaximumNumberOfVisiblePoints {

    private List<List<Integer>> points;
    private List<Integer> location;
    public int visiblePoints(List<List<Integer>> points, int angle, List<Integer> location) {
            if(points == null || points.size() == 0 || location == null ) {
                return 0;
            }
            this.points = points;
            this.location = location;

            int max = Integer.MIN_VALUE;
            for(int move = 0; move < 360; move++) {
                final int visiblePoints = visiblePoints(angle + move);
                if(visiblePoints > max) {
                    max = visiblePoints;
                }
            }
            return max;
    }

    private int visiblePoints(final int angle) {
        return 0;
    }

    public static void main(String[] args) {
        int a=1;
        char c=(char)(a+'0');
        System.out.println(c);

        final char c1 = '.';
        final char c2 = '.';
        System.out.println(c1 == c2);
    }
}
