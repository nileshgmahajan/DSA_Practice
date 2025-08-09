class Solution {
    public int trap(int[] height) {

        //Calculate The leftMax Boundry
        int leftMax[]=new int [height.length];
        leftMax[0]=height[0];
        for(int i=1;i<height.length;i++)
        {
            leftMax[i]=Math.max(height[i],leftMax[i - 1]); //compare the currunt height and height  - 1
        }

        //calculate the RightMax Boundry
        int rightMax[]=new int [height.length];
        rightMax[height.length  - 1] = height[height.length - 1];
        for(int i=height.length - 2;i>=0 ;i--)
        {
            rightMax[i]=Math.max(height[i],rightMax[ i + 1]); //compare the currunt height and height  + 1
        }

        int trappedWater=0;
    //loppp
        for(int i=0;i<height.length;i++)
        {
            //WaterLevel=max(leftMax,rightMax);
            int waterLevel =Math.min(leftMax[i],rightMax[i]);

            //trappedWater=waterLevel - height;
            trappedWater += waterLevel - height[i];
        }
        return trappedWater;
        
    }
}