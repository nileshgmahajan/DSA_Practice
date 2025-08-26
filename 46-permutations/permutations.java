class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result=new ArrayList<>();
        backtrack(nums,0,result);
        return result;
    }
    public void backtrack(int[] nums,int start,List<List<Integer>> result)
    {
        if(start == nums.length)
        {
            List<Integer> list=new ArrayList<>();
            
            for(int num1:nums)
            {
                list.add(num1);
            }
            result.add(list);
            return ;
        }
            for(int i=start;i<nums.length;i++)
            {
                swap(nums,start,i);
                backtrack(nums,start + 1,result);
                swap(nums,start,i);
            }
        }
        private void swap(int[] nums,int i,int j)
        {
            int temp=nums[i];
            nums[i]=nums[j];
            nums[j]=temp;
         
        }
}