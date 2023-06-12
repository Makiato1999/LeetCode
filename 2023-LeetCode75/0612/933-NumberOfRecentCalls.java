/**
 * easy
 * 
 * 这个题出的不好，说的不清楚，不过难度是不大，简单fifo的queue
 */

class RecentCounter {
    Queue<Integer> queue;

    public RecentCounter() {
        this.queue = new LinkedList<Integer>();
    }
    
    public int ping(int t) {
        this.queue.add(t);
        while (this.queue.peek() < t-3000) {
            this.queue.remove();
        }

        return queue.size();
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */