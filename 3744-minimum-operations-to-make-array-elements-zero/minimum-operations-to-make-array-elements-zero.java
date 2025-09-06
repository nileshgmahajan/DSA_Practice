class Solution 
{
    public long minOperations(int[][] queries) 
    {
        long ans=0;
        for(int [] q:queries)
        {
            int l=q[0],r=q[1];
            ans +=operation(l,r);
        }

        return ans;
        
    }
    private long operation(long l,long r)
    {
        long total=0;
        for(int k=1; ; k++)
       {
        long start=(long)Math.pow(4,k - 1);
        long end=(long)Math.pow(4,k) - 1;
        if(start > r)break;

        long left=Math.max(start,l);
        long right=Math.min(end,r);
        if(left <=right)
        {
                long count=right - left + 1;
                total +=count * k;
        }
    }
    return (total + 1)/2;
}
}
