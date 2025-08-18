class Solution {

    private static final double EPSILON=1e-6;
    private static final double TARGET=24.0;
    public boolean judgePoint24(int[] cards) {
        List<Double> nums=new ArrayList<>();

        for(int c:cards)
        {
            nums.add((double) c);
        }
        return solve(nums);
    }

    private boolean solve(List<Double> nums)
    {
        if(nums.size() == 1)
        {
            return Math.abs(nums.get(0) -TARGET)< EPSILON;
        }
        for(int i=0;i<nums.size();i++)
        {
            for(int j=0;j<nums.size();j++)
            {
                if(i == j)continue;
            

            List<Double> next=new ArrayList<>();

            for(int k=0;k<nums.size();k++)
            {
                if(k != i && k != j)next.add(nums.get(k));
            }

            for(double val:compute(nums.get(i),nums.get(j)))
            {
                next.add(val);
                if(solve(next))return true;
                next.remove(next.size() -1);
            }
        }
    }
    return false;
}
private List<Double> compute(double a,double b)
{
    List<Double> result=new ArrayList<>();

    result.add(a + b );
    result.add(a -b);
    result.add(b -a);
    result.add(a * b);

    if(Math.abs(b) > EPSILON)result.add(a / b);
    if(Math.abs(a) >  EPSILON )result.add(b / a);
    return result;
}
}
