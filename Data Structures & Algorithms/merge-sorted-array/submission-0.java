class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int nums1Index = m - 1;
        int nums2Index = n - 1;
        int i;
        for(i = m + n - 1 ; i > -1 && nums1Index > -1 && nums2Index > -1 ; i--) {
            if(nums1[nums1Index] > nums2[nums2Index]) {
                nums1[i] = nums1[nums1Index--];
            } else {
                nums1[i] = nums2[nums2Index--];
            }
        }

        while(nums2Index > -1) {
            nums1[i--] = nums2[nums2Index--];
        }
    }
}