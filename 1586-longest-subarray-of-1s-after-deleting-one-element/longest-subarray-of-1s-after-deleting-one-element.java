class Solution {
    public int longestSubarray(int[] nums) {
       
       int left=0,maxlen=0,zeroes=0;

        for(int right=0;right<nums.length;right++)
        {
             if(nums[right] == 0)//count number of zeroes
             {
                zeroes++;
             }
             while(zeroes > 1) //if more than one zeroes  remove one zeros
             {
                if(nums[left] == 0)
                {
                    zeroes --;
                }
                left ++;//move the left pointer by one 
             }
             maxlen=Math.max(maxlen , right - left );
        }
        return maxlen;
    }
}