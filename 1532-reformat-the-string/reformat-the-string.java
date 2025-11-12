class Solution {
    public String reformat(String s) {
        List<Character> letters = new ArrayList<>();
        List<Character> digits = new ArrayList<>();

        // Step 1: Separate letters and digits
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) digits.add(c);
            else letters.add(c);
        }

        // Step 2: Check if alternation is possible
        if (Math.abs(letters.size() - digits.size()) > 1) {
            return "";
        }

        // Step 3: Decide starting type
        boolean letterFirst = letters.size() > digits.size();

        // Step 4: Merge alternately
        StringBuilder result = new StringBuilder();
        int i = 0, j = 0;
        while (i < letters.size() || j < digits.size()) {
            if (letterFirst && i < letters.size()) result.append(letters.get(i++));
            if (!letterFirst && j < digits.size()) result.append(digits.get(j++));
            letterFirst = !letterFirst; // alternate
        }

        return result.toString();
    }
}

        