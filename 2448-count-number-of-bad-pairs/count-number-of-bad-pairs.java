class Solution {
    public long countBadPairs(int[] nums) {
        int n = nums.length;
        Map<Integer,Integer> mp = new HashMap<>();
        long cnt = 0;
        for(int i=0;i<n;i++){
            if(mp.containsKey(nums[i]-i)){
                cnt += (long)mp.get(nums[i]-i);
            }
            mp.put(nums[i]-i,mp.getOrDefault(nums[i]-i,0)+1);

        }

        return (long)n*(n-1)/2-cnt;


        
    }
}