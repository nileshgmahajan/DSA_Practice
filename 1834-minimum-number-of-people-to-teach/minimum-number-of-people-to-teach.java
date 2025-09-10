class Solution {
    public int minimumTeachings(int n, int[][] languages, int[][] friendships) {
        int m=languages.length;

        List<Set<Integer>> userLan=new ArrayList<>();
        for(int []lang:languages)
        {
            Set<Integer> set=new HashSet<>();

            for(int l:lang)set.add(l);
            userLan.add(set);
        }
        int ans=Integer.MAX_VALUE;

        for(int lang=1;lang<=n;lang++)
        {
            Set<Integer> need=new HashSet<>();

            for(int []f:friendships)
            {
                int u=f[0] - 1;
                int v=f[1] -1;

                boolean communicate=false;

                for(int l:userLan.get(u))
                {
                    if(userLan.get(v).contains(l))
                    {
                        communicate=true;
                        break;
                    }
                }
                if(!communicate)
                {
                    if(!userLan.get(u).contains(lang))
                    {
                        need.add(u);
                    }
                    if(!userLan.get(v).contains(lang))
                    {
                        need.add(v);
                    }
                }
            }
ans=Math.min(ans,need.size());
        
    }
    return ans;
}
}