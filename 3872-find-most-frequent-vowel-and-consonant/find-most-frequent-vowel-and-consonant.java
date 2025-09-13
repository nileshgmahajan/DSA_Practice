class Solution {
    public int maxFreqSum(String s) {
        
        int [] freq=new int[26];

        for(char c:s.toCharArray())
        {
            freq[c - 'a']++;
        } 
        String vowel="aeiou";
        int maxVowel=0,maxConst=0;

        for(int i=0;i<26;i++)
        {
            char ch=(char) (i + 'a');

            if(vowel.indexOf(ch) != -1)
            {
                maxVowel=Math.max(maxVowel,freq[i]);
            }else
            {
                maxConst=Math.max(maxConst,freq[i]);
            }
        }   
            return maxVowel + maxConst;
    }
}
