class Solution {
    public int maximumCount(int[] nums) {

        int pos=0;
        int neg=0;
        int c=0;
        

        for(int i=0;i<nums.length;i++)
        {
            if(nums[i] > 0 )
            {
                pos ++;
            }else if(nums[i] == 0)
            {
                c++;
            }
            else
            {
                neg ++;
            }
              

        }
       
       int max1=Math.max(pos,neg);
        return max1;
        
    }
}