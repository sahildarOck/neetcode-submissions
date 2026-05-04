class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        // bananas / hour
        // maxThatWorks -> max of piles;
        // 27 bananas in 8 hours -> 4 / hour
        // 3, 6, 7, 11
        // 1, 2, 2, 3
        // 0, 2, 3, 7 - left with 4 hours
        
        // 88 / 5 = 18 / hour
        // 4, 11, 20, 23, 30
        // 1, 1, 2, 2, 2 - 8 hours

        // 88 bananas in 6 hours = 15 / hour
        // 2, 1, 2, 1, 2 = 8 hours - 6 hours 2nd largest than 15 -> 23

        long totalBananas = 0;
        for(int pile : piles) {
            totalBananas += pile;
        }

        int minBananasPerHour = (int) (totalBananas / h) + (totalBananas % h != 0 ? 1 : 0);

        int timeTakenWithMinPossible = 0;
        for(int pile : piles) {
            timeTakenWithMinPossible += (pile / minBananasPerHour) + (pile % minBananasPerHour != 0 ? 1 : 0);
        }

        int difference = timeTakenWithMinPossible - h;

        if(difference <= 0) {
            return minBananasPerHour;
        }

        // Search between minBananasPerHour to piles[piles.length - 1] to find the min
        int start = minBananasPerHour;
        int end = Arrays.stream(piles).max().getAsInt();
        int ans = end;

        while(start <= end) {
            int k = (start + end) / 2;
            long totalHours = 0;
            for(int pile : piles) {
                totalHours += Math.ceil((double) pile / k);
            }
            if(totalHours <= h) {
                ans = k;
                end = k - 1;
            } else {
               start = k + 1; 
            }
        }

        return ans;

        // find the number which is difference greater than minBananasPerHour;
        // System.out.println("difference: " + difference);
        // System.out.println("minBananasPerHour: " + minBananasPerHour);
        // int temp = getJustSmallerThanOrEqual(piles, minBananasPerHour, 0, piles.length);
        // System.out.println("getJustSmallerThanOrEqual: " + temp);
        // System.out.println("piles[temp]: " + piles[temp]);
        // return piles[temp + difference - 1];
    }

}
