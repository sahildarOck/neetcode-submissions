class Solution {
    Set<Integer> visited = new HashSet<>();
    Set<Integer> noIssueCourse = new HashSet<>();
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, Set<Integer>> preMap = new HashMap<>();

        for(int i = 0 ; i < prerequisites.length ; i++) {
            preMap.computeIfAbsent(prerequisites[i][0], k -> new HashSet<>()).add(prerequisites[i][1]);
        }

        for(int j = 0 ; j < numCourses ; j++) {
            if(!dfs(preMap, j)) {
                return false;
            }
        }

        return true;
    }

    private boolean dfs(Map<Integer, Set<Integer>> preMap, int course) {
        if (noIssueCourse.contains(course)) {
            return true;
        }

        if (visited.contains(course)) {
            return false; // Cycle detected
        }

        Set<Integer> deps = preMap.get(course);
        if (deps == null || deps.isEmpty()) {
            noIssueCourse.add(course);  // Safe course, cache result
            return true;
        }

        visited.add(course);
        for(int dep : deps) {
            if(!dfs(preMap, dep)) {
                return false;
            }
            noIssueCourse.add(dep);
        }
        visited.remove(course);
        return true;
    }
}