class Twitter {

    int tweetTime;
    Map<Integer, Set<Integer>> followerFolloweeMap;
    Map<Integer, List<int[]>> tweetMap;

    public Twitter() {
        followerFolloweeMap = new HashMap<>();
        tweetMap = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        tweetMap.putIfAbsent(userId, new ArrayList<>());
        tweetMap.get(userId).add(new int[] { tweetTime++, tweetId });
    }

    public List<Integer> getNewsFeed(int userId) {
        Queue<int[]> pq = new PriorityQueue<>((arr1, arr2) -> arr2[0] - arr1[0]);
        // followerFolloweeMap.forEach((k, v) -> {
        //     System.out.println(k + ": ");
        //     v.forEach(System.out::print);
        // });
        Set<Integer> followeeSet = followerFolloweeMap.get(userId);
        if(followeeSet != null) {
            followeeSet.forEach(followeeId -> {
                List<int[]> followeeTweet =  tweetMap.get(followeeId);
                if(followeeTweet != null) {
                    followeeTweet.forEach(tweet -> pq.add(tweet));
                }
            });
        }

        List<int[]> userTweets = tweetMap.get(userId);
        if(userTweets != null) {
            userTweets.forEach(pq::add);
        }

        List<Integer> newsFeed = new ArrayList<>();
        for (int i = 0; i < 10 && !pq.isEmpty(); i++) {
            newsFeed.add(pq.remove()[1]);
        }
        return newsFeed;
    }

    public void follow(int followerId, int followeeId) {
        if(followerId == followeeId) {
            return;
        }
        followerFolloweeMap.computeIfAbsent(followerId, k -> new HashSet<>()).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        followerFolloweeMap.computeIfPresent(followerId, (id, followees) -> {
            followees.remove(followeeId);
            return followees;
        });
    }
}
