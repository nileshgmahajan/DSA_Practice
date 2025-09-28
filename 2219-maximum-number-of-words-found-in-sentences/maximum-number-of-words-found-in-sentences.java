class Solution {
    public int mostWordsFound(String[] sentences)
    {
        int max=0;
        for(String s:sentences)
        {
            int count=s.split(" ").length;
            max=Math.max(max,count);
        }
        return max;
        
    }
}