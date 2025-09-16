class Solution {
    public List<Integer> replaceNonCoprimes(int[] nums) {
        List<Integer> stack=new ArrayList<>();

        for(int num:nums)
        {
            stack.add(num);


            while(stack.size() >=2)
            {
                int a=stack.get(stack.size() - 2);
                int b=stack.get(stack.size() - 1);

                int g=gcd(a,b);


                if(g == 1) break;

                long lcm=(long) a *  b / g;

                stack.remove(stack.size() - 1);
                stack.remove(stack.size() -  1);

                stack.add((int)lcm);
            }
        }

        return stack;
        
    }

    private int gcd(int a,int b)
    {
        while(b != 0)
        {
            int temp=a % b;
            a=b;
            b=temp;
        }
        return a;
    }
}