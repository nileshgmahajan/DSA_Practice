class Solution {
    public boolean isPalindrome(String s) {

        StringBuilder cleancharcter = new StringBuilder();

        for (char c : s.toCharArray())//string conver into the array form becaused esaily iteratons
        {
            if (Character.isLetterOrDigit(c))//if charcter is digit or letter then apend the StringBuilder
            {
                cleancharcter.append(Character.toLowerCase(c));//every capital letter conver lower letter
            }
        }

        int left = 0, right = cleancharcter.length() - 1;

        while (left < right) {
            ///if left pointer and right pinter not equal then return false otherwise true
            if (cleancharcter.charAt(left) != cleancharcter.charAt(right)) {
                return false;
            }
            left++;// left pointer increment by one
            right--;//right pointer decrease by one
        }

        return true;
    }
}