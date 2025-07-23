class Solution {
    public boolean isAnagram(String s, String t) {

        if(s.length() != t.length()) //if both string s and t not same length return false
            return false;

            int [] count=new int[26];//store the 26 chartcer all is 0

            for(int i=0;i<s.length();i++)//iterathe every charcter 
            {
                count[s.charAt(i) - 'a']++;//incremnent the count form every charcter for the string s
                count[t.charAt(i) - 'a']--;//decrement the count every charcter for the string t
            } 
            for(int c:count)
            {
                if(c != 0 )//if any mismacth charcter count 
                   return false;
            }
            return true;//if all two string charcter is match
    }
}