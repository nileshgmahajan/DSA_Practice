class Solution {
    public List<Integer> majorityElement(int[] nums) {

        int majoratiyNo=nums.length/3;
         List<Integer> result = new ArrayList<>();
  
        for(int i=0;i<nums.length;i++)
        {
            int count=0;
            if(result.contains(nums[i])) 
                 continue;
            for(int j=0;j<nums.length;j++)
            {
              
                if(nums[i]== nums[j])
                {
                    count ++;
                }
            }

            if(count>majoratiyNo)
            {
                result.add(nums[i]);
            }
        }
      return result;
        
    }
}