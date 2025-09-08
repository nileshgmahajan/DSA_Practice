class Solution {
    public int[] getNoZeroIntegers(int n) {

        for(int i=1;i<n;i++)
        {
            int a=i;
            int b=n - i;
        
            if(isNonZero(a) && isNonZero(b))
            {
                return new int[]{a,b};
            }
        }
        return new int[]{};
        
    }
    public boolean isNonZero(int num)
    {
        while(num > 0)
        {
            if(num % 10 == 0)
            {
                    return false;
            }
            num /=10;
        }
        return true;
    }
}