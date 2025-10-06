class Solution {
    public boolean halvesAreAlike(String s) {
        int n=s.length();
        int mid=n / 2;
        int count1=0,count2=0;
        for(int i=0;i<mid;i++)
        {
            if(isVowels(s.charAt(i)))count1++;
            if(isVowels(s.charAt(i + mid)))count2++;
        }
        return count1==count2;
       
        
    }
    public boolean isVowels(char ch)
    {        return "aeiouAEIOU".indexOf(ch) != -1;
    }

}