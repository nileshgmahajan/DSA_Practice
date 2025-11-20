class Solution {
    public int removeDuplicates(int[] nums) 
    {
        int i=0;//slow pointer

        for(int j=1;j<nums.length;j++)
        {
            if(nums[j] != nums[i])
            {
                i++;//move the slow pointer 
                nums[i]=nums[j];//update the unique element
            }
        }
        return i + 1;//number of unique element 
    }


    /**
    So we use two pointers:

Pointer 1 → i (slow pointer)

Points to the position where the next unique element should go.

Pointer 2 → j (fast pointer)

Scans the array from start to end.

✅ Algorithm (Two Pointer Approach)

Start i = 0 (index of the last unique element)

Loop j from 1 to end

If nums[j] != nums[i]
→ Found a new unique element
→ Move i forward
→ Copy nums[j] to nums[i]

At the end, the number of unique elements is i + 1

\U0001f50d Example Dry Run

Input:

[0,0,1,1,1,2,2,3,3,4]


Start:

i = 0  
j = 1


Loop:

nums[1] == nums[0] → duplicate → skip

nums[2] != nums[0] → unique → i++ → nums[1] = 1

nums[5] != nums[1] → unique → i++ → nums[2] = 2

nums[7] != nums[2] → unique → i++ → nums[3] = 3

nums[9] != nums[3] → unique → i++ → nums[4] = 4

Final:

[0,1,2,3,4,_,_,_,_,_]


Return 5 (because i = 4 → 4 + 1).
     */
}