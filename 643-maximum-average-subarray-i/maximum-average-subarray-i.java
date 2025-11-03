class Solution {
    public double findMaxAverage(int[] nums, int k) {

        int n=nums.length;
        double currentWindowSum=0;
        //sum of the current window
        for(int i=0;i< k ;i++)
        {
            currentWindowSum +=nums[i];
        }
        double maxsum=currentWindowSum;


 ///
        for(int i=k;i<n;i++)
        {
            //add the new element in window and remove the first window element
            currentWindowSum +=nums[i] - nums[i - k]; 
            maxsum =Math.max(maxsum,currentWindowSum);
        }
        return maxsum / k;

        
    }
}