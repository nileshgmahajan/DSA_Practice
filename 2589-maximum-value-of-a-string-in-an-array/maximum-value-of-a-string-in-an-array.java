class Solution {
    public int maximumValue(String[] strs) {
        
        int maxValue = 0;

        // Step 1: Loop through each string
        for (String s : strs) {
            boolean isNumber = true;

            // Step 2: Manually check if all characters are digits
            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);
                if (ch < '0' || ch > '9') {  // if not a digit
                    isNumber = false;
                    break;
                }
            }

            // Step 3: Calculate value based on type
            int value;
            if (isNumber) {
                value = Integer.parseInt(s);  // convert to integer
            } else {
                value = s.length();  // take length
            }

            // Step 4: Update max
            if (value > maxValue) {
                maxValue = value;
            }
        }

        // Step 5: Return the result
        return maxValue;
    }
}