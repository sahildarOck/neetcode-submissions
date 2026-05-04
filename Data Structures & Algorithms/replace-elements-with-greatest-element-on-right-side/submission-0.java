class Solution {
    public int[] replaceElements(int[] arr) {
        int[] res = new int[arr.length];

        Integer max = arr[arr.length - 1];
        res[arr.length - 1] = -1;
        for(int i = arr.length - 2 ; i > -1 ; i--) {
            res[i] = max;
            if(max < arr[i]) {
                max = arr[i];
            }
        }
        return res;
    }
}