class Solution {
    public int minimumArea(int[][] grid) {
        int row=grid.length;
        int coloum=grid[0].length;
        int minrow=row, maxrow=-1;
        int mincol=coloum,maxcol=-1;

        for(int i=0;i<row;i++)
        {
            for(int j=0;j<coloum;j++)
            {
                 if(grid[i][j] == 1)
                 {
                        minrow=Math.min(minrow,i);
                        maxrow=Math.max(maxrow,i);
                        mincol=Math.min(mincol,j);
                        maxcol=Math.max(maxcol,j);
                 } 
            }
        }
        int height=maxrow - minrow + 1;
        int width=maxcol - mincol + 1;
        return height * width;
        
    }
}