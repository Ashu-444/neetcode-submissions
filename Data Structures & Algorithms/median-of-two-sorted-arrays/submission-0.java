class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int m = nums1.length;
        int n = nums2.length;
        int low = 0, high = m;
        int leftSize = (m + n + 1) / 2;

        while (low <= high) {
            int mid1 = (low + high) / 2;
            int mid2 = leftSize - mid1;

            int nums1Left  = (mid1 == 0) ? Integer.MIN_VALUE : nums1[mid1 - 1];
            int nums1Right = (mid1 == m) ? Integer.MAX_VALUE : nums1[mid1];
            int nums2Left  = (mid2 == 0) ? Integer.MIN_VALUE : nums2[mid2 - 1];
            int nums2Right = (mid2 == n) ? Integer.MAX_VALUE : nums2[mid2];

            if (nums1Left <= nums2Right && nums2Left <= nums1Right) {
                int leftMax = Math.max(nums1Left, nums2Left);
                if ((m + n) % 2 == 1) {
                    return leftMax;
                }
                int rightMin = Math.min(nums1Right, nums2Right);
                return (leftMax + rightMin) / 2.0;
            } else if (nums1Left > nums2Right) {
                high = mid1 - 1;
            } else {
                low = mid1 + 1;
            }
        }

        return 0.0;
    }
}