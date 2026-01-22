class Solution {
    public int maxSubArray(int[] nums) {
      
    //    int maxCurrent=nums[0];
    //    int maxglobal=nums[0];

    //     for(int i=1;i<nums.length;i++)
    //     {
    //          maxCurrent=Math.max(nums[i],maxCurrent + nums[i]);
    //          maxglobal=Math.max(maxglobal,maxCurrent);

    //     }
    //     return maxglobal;
        


        int n=nums.length;
        int maxsum=nums[0],prevsum=nums[0];

        for(int i=1;i<n;i++)
        {
            if(prevsum + nums[i] > nums[i])
            {
                prevsum=prevsum + nums[i];
            }else
            {
                prevsum=nums[i];
            }
            if(prevsum > maxsum) maxsum=prevsum;
        }
        return maxsum;
    }
}