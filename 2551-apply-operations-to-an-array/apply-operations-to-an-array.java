class Solution {
    public int[] applyOperations(int[] nums) {
        int n=nums.length;
            
            //apply the array operation
        for(int i=0;i<n - 1;i++)
        {
            if(nums[i] == nums[i + 1])
            {
                nums[i] *=2;
                nums[i + 1]=0;
            }
        }

        //step 2 move to the zero to the end
        int k=0;
        for(int i=0;i<n;i++)
        {
            if(nums[i] != 0)
            {
                int temp=nums[i];
                nums[i]=nums[k];
                nums[k]=temp;
                k++;
            }
        }
return nums;
        
    }
}