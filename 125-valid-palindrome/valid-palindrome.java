
class Solution {
    public boolean isPalindrome(String s) {

        int left = 0;
        int right = s.length() - 1;

        while (left < right) {

            // Skip special characters
            if (!Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }

            // Skip special characters
            else if (!Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }

            // Compare characters
            else {
                if (Character.toLowerCase(s.charAt(left)) !=
                    Character.toLowerCase(s.charAt(right))) {
                    return false;
                }

                left++;
                right--;
            }
        }

        return true;
    }
}
