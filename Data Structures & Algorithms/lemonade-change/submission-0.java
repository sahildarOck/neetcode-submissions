class Solution {
    public boolean lemonadeChange(int[] bills) {
        int total = 0;
        int[] quantity = new int[3];
        for(int bill : bills) {
            switch(bill) {
                case 5 : quantity[0]++;
                break;
                case 10 : quantity[1]++;
                quantity[0]--;
                break;
                case 20 : quantity[2]++;
                if(quantity[1] > 0) {
                    quantity[1]--;
                    quantity[0]--;
                } else {
                    quantity[0] -= 3;
                }
                break;
            }
            if(quantity[0] < 0) {
                return false;
            }
        }
        return true;
    }
}