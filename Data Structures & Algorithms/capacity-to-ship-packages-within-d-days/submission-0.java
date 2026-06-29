class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int minCapacity = 0;
        int maxCapacity = 0;
        for (int i = 0; i < weights.length; i++) {
            minCapacity = Math.max(minCapacity, weights[i]);
            maxCapacity += weights[i];
        }

        int left = minCapacity;
        int right = maxCapacity;
        int mid;
        while (left < right) {
            mid = left + (right - left) / 2;
            int minDaysRequired = getMinNumberOfDaysRequired(weights, mid);
            if (minDaysRequired <= days) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private int getMinNumberOfDaysRequired(int[] weights, int capacity) {
        int minDays = 1;
        int currWeight = 0;
        for (int i = 0; i < weights.length; i++) {
            if(currWeight + weights[i] > capacity) {
                minDays++;
                currWeight = 0;
            }
            currWeight += weights[i];
        }
        return minDays;
    }
}