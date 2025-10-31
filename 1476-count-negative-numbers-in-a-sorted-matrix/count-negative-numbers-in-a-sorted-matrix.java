class Solution {
    public int countNegatives(int[][] grid) {
        int count=0;

        for(int i=0;i<grid.length;i++)
        {
            int left=0;
            int right=grid[i].length;


            while(left < right)
            {
                int middle=(left + right)/2;

                if(grid[i][middle] < 0)
                {
                    count +=right - middle;//// possible first negative
                    right=middle;//// check further left
                }
                else
                {
                    left=middle + 1;// // move right
                }
            }
        }
        return count;
        
    }
}