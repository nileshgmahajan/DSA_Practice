class Solution {
    public int differenceOfSum(int[] nums) 
    {
        int sumelement=0;
        int digitSum=0;

        for(int num:nums)
        {
            sumelement +=num;

            int temp=num;
            while(temp > 0)
            {
                digitSum +=temp % 10;
                temp /=10;
            }
        }

        return Math.abs(sumelement - digitSum);
        
    }
}