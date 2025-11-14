class Solution {
    public int countAsterisks(String s) {
        boolean between=false;
        int count=0;

        for(char ch:s.toCharArray())
        {
            if(ch == '|')
            {
                between=!between;
            }else if(ch == '*' && !between)
            {
                count++;
            }
        }
        return count;
        
    }

}