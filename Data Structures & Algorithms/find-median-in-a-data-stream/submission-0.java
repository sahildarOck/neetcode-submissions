class MedianFinder {

    
    // 6 10 2

    // 2 3 4
    private int medianIndex;
    private List<Integer> nums;

    public MedianFinder() {
        nums = new ArrayList<>();
    }
    
    public void addNum(int num) {
        addNum(num, 0, nums.size() - 1);
        if(nums.size() % 2 == 0) {
            medianIndex++;
        }
    }
    
    public double findMedian() {
        // System.out.println("nums.size() % 2: " + nums.size() % 2);
        if(nums.size() % 2 == 0) {
            // System.out.println("nums.get(medianIndex): " + nums.get(medianIndex));
            // System.out.println("nums.get(medianIndex - 1): " + nums.get(medianIndex - 1));
            return (nums.get(medianIndex) + nums.get(medianIndex - 1)) / 2d;
        }
        return nums.get(medianIndex);
    }

    private void addNum(int num, int start, int end) {
        if(start > end) {
            nums.add(start, num);
            return;
        }

        int mid = end - ((end - start) / 2);

        if(nums.get(mid) > num) {
            addNum(num, start, mid - 1);
        } else {
            addNum(num, mid + 1, end);
        }
    }
}
