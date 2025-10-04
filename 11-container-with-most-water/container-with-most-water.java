class Solution {
    public int maxArea(int[] height) {
        int left=0;
        int right=height.length - 1;

        int maxwater=0;
        while(left <  right)
        {
            int ht=Math.min(height[left],height[right]);//find minimum height
            int width=right - left;//find distance
            int curruntWater=ht * width;
            maxwater=Math.max(maxwater,curruntWater);

//check the height if left pointer height less than right then left ++ otherwise right --
            if(height[left] < height[right])
            {
                left ++ ;
            }else
            {
                right --;
            }
        }
        return maxwater;//return max water 
    }
}