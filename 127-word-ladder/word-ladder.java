import java.util.*;

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        // If endWord is not present, transformation is impossible
        if (!wordList.contains(endWord)) {
            return 0;
        }

        // Store words for O(1) lookup
        Set<String> wordSet = new HashSet<>(wordList);

        // BFS queue
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);

        // Number of words in the current transformation
        int level = 1;

        while (!queue.isEmpty()) {

            int size = queue.size();

            // Process all words at this level
            for (int i = 0; i < size; i++) {

                String word = queue.poll();

                // Try changing every character
                char[] chars = word.toCharArray();

                for (int j = 0; j < chars.length; j++) {

                    char original = chars[j];

                    // Replace with every possible character
                    for (char c = 'a'; c <= 'z'; c++) {

                        if (c == original) {
                            continue;
                        }

                        chars[j] = c;

                        String newWord = new String(chars);

                        // We found the destination
                        if (newWord.equals(endWord)) {
                            return level + 1;
                        }

                        // If this word exists in dictionary
                        if (wordSet.contains(newWord)) {
                            queue.offer(newWord);

                            // Mark as visited
                            wordSet.remove(newWord);
                        }
                    }

                    // Restore original character
                    chars[j] = original;
                }
            }

            level++;
        }

        // No transformation possible
        return 0;
    }
}