class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result=new ArrayList<>();
        backtrack(0,nums,new ArrayList<>(),result);
        return result;
        
    }

    public void backtrack(int index,int[] nums,List<Integer> currunt,List<List<Integer>> result)
    {
        result.add(new ArrayList<>(currunt));

        for(int i=index;i<nums.length;i++)
        {
            currunt.add(nums[i]);
            backtrack(i + 1,nums,currunt,result);
            currunt.remove(currunt.size() - 1);
        }
    }
}