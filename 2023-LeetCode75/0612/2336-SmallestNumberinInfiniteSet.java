/**
 * medium
 * 
 * 这个有点tricky，因为我一开始以为要生成1-1000或者生成个infinite的，实际上不需要，可以再写下
 */

class SmallestInfiniteSet {
    private HashSet<Integer> set;
    private Queue<Integer> minheap;
    private int curr_int;

    public SmallestInfiniteSet() {
        set = new HashSet<>();
        minheap = new PriorityQueue<>();
        curr_int = 1;
    }
    
    public int popSmallest() {
        int result = 0;
        if (!minheap.isEmpty()) {
            result = minheap.poll();
            set.remove(result);
        } else {
            result = curr_int;
            curr_int +=1;
        }
        return result;
    }
    
    public void addBack(int num) {
        if (curr_int <= num || set.contains(num)) {
            return;
        } else {
            minheap.add(num);
            set.add(num);
        }
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */