class Solution {
    public int majorityElement(int[] nums) {

          Map<Integer,Integer> frequency=new HashMap<>();
          int n=nums.length;

          for(int num:nums)
          {
            frequency.put(num,frequency.getOrDefault(num,0) + 1);
            if(frequency.get(num) > n / 2)
            {
                return num;
            }
          }
           
          return -1;
       

    }
}