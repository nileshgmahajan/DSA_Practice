class Solution {
    static final  int mod=1_000_000_007;
    Integer [][] memo;

    public int numberOfWays(int n, int x) {
        int maxbase=1;
        while(Math.pow(maxbase, x) <= n)
        {
            maxbase ++;
        }
        maxbase --;
        memo=new Integer[n + 1][maxbase + 2];
        return dfs(n , 1,x, maxbase);
    }
    private int dfs(int rem,int num,int x,int maxbase)
    {
        if(rem == 0)return 1;
        if(rem < 0 || num > maxbase )return 0;

        if(memo[rem][num] != null) return memo[rem][num];
        int power=(int) Math.pow(num,x);

        int include=0;
            include=dfs(rem - power , num + 1,x,maxbase);

        int skip=dfs(rem,num + 1,x,maxbase);
        return memo[rem][num]=(int)((include +(long) skip) % mod);
    }
}