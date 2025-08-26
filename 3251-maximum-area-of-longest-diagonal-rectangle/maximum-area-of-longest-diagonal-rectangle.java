class Solution {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        double maxDiagonal=-1;
        int maxArea=0;

        for(int i=0;i<dimensions.length;i++)
        {
            int length=dimensions[i][0];
            int width=dimensions[i][1];

                double diangonal=Math.sqrt(Math.pow(length,2) + Math.pow(width,2));
                int area=length * width;

                if(diangonal > maxDiagonal || diangonal ==  maxDiagonal && area > maxArea)
                {
                    maxDiagonal=diangonal;
                    maxArea=area;
                } 
        }
        return maxArea;
    }
}