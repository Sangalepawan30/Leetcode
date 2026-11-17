
import java.util.*;

class Solution {

    Map<String, List<String>> parents = new HashMap<>();
    List<List<String>> result = new ArrayList<>();

    public List<List<String>> findLadders(
        String beginWord,
        String endWord,
        List<String> wordList
    ) {

        Set<String> dict = new HashSet<>(wordList);

        if (!dict.contains(endWord)) {
            return result;
        }

        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);

        dict.remove(beginWord);

        boolean found = false;

        // BFS
        while (!queue.isEmpty() && !found) {

            int size = queue.size();

            Set<String> visited = new HashSet<>();

            for (int i = 0; i < size; i++) {

                String word = queue.poll();

                char[] arr = word.toCharArray();

                for (int j = 0; j < arr.length; j++) {

                    char original = arr[j];

                    for (char c = 'a'; c <= 'z'; c++) {

                        if (c == original) {
                            continue;
                        }

                        arr[j] = c;

                        String next = new String(arr);

                        if (dict.contains(next)) {

                            parents.putIfAbsent(
                                next, new ArrayList<>()
                            );

                            // Store all shortest parents
                            parents.get(next).add(word);

                            // Add each word only once per level
                            if (visited.add(next)) {

                                if (next.equals(endWord)) {
                                    found = true;
                                } else {
                                    queue.offer(next);
                                }
                            }
                        }
                    }

                    arr[j] = original;
                }
            }

            // Remove visited words after the full level
            dict.removeAll(visited);
        }

        // DFS to generate all shortest paths
        if (found) {

            List<String> path = new ArrayList<>();

            dfs(endWord, beginWord, path);
        }

        return result;
    }

    // DFS + Backtracking
    private void dfs(
        String word,
        String beginWord,
        List<String> path
    ) {

        path.add(word);

        if (word.equals(beginWord)) {

            List<String> sequence = new ArrayList<>(path);

            Collections.reverse(sequence);

            result.add(sequence);

        } else {

            for (String parent : parents.getOrDefault(
                word, Collections.emptyList()
            )) {

                dfs(parent, beginWord, path);
            }
        }

        // Backtracking
        path.remove(path.size() - 1);
    }
}
