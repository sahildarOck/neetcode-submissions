class Solution {
    public String minWindow(String s, String t) {
        if (t.length() > s.length()) {
            return "";
        }
        int[] tFreq = new int[52];
        char[] tCharArray = t.toCharArray();

        for (char c : tCharArray) {
            tFreq[getIndex(c)]++;
        }

        int left = 0;
        int right = 0;

        int minLength = Integer.MAX_VALUE;
        int minLeft = 0;
        int minRight = 0;

        List<Integer> indexList = new ArrayList<>();
        int indexListIndex = 0;
        int[] sFreq = new int[52];
        int index;

        while (right < s.length()) {
            index = getIndex(s.charAt(right));
            if (tFreq[index] > sFreq[index]) {
                indexList.add(right);
                sFreq[index]++;
                if (matches(sFreq, tFreq)) {
                    // System.out.println("left: " + left);
                    // System.out.println("right: " + right);
                    // System.out.println();
                    if (minLength > right - left + 1) {
                        minLength = right - left + 1;
                        minLeft = left;
                        minRight = right;
                        if (right - left + 1 == t.length()) {
                            break;
                        }
                    }

                    indexListIndex++;
                    while (indexListIndex < indexList.size()) {
                        // System.out.println("indexListIndex: " + indexListIndex);
                        sFreq[getIndex(s.charAt(left))]--;
                        left = indexList.get(indexListIndex);
                        if (matches(sFreq, tFreq)) {
                            // System.out.println("left: " + left);
                            // System.out.println("right: " + right);
                            // System.out.println();
                            if (minLength > right - left + 1) {
                                minLength = right - left + 1;
                                minLeft = left;
                                minRight = right;
                                if (right - left + 1 == t.length()) {
                                    break;
                                }
                            }
                        } else {
                            break;
                        }
                        indexListIndex++;
                    }
                }
            } else if (tFreq[index] != 0) {
                indexList.add(right);
                sFreq[index]++;
            } else if(tFreq[getIndex(s.charAt(left))] == 0) {
                left++;
            }
            right++;
        }

        // indexList.stream().forEach(l -> System.out.print(l + ", "));

        // indexListIndex++;
        // while (indexListIndex < indexList.size()) {
        //     System.out.println("indexListIndex: " + indexListIndex);
        //     left = indexList.get(indexListIndex);
        //     sFreq[getIndex(s.charAt(left))]--;
        //     if (matches(sFreq, tFreq)) {
        //         minLength = right - left + 1;
        //         minLeft = left;
        //         minRight = right;
        //     } else {
        //         break;
        //     }
        //     indexListIndex++;
        // }
        return minLength != Integer.MAX_VALUE ? s.substring(minLeft, minRight + 1) : "";
    }

    private int getIndex(char c) {
        if (c >= 'a') {
            return c - 'a';
        } else {
            return c - 'A' + 26;
        }
    }

    private boolean matches(int[] sFreq, int[] tFreq) {
        for (int i = 0; i < 52; i++) {
            if (sFreq[i] < tFreq[i]) {
                return false;
            }
        }
        return true;
    }
}
