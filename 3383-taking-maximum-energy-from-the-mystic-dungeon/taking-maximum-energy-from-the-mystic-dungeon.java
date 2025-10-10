class Solution {
    public int maximumEnergy(int[] energy, int k) {
        int n=energy.length;
        int [] dp=new int[n];
        long maxEnergy=Long.MIN_VALUE;


        for(int i=n - 1;i>=0;i--)
        {
            //dp[i]=energy[i];
            if(i + k < n)
            {
                energy[i] +=  energy[i + k];
            }
            maxEnergy=Math.max(maxEnergy,(long) energy[i]);
        }
        return (int) maxEnergy;
        
    }
}