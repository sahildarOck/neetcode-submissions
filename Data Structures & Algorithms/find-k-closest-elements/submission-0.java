class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int left = 0;
        int right = k - 1;

        while(right < (arr.length - 1) 
        && 
        (
            arr[left] == arr[right + 1] ||
            Math.abs(arr[left] - x) > Math.abs(arr[right + 1] - x))) {
            left++;
            right++;
        }

        List<Integer> ans = new ArrayList<>();

        for(int i = left ; i < right + 1 ; i++) {
            ans.add(arr[i]);
        }

        return ans;
    }
}