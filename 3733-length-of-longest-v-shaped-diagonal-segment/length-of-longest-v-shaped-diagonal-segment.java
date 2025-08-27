class Solution {
    int n,m;
    int [][] grid;
    Integer [][][][] dp;
    int [][] dirs={{1,1},{-1,-1},{1,-1},{-1,1}};
    public int lenOfVDiagonal(int[][] grid) {
        this.grid=grid;
        n=grid.length;
        m=grid[0].length;

        dp=new Integer[n][m][4][2];
        int ans=0;
        for(int r=0;r<n;r++)
        {
            for(int c=0;c<m;c++)
            {
                if(grid[r][c] == 1)
                {
                    for(int d=0;d<4;d++)
                    {
                        ans=Math.max(ans,dfs(r,c,d,0,0));
                    }
                } 
            }
        }
        return ans;
        
    }
    private int dfs(int r,int c,int dir,int turn,int step)
    {
        if(r<0 || r>=n|| c<0 ||c>=m)return 0;

        int expected;
        if(step == 0)expected=1;
        else expected =(step % 2 == 1 ? 2 :0);

        if(grid[r][c] != expected) return 0;
        if(dp[r][c][dir][turn] != null)return dp[r][c][dir][turn];

        int res=1;
        int nr=r + dirs[dir][0];
        int nc=c + dirs[dir][1];
        res=Math.max(res,1 + dfs(nr,nc,dir,turn,step + 1));

        if(turn == 0)
        {
            int ndir=turnClockWise(dir);
            nr= r + dirs[ndir][0];
            nc=c + dirs[ndir][1];
            res=Math.max(res,1+dfs(nr,nc,ndir,1,step + 1));  
        }
        return dp[r][c][dir][turn]=res;
    }
    private int turnClockWise(int dir){
    if(dir == 0) return 2;
    if(dir == 2) return 1;
    if(dir == 1) return 3;
    return 0; 
  }
}