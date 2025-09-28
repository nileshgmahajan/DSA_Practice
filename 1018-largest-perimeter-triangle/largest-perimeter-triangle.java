class Solution {
    public int largestPerimeter(int[] nums) {

        int n=nums.length;
        Arrays.sort(nums);
        int max=0;
        for(int i=0;i<n - 2;i++)
        {
            int curr=0;
            if(nums[i] + nums[i + 1] > nums[i + 2])
            {
                if(nums[i] + nums[i + 2]>nums[i + 1])
                {
                    if(nums[i + 1] + nums[i + 2]> nums[i])
                    {
                         curr=nums[i] + nums[i + 1]+ nums[i + 2];
                    }
                }

            }
            if(curr > max)
            {
                max=curr;
            }
        }
        return max;
        
    }
}