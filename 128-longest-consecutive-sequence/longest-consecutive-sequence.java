import java.util.*;

class Solution {
    public int longestConsecutive(int[] nums) {

        // Store all numbers in HashSet
        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }

        int longest = 0;

        // Check every number
        for (int num : set) {

            // Start only if num is the beginning
            if (!set.contains(num - 1)) {

                int current = num;
                int length = 1;

                // Find consecutive numbers
                while (set.contains(current + 1)) {
                    current++;
                    length++;
                }

                // Update maximum
                longest = Math.max(longest, length);
            }
        }

        return longest;
    }
}