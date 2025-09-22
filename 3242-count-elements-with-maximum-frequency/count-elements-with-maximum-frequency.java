class Solution {
    public int maxFrequencyElements(int[] nums) {
        int n=nums.length;
        int maxFreq=0;
        for(int i=0;i<n;i++)
        {
            int count=0;
            for(int j=0;j<n;j++)
            {
                if(nums[i] == nums[j])
                {
                    count ++;
                }
            }
            maxFreq=Math.max(maxFreq,count);
        }

        int total=0;

        for(int i=0;i<n;i++)
        {
            int count=0;
            for(int j=0;j<n;j++)
            {
                if(nums[i] == nums[j])
                {
                    count++;
                }
            }

            if(count == maxFreq)
            {
                total +=count;
            for(int k=0;k<n;k++)
            {
                if(nums[k] == nums[i])
                {
                    nums[k]=-1;
                }
            }
        }

    }
    return total;
}
}