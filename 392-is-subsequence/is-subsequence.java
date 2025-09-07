class Solution {
    public boolean isSubsequence(String s, String t) {
        int i=0,j=0;//asing the two pointer 

        while(i<s.length() && j<t.length()) //loop  travers up to s length and t length
        {
            if(s.charAt(i) == t.charAt(j)) //match the both character is equal move the i pinter and 
            {
                i++;
            }
                j++;
        }
        return i==s.length();
    }
}