class Solution {
    public int removeElement(int[] nums, int val) 
    {
//this is brture fore approch  time complexity on o(n),space complexity o(n) beacuse used the extra sapace
        //create tempaory array
        // int [] temp=new int[nums.length];
        //     int k=0;// Count of elements not equal to val
            // Step 1: Copy elements not equal to val
        // for(int i=0;i<nums.length;i++)
        // {
        //     if(nums[i] != val)
        //     {
        //            temp[k]=nums[i];
        //            k++;
        //     }
        // }

        // // Step 2: Copy back to original array
        // for(int i=0;i<k;i++)
        // {
        //     nums[i]=temp[i];
        // }

        // return k;
    //}
    // --------------------------------


    //optimal approch Two Pointer approach with O(1) spac  in place change 
// Use one pointer i to traverse the array
// Use another pointer k to track the position where the next valid element should go.
// If nums[i] != val, place it at nums[k] and increment k.

    int k=0;// Pointer for placing valid elements

    for(int i=0;i<nums.length;i++)
    {
        if(nums[i] != val)
        {
              nums[k]=nums[i];
              k++;
        }
    }
    return k;
    }
}