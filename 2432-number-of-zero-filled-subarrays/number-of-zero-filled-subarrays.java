class Solution {
    public long zeroFilledSubarray(int[] nums) {

        long count=0;
    long  consetiveZeros=0;

        for(int num:nums)
        {
            if(num == 0)
            {
                consetiveZeros ++;
                count +=consetiveZeros;
            }else
            {
                consetiveZeros=0;
            }
        }

        return count;
        
    }
}