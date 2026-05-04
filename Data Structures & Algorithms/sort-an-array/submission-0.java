class Solution {
    public int[] sortArray(int[] nums) {
        if(nums.length < 2) {
            return nums;
        }

        int mid = nums.length / 2;
        int[] l = new int[mid];
        int[] r = new int[nums.length - mid];

        for(int i = 0 ; i < mid ; i++) {
            l[i] = nums[i];
        }

        for(int j = 0 ; j < nums.length - mid ; j++) {
            r[j] = nums[j + mid];
        }

        sortArray(l);
        sortArray(r);

        merge(nums, l, r);

        return nums;
    }

    private void merge(int[] nums, int[] l, int[] r) {
        int i = 0, j = 0, k = 0;

        while(i < l.length && j < r.length) {
            if(l[i] < r[j]) {
                nums[k++] = l[i++];
            } else {
                nums[k++] = r[j++];
            }
        }

        while(i < l.length) {
            nums[k++] = l[i++];
        }

        while(j < r.length) {
            nums[k++] = r[j++];
        }
    }
}