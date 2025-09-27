class Solution {
    public static double area(int []A,int []B,int []C)
    {
        return Math.abs((B[0] - A[0]) * (C[1] - A[1]) - (B[1] - A[1]) * (C[0] - A[0])) /2.0;
    }
    public double largestTriangleArea(int[][] points) {
        int n=points.length;
        double maxArea=0.0;
        for(int i=0;i<n;i++)
        {
            for(int j=i + 1;j<n;j++)
            {
                for(int k=j + 1;k<n;k++)
                {
                        maxArea=Math.max(maxArea,area(points[i],points[j],points[k]));
                }
            }
        }
        return maxArea;
    }
        
}