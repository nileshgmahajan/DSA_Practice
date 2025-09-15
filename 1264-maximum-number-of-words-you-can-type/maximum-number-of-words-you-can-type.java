class Solution 
{
    public int canBeTypedWords(String text, String brokenLetters) 
    {
        HashSet<Character> st=new HashSet<>();

        for(char c:brokenLetters.toCharArray())
        {
            st.add(c);
        }
        String[] word=text.split(" ");
        int count=0;

        for(String w:word)
        {
            boolean set=true;

            for(char c:w.toCharArray())
            {
                if(st.contains(c))
                {
                    set=false;
                    break;
                }
            }
            if(set)
            {
                count++;
            }
        }
    return count;
    }
}
