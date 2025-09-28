class Solution {
    public int[] runningSum(int[] nums) {
        int n=nums.length;

        int [] sum=new int[n];
        sum[0]=nums[0];//first elemet is same
        for(int i=1;i<n;i++)
        {
            sum[i]=sum[i - 1] + nums[i];//add the current element to  previors element sum

        }
        return sum;
        
    }
}