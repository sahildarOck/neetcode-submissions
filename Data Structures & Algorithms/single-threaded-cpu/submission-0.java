class Solution {
     public int[] getOrder(int[][] tasks) {
        // eT
        // sorted by pT -> lowest pT on top
        // in case of same pT -> smallestIndex goes first -> order of addition

        int[] order = new int[tasks.length];

        PriorityQueue<Task> pqTasks = new PriorityQueue<>((t1, t2) -> {
            if (t1.pt != t2.pt) {
                return Integer.compare(t1.pt, t2.pt);
            }
            return Integer.compare(t1.index, t2.index);
        });

        // Sort tasks
        int[][] indexedTasks = new int[tasks.length][3];
        for(int i = 0 ; i < tasks.length ; i++) {
            indexedTasks[i][0] = tasks[i][0];
            indexedTasks[i][1] = tasks[i][1];
            indexedTasks[i][2] = i;
        }
        Arrays.sort(indexedTasks, (t1, t2) -> Integer.compare(t1[0], t2[0]));

        // Arrays.stream(tasks).forEach(t -> System.out.println("[" + t[0] + "," + t[1] + "]"));

        int currTime = indexedTasks[0][0];
        int orderIndex = 0;
        pqTasks.add(new Task(indexedTasks[0][2], indexedTasks[0][0], indexedTasks[0][1]));
        int i = 1;
        while (i < tasks.length) {
            if (indexedTasks[i][0] <= currTime) {
                pqTasks.add(new Task(indexedTasks[i][2], indexedTasks[i][0], indexedTasks[i][1]));
                i++;
            } else if (!pqTasks.isEmpty()) {
                Task t = pqTasks.poll();
                order[orderIndex++] = t.index;
                currTime += t.pt;
            } else {
                currTime = indexedTasks[i][0];
                pqTasks.add(new Task(indexedTasks[i][2], indexedTasks[i][0], indexedTasks[i][1]));
                i++;
            }
        }

        while(!pqTasks.isEmpty()) {
            Task t = pqTasks.poll();
            order[orderIndex++] = t.index;
        }

        return order;
    }

    private static class Task {
        int index;
        int et;
        int pt;

        Task(int index, int et, int pt) {
            this.index = index;
            this.et = et;
            this.pt = pt;
        }
    }
}