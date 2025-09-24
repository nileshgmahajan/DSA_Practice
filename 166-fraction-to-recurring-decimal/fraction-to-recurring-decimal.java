class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) return "0";

        StringBuilder sb = new StringBuilder();

        // sign
        if ((numerator < 0) ^ (denominator < 0)) sb.append('-');

        // work in long to avoid overflow (Integer.MIN_VALUE)
        long n = Math.abs((long) numerator);
        long d = Math.abs((long) denominator);

        // integer part
        sb.append(n / d);
        long rem = n % d;
        if (rem == 0) return sb.toString();

        sb.append('.');

        // map remainder -> index in sb where the next fractional digit will be placed
        Map<Long, Integer> seen = new HashMap<>();
        while (rem != 0) {
            if (seen.containsKey(rem)) {
                int insertPos = seen.get(rem);
                sb.insert(insertPos, '(');
                sb.append(')');
                break;
            }
            seen.put(rem, sb.length()); // next appended digit's index
            rem *= 10;
            sb.append(rem / d);
            rem %= d;
        }
        return sb.toString();
    }
        
    }