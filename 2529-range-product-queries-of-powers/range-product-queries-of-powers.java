class Solution {
    public int[] productQueries(int n, int[][] queries) {
        int mod=1_000_000_007;
        List<Integer> exps=new ArrayList<>();
        for(int bit=0;bit< 31 ;bit++)
        {
            if(((n >> bit) & 1) !=0)
            {
                exps.add(bit);
            } 
        }
        int m=exps.size();
         int[] pref=new int [m];
         pref[0] =exps.get(0);
         
        for(int i=1;i<m;i++)
        {
            pref[i]=pref[i - 1] + exps.get(i);
        }
        int q=queries.length;
        int[] ans=new int[q];
        for(int i=0;i<q;i++)
        {
            int l=queries[i][0];
            int r=queries[i][1];
            long sumExp=pref[r] - (l > 0 ? pref[ l - 1] : 0);
            ans[i]=(int) madPow(2, sumExp, mod);
        }
        return ans;
    }
    private long madPow(long base,long exp,int mod)
    {
        long res=1;
        base %= mod;
        while(exp > 0)
        {
            if((exp & 1) == 1)
            {
                res =(res * base) % mod;
            }
            base=(base * base) % mod;
            exp >>=1;
        }
        return res;
    }
        
    }

