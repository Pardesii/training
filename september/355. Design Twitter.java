class Twitter {
    public int timestamp = 1;
    class User {
        // 1- Post Tweet
        // 2- Follow
        // 3- Unfollow
        int id;
        Set<User> friends;
        Tweet t_head;
        
        public User(int id) {
            this.id = id;
            friends = new HashSet<User>();
            t_head = null;
        }
        
        public void post(int tweetId) {
            Tweet newTweet = new Tweet(tweetId);
            newTweet.next = t_head;
            t_head = newTweet;
        }
        
    }
    
    class Tweet {
        int tweetId;
        Tweet next;
        int time;
         Tweet(int id) {
            this.tweetId = id;
            this.next = null;
            time = timestamp++;
        }
    }
    
    private Map<Integer,User> hm;

    public Twitter() {
        hm = new HashMap<Integer,User>();
    }
    
    public void postTweet(int userId, int tweetId) {
        if(hm.containsKey(userId)) {
            User usr = hm.get(userId);
            usr.post(tweetId);
        }
        else {
            User usr = new User(userId);
            hm.put(userId,usr);
            usr.post(tweetId);
        }
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new ArrayList<Integer>();
        User usr;
        if(hm.containsKey(userId)) {
            usr = hm.get(userId);
        }
        else {
            usr = new User(userId);
            hm.put(userId,usr);
        }
        
        PriorityQueue<Tweet> pq = new PriorityQueue<Tweet>((a,b)->{
            return -Integer.compare(a.time,b.time);
        });
        if(usr.t_head != null)pq.add(usr.t_head);
        for(User fr: usr.friends) {
            if(fr.t_head != null)pq.add(fr.t_head);
        }
        int need = 10;
        while(!pq.isEmpty() && need>0) {
            Tweet temp = pq.poll();
            res.add(temp.tweetId);
            if(temp.next != null) {
                pq.add(temp.next);
            }
            need -= 1;
        }
        // List<String> ret = new ArrayList();
        // for(int i:res)ret.add((String)i);
        return res;
    }
    
    public void follow(int followerId, int followeeId) {
        User follower = getUser(followerId);
        User followee = getUser(followeeId);
        follower.friends.add(followee);
    }
    
    public void unfollow(int followerId, int followeeId) {
        User follower = getUser(followerId);
        User followee = getUser(followeeId);
        follower.friends.remove(followee);
    }
    
    public User getUser(int id) {
        User usr;
        if(hm.containsKey(id)) {
            usr = hm.get(id);
        }
        else {
            usr = new User(id);
            hm.put(id,usr);
        }
        return usr;
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<String> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */