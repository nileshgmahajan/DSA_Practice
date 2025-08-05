class Solution {
    public int[] searchRange(int[] nums, int target)
     {
        int first=findBound(nums,target,true);
        if(first == -1)return new int[]{-1,-1};//target not found
        int last=findBound(nums,target,false);
        return new int[]{first,last};
        
    }
    private int findBound(int nums[],int target,boolean isFirst)
    {
        int si=0,ei=nums.length -1, result=-1;


        while(si <= ei)
        {
            int mid=si + (ei - si)/2;//calculat mid

            if(nums[mid] == target)//id is exite mid
            {
                result=mid;//simple return mid

                if(isFirst)
                {
                  ei=mid - 1;//lookup the left side
                }else
                {
                    si=mid + 1;//lookup the right side
                }
            }else if(nums[mid] < target) //go the right side
            {
                si=mid + 1;
            }else
            {
                 ei=mid - 1;//left side elemnet found
            }
            
            
        }
        return result;
    }
}