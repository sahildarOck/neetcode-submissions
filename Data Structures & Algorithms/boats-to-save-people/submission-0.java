class Solution {
    public int numRescueBoats(int[] people, int limit) {
         Arrays.sort(people);
        // 1 2 2 3

        int numBoats = 0;
        int front = 0;
        int rear = people.length - 1;

        while(front < rear) {
            if(people[front] + people[rear] <= limit) {
                numBoats++;
                rear--;
                front++;
            } else {
                numBoats++;
                rear--;
            }
        }

        if(front == rear) {
            numBoats++;
        }

        return numBoats;
    }
}