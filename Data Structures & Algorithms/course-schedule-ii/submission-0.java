class Solution {
    boolean[] visited;
    boolean[] visiting;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, Set<Integer>> preMap = new HashMap<>();
        visited = new boolean[numCourses];
        visiting = new boolean[numCourses];

        for(int[] pre : prerequisites) {
            preMap.computeIfAbsent(pre[0], k -> new HashSet<>()).add(pre[1]);
        }

        Set<Integer> orderSet = new LinkedHashSet<>();

        for(int i = 0 ; i < numCourses ; i++) {
            Set<Integer> currSet = new LinkedHashSet<>();
            boolean computed = computeOrder(i, preMap, currSet);
            if(!computed) {
                return new int[0];
            }
            orderSet.addAll(currSet);
        }

        return orderSet.stream().mapToInt(Number::intValue).toArray();
    }

    private boolean computeOrder(int course, Map<Integer, Set<Integer>> preMap, Set<Integer> order) {
        if(visiting[course]) {
            return false;
        }
        if(visited[course]) {
            return true;
        }
        Set<Integer> preqs = preMap.get(course);
        if(preqs == null) {
            // System.out.println("1 Adding course: " + course);
            order.add(course);
            visited[course] = true;
            return true;
        }
        visiting[course] = true;

        for(int c : preqs) {
            boolean computed = computeOrder(c, preMap, order);
            if(!computed) {
                return false;
            }
            visited[course] = true;
        }
        visiting[course] = false;
        // System.out.println("2 Adding course: " + course);
        order.add(course);
        return true;
    }
}