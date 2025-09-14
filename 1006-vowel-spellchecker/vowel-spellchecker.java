class Solution {
    public String[] spellchecker(String[] wordlist, String[] queries) {
        Set<String> exword=new HashSet<>(Arrays.asList(wordlist));

        Map<String,String> caseIns=new HashMap<>();
        Map<String,String> vowelIns=new HashMap<>();

        for(String word:wordlist)
        {
            String lower=word.toLowerCase();
            caseIns.putIfAbsent(lower,word);
            vowelIns.putIfAbsent(normalize(lower),word);
        }  

        String[] result=new String[queries.length];

        for(int i=0;i<queries.length;i++)
        {
            String query=queries[i];


            if(exword.contains(query))
            {
                result[i]=query;
            }else
            {
                String lower=query.toLowerCase();

                if(caseIns.containsKey(lower))
                {
                    result[i]=caseIns.get(lower);
                }else
                {
                    String normlized=normalize(lower);
                    result[i]=vowelIns.getOrDefault(normlized, "");
                }
            }
        } 
        return result;     
    }
    private String normalize(String word)
    {
        StringBuilder sb=new StringBuilder();
        for(char c:word.toCharArray())
        {
            if("aeiou".indexOf(c)>=0)
            {
                sb.append('*');
            }else
            {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}