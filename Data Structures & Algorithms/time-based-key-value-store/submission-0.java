class TimeMap {
    Map<String, List<String>> timeMap;

    public TimeMap() {
        timeMap = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        timeMap.putIfAbsent(key, new ArrayList<>());
        timeMap.get(key).add(timestamp + "+" + value);
    }
    
    public String get(String key, int timestamp) {
        List<String> timeList = timeMap.get(key);
        if(timeList == null) {
            return "";
        }
        int start = 0;
        int end = timeList.size() - 1;
        int mid;
        String[] timeAndValue;
        String[] nextTimeAndValue;
        while(start <= end) {
            mid = (start + end) / 2;
            timeAndValue = timeList.get(mid).split("\\+");
            if(Integer.parseInt(timeAndValue[0]) == timestamp) {
                if(timestamp == 5) {
                    System.out.println("Inside 1st if");
                }
                return timeAndValue[1];
            }
            if(start == end) {
                // if(timestamp == 5) {
                //     System.out.println("Inside 2nd if");
                //     System.out.println("timeAndValue[0]: " + timeAndValue[0]);
                // }
                if(Integer.parseInt(timeAndValue[0]) < timestamp) {
                    return timeAndValue[1];
                } else if(start != 0) {
                    return timeList.get(start - 1).split("\\+")[1];
                }
            }
            if(Integer.parseInt(timeAndValue[0]) > timestamp) {
                //  if(timestamp == 5) {
                //     System.out.println("Inside 3rd if");
                //     System.out.println("timeAndValue[0]: " + timeAndValue[0]);
                // }
                end = mid - 1;
            } else {
                //  if(timestamp == 5) {
                //     System.out.println("Inside 3rd else of if");
                //     System.out.println("timeAndValue[0]: " + timeAndValue[0]);
                // }
                start = mid + 1;
            }
        }
        return "";
    }
}