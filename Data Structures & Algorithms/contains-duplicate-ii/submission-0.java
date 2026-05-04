class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if(k == 0) {
            return false;
        }

        Set<Integer> numsSet = new LinkedHashSet<>();
        numsSet.add(nums[0]);
        Iterator<Integer> itr;
        for(int i = 1 ; i < nums.length ; i++) {
            if(numsSet.size() > k) {
                itr = numsSet.iterator();
                itr.next();
                itr.remove();
            }
            if(numsSet.contains(nums[i])) {
                return true;
            }
            numsSet.add(nums[i]);
        }
        return false;
    }
}