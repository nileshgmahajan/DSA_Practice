class Solution {
    public String truncateSentence(String s, int k) {

        //Split the sentence into words
        String [] words=s.split(" ");

        StringBuilder sb=new StringBuilder();

        //used the for loop and trevers up to k  word and add each word into the SringBuilder
        for(int i=0;i<k;i++)
        {
            sb.append(words[i]);
            if(i < k - 1) sb.append(" ");//after one word add add space each word after

        }
        return sb.toString();//after join the all word 
        
    }
}