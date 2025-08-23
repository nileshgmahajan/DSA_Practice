class Solution {
    private static final int INF=1_000_000_000;
    public int minimumSum(int[][] grid) {
        int R=grid.length,C=grid[0].length;
        int ans=INF;

        for(int k1=0;k1<=C - 3;k1++)
        {
            for(int k2=k1 + 1;k2<=C - 2;k2++)
            {
                int a=area(grid ,0, R - 1,0 ,k1);
                int b=area(grid , 0 , R - 1,k1 + 1,k2);
                int c=area(grid , 0 , R - 1,k2 + 1,C-1);

                if(a < INF && b<INF && c< INF)
                {
                    ans=Math.min(ans,a+b+c);
                }
            }
        }

        for(int r1=0;r1<=R - 3;r1++)
        {
            for(int r2=r1 + 1;r2<=R- 2;r2++)
            {
                int a=area(grid, 0 ,r1,0,C-1);
                int b=area(grid,r1 + 1,r2,0,C - 1);
                int c=area(grid , r2 + 1,R - 1,0,C- 1);
                if(a < INF && b< INF && c<INF)
                {
                    ans=Math.min(ans,a + b +c);
                }

            }
        }

        for(int cut=0;cut<=R - 2;cut++)
        {
            for(int  k = 0;k<= C - 2 ;k++)
            {
                int a=area(grid , 0 ,cut,0,k);
                int b=area(grid,0 , cut,k + 1,C - 1);
                int c=area(grid,cut + 1,R - 1,0,C - 1);

                if(a < INF && b< INF && c<INF)
                {
                    ans=Math.min(ans,a + b + c);
                }
            }

            for(int k=0;k<=C- 2 ;k++)
            {
                int a=area(grid, 0 ,cut,0 ,C - 1);
                int  b=area(grid , cut + 1,R - 1,0 ,k);
                int c=area(grid,cut + 1, R - 1,k + 1,C- 1);
                if(a < INF && b < INF && c< INF)
                {
                    ans=Math.min(ans,a + b + c);
                }
            }
        }
        for(int cut=0;cut<= C  - 2;cut++)
        {
            for(int r=0;r<=R - 2 ;r++)
            {
                int a=area(grid, 0 ,r ,0 , cut);
                int b=area(grid, r + 1,R  - 1, 0,cut);
                int c=area(grid, 0 , R - 1,cut + 1,C - 1);
                if(a < INF && b < INF && c < INF)
                {
                    ans=Math.min(ans,a + b + c);
                }
            }
            for(int r=0;r<= R - 2;r++)
            {
                int a=area(grid,0 ,R - 1 , 0 ,cut);
                int b=area(grid , 0 ,r, cut + 1,C - 1);
                int c=area(grid, r + 1,R - 1,cut + 1 ,C - 1);
                if(a < INF && b < INF && c <INF)
                {
                    ans=Math.min(ans, a + b  + c );
                }
            }
        }
        return ans;
        
    }
    private int area(int [][] g,int r1,int r2,int c1,int c2)
    {
        int minR=Integer.MAX_VALUE,maxR=Integer.MIN_VALUE;
        int minC=Integer.MAX_VALUE,maxC=Integer.MIN_VALUE;

        for(int r=r1;r<=r2;r++)
        {
            for(int c=c1;c<=c2;c++){
                if(g[r][c] == 1)
                {
                    if(r < minR) minR=r;
                    if(r > maxR) maxR=r;
                    if( c < minC) minC=c;
                    if(c > maxC) maxC=c;
                }
            }
        }
        if(minR == Integer.MAX_VALUE) return INF;
        return (maxR - minR + 1) * (maxC - minC + 1);
    }
}