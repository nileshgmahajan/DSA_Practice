class Solution {
    public int reverse(int x) {
        int no=x;
        int px=Math.abs(x);
        int sum=0;
        while(px>0)
        {
            int ld=px%10;
            px=px/10;
            if(sum>(Integer.MAX_VALUE-ld)/10)
            {
                return 0;
            }
            sum=sum*10+ld;
        }
        sum = (no < 0) ? sum*(-1) : sum;
        return sum;
    }
}