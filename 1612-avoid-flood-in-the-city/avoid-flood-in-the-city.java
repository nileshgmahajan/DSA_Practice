class Solution {
    public int[] avoidFlood(int[] rains) {
        int n=rains.length;
        int [] ans=new int[n];
        Map<Integer,Integer> lastRain=new HashMap<>();
        TreeSet<Integer> dryDays=new TreeSet<>();


        for(int i=0;i<n;i++)
        {
            int lake=rains[i];

            if(lake == 0)
            {
                dryDays.add(i);
                ans[i]=1;
            }else
            {
                ans[i]=-1;
                if(lastRain.containsKey(lake))
                {
                    int prevDay=lastRain.get(lake);
                    Integer dryDay=dryDays.higher(prevDay);
                    if(dryDay == null) return new int[0];
                    ans[dryDay]=lake;
                    dryDays.remove(dryDay);
                }
                lastRain.put(lake,i);
            }
        }
        return ans;
        
    }
}