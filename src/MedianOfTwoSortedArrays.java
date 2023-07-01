/*
        4. Median of Two Sorted Arrays
    Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
    The overall run time complexity should be O(log (m+n)).

        Example 1:
    Input: nums1 = [1,3], nums2 = [2]
    Output: 2.00000
    Explanation: merged array = [1,2,3] and median is 2.

        Example 2:
    Input: nums1 = [1,2], nums2 = [3,4]
    Output: 2.50000
    Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.

        Constraints:
    nums1.length == m
    nums2.length == n
    0 <= m <= 1000
    0 <= n <= 1000
    1 <= m + n <= 2000
    -106 <= nums1[i], nums2[i] <= 106
 */

public class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length, a = 0;
        double center = (m + n)/2.0 - 1;
        int xm = 0, xn = 0;
        while (xm + xn <= center) {
            if (xm < m && xn < n) {
                if (xm + xn == center)
                    a = Math.min(nums1[xm], nums2[xn]);
                if (nums1[xm] <= nums2[xn])
                    xm++;
                else xn++;
            } else if (xm < m) {
                if (xm + xn == center)
                    a = nums1[xm];
                xm++;
            } else {
                if (xm + xn == center)
                    a = nums2[xn];
                xn++;
            }
        }
        if (xm < m && xn < n)
            a += Math.min(nums1[xm], nums2[xn]);
        else if (xm < m)
            a += nums1[xm];
        else a += nums2[xn];
        if ((center * 10) % 2 == 0)
            return a/2.0;
        return a;
    }
}
