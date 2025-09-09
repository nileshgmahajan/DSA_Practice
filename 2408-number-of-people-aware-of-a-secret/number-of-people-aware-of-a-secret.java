class Solution {
    public int peopleAwareOfSecret(int n, int delay, int forget) {
        int MOD=1000000007;
        long[] dp=new long[n + 1];
        long[] share=new long[n + 2];

        dp[1]=1;
        share[1 + delay] +=1;
        share[1 + forget] -=1;

        for(int day=2;day<=n;day++)
        {
            share[day]=(share[day] + share[day - 1]) % MOD;
            dp[day]=(dp[day] + share[day]) % MOD;

            if(dp[day] > 0)
            {
                if(day + delay <= n)
                {
                    share[day + delay]=(share[day + delay] + dp[day]);
                }
                if(day + forget <=n)
                {
                    share[day + forget]=(share[day + forget] - dp[day] + MOD) % MOD;
                }
            }
        }
        long result=0;
        for(int i=n - forget + 1;i<=n;i++)
        {
            result=(result + dp[i]) % MOD;
        } 
        return (int)result;       
    }
}