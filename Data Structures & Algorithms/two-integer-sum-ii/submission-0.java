class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int front = 0;
        int rear = numbers.length - 1;
        int[] result = new int[2];

        while(front < rear) {
            if(numbers[front] + numbers[rear] > target) {
                rear--;
            } else if(numbers[front] + numbers[rear] < target) {
                front++;
            } else {
                result[0] = front + 1;
                result[1] = rear + 1;
                break;
            }
        }

        return result;
    }
}
