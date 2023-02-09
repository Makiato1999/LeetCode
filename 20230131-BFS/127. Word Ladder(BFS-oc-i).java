// normal BFS breadth-first search 
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        int step = 1;

        while (!queue.isEmpty()) {
            int queueSize = queue.size();
            for (int i = 0; i < queueSize; i++) {
                String currWord = queue.poll();
                if (currWord.equals(endWord)) {
                    return step;
                } else {
                    for (int j = 0; j < currWord.length(); j++) {
                        // look for all replacable letters from dictionary
                        for (char letter = 'a'; letter <= 'z'; letter++) {
                            StringBuilder next = new StringBuilder(currWord);
                            next.setCharAt(j, letter);
                            // compose a word called nextword
                            String nextWord = next.toString();
                            if (set.contains(nextWord)) {
                                // if nextword is same as endword, then finish
                                if (nextWord.equals(endWord)) {
                                    return step+1;
                                } else {
                                    // already find target word, then remove it from wordList
                                    set.remove(nextWord);
                                    // update queue, insert nextword in queue
                                    queue.offer(nextWord);
                                }
                            }
                        }
                    }
                }
            }
            step++;
        }
        return 0;
    }
}