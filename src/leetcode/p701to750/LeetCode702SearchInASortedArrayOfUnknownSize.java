package leetcode.p701to750;

/**
 * 702. Search in a Sorted Array of Unknown Size
 * Medium
 *
 * Given an integer array sorted in ascending order,
 * write a function to search target in nums.
 * If target exists, then return its index, otherwise return -1.
 * However, the array size is unknown to you.
 *
 * You may only access the array using an ArrayReader interface,
 * where ArrayReader.get(k) returns the element of the array at index k (0-indexed).
 *
 * You may assume all integers in the array are less than 10000,
 * and if you access the array out of bounds, ArrayReader.get will return 2147483647.
 *
 *
 *
 * Example 1:
 * Input: array = [-1,0,3,5,9,12], target = 9
 * Output: 4
 * Explanation: 9 exists in nums and its index is 4
 *
 *
 * Example 2:
 * Input: array = [-1,0,3,5,9,12], target = 2
 * Output: -1
 * Explanation: 2 does not exist in nums so return -1
 *
 *
 * Note:
 *
 * You may assume that all elements in the array are unique.
 * The value of each element in the array will be in the range [-9999, 9999].
 */
public class LeetCode702SearchInASortedArrayOfUnknownSize {

    private interface ArrayReader {
        int get(int k);
    }

    private interface Method {
        int search(ArrayReader reader, int target);
    }

    private static final class BinarySearch implements Method {

        public int search(ArrayReader reader, int target) {
            int end = 1;
            while (true) {
                int endValue = reader.get(end);
                if (endValue == Integer.MAX_VALUE || endValue > target) {
                    break;
                } else {
                    end *= 2;
                }
            }
            int start = end / 2;
            while (start < end) {
                int mid = start + (end - start) / 2;
                int midValue = reader.get(mid);
                if (midValue == Integer.MAX_VALUE || midValue > target) {
                    end = mid;
                } else if (midValue < target) {
                    start = mid + 1;
                } else {
                    return mid;
                }
            }
            return -1;
        }
    }
}