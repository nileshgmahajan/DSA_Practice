class Solution {
    public int makeTheIntegerZero(int num1, int num2) {
        for(int k=1;k<=60;k++)
        {
            long target=(long) num1 - (long) k * num2;

            if(target >= 0 && Long.bitCount(target) <= k &&  k<=target )//Long.bitCount() this method in java count the nmber of the 1 parserm binary number ex 110->return 2 because 2 number is prasent 
            {
                return k;
            }
 
        }
        return -1;



        
    }
}