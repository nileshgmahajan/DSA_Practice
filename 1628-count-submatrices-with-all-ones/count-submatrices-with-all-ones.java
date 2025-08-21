class Solution {
    public int numSubmat(int[][] mat) {
        int m=mat.length;//number of rows 
        int n=mat[0].length;//number of colums
        int height[][]=new int[m][n];

        for(int j=0;j<n;j++)
        {
            height[0][j]=mat[0][j];
            for(int i=1;i<m;i++)
            {
                    height[i][j]=(mat[i][j]==1)?height[i - 1][j]+1:0;
            }
        }

        int result=0;
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                int minheight=height[i][j];
                for(int k=j;k>=0 && minheight>0;k--)
                {
                      minheight=Math.min(minheight,height[i][k]);
                      result +=minheight;
                }
            }

        }

            return result;
        
    }
}