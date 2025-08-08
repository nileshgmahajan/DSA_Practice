class Solution {
    public double soupServings(int n) {
        if(n > 4800)
        {
            return 1.0;
        }
        int N=(int)Math.ceil(n / 25.0);
        Double [][] demo=new Double[N + 1][N + 1];
        return dfs(N, N,demo);
    }

    private double dfs(int a,int b, Double[][] demo)
    {
        if(a <= 0 && b <= 0  )
        {
            return 0.5;
        }
        if(a <= 0)
        {
            return 1.0;
        }if(b <= 0)
        {
           return 0.0;
        }

        if(demo[a][b] != null)
        {
            return demo[a][b];
        }

        double ans=0.25 *(
            dfs(a - 4 ,b ,demo)+
            dfs( a- 3,b- 1,demo)+
            dfs(a - 2,b - 2,demo)+
            dfs(a -1 ,b - 3,demo));
            demo[a][b]=ans;
            return ans;
}
}