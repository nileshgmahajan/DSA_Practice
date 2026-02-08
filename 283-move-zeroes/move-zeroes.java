class Solution {
    public void moveZeroes(int[] nums) {
        
        //used the two pointer approch in place changes tine complexity o(n);
        int k=0;//// Position to place non-zero element

         // Step 1: Move all non-zero elements forward using swapinng and incremnet he index k
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i] != 0)
            {
                int temp=nums[i];
                nums[i]=nums[k];
                nums[k]=temp;
                k++;
            }
        }


    }
}