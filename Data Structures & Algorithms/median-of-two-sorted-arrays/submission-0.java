class Solution {
     public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] a, b;
        if(nums1.length > nums2.length) {
            a = nums2;
            b = nums1;
        } else {
            a = nums1;
            b = nums2;
        }

        int total = nums1.length + nums2.length;
        int half = (total + 1) / 2;

        if(a.length == 0) {
            if(total % 2 == 0) {
                return (b[half - 1] + b[half]) / 2.00;
            } else {
                return b[half - 1];
            }
        }
        if(b.length == 0) {
            return 0.00;
        }

        int left = 0;
        int right = a.length;

        while(left <= right) {
            int i = (left + right) / 2;
            int j = half - i;

            int aLeft =  i > 0 ? a[i - 1] : Integer.MIN_VALUE;
            int aRight = i < a.length ? a[i] : Integer.MAX_VALUE;
            int bLeft = j > 0 ? b[j - 1] : Integer.MIN_VALUE;
            int bRight = j < b.length ? b[j] : Integer.MAX_VALUE;

            if(aLeft <= bRight && bLeft <= aRight) {
                if(total % 2 == 0) {
                    return (Math.max(aLeft, bLeft) + Math.min(aRight, bRight)) / 2.00;
                } else {
                    return Math.max(aLeft, bLeft);
                }
            } else if(aLeft > bRight) {
                right = i - 1;
            } else {
                left = i + 1;
            }
        }
        return -1;
    }
}
