class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        // remDistance: [2, 4, 12, 7, 9]
        // speed:       [2, 4, 1, 1, 3]

        // Sort position and speed accordingly

        Map<Integer, Integer> positionSpeedMap = new TreeMap<>(Comparator.reverseOrder());

        for(int i = 0 ; i < position.length ; i++) {
            positionSpeedMap.put(position[i], speed[i]);
        }

        List<Double> remTimeList = positionSpeedMap.entrySet().stream()
        .map(entry -> 
        {
            int remDis = target - entry.getKey();
            // return remDis/entry.getValue() + (remDis % entry.getValue() != 0 ? 1 : 0);
            return (double) remDis/entry.getValue();
        })
        .collect(Collectors.toList());

        int ans = 1;

        double lastMax = remTimeList.get(0);

        for(int i = 1 ; i < remTimeList.size() ; i++) {
            if(lastMax >= remTimeList.get(i)) {
                continue;
            } else {
                lastMax = remTimeList.get(i);
                ans++;
            }
        }
        return ans;
    }
}
