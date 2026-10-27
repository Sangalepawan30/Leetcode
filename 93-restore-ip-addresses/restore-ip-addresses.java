
import java.util.*;

class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();

        backtrack(s, 0, new ArrayList<>(), result);

        return result;
    }

    private void backtrack(String s, int index,
                           List<String> parts,
                           List<String> result) {

        // If we have 4 parts, check if all digits are used
        if (parts.size() == 4) {
            if (index == s.length()) {
                result.add(String.join(".", parts));
            }
            return;
        }

        // Try taking 1, 2, or 3 digits
        for (int len = 1; len <= 3; len++) {
            if (index + len > s.length()) {
                break;
            }

            String part = s.substring(index, index + len);

            // Leading zero is not allowed
            if (part.length() > 1 && part.charAt(0) == '0') {
                break;
            }

            // Each part must be between 0 and 255
            if (Integer.parseInt(part) > 255) {
                break;
            }

            parts.add(part);

            backtrack(s, index + len, parts, result);

            // Backtrack: remove the last part
            parts.remove(parts.size() - 1);
        }
    }
}
