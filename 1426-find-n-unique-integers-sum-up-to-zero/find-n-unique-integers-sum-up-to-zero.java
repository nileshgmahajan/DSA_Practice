class Solution {
    public int[] sumZero(int n) {
        int []  result=new int[n];
        int index=0;
        if(n % 2 ==1) 
        {
            result[index++] =0; //add the 0 if odd
        } 

        for(int x=1;index<n;x++)
        {
            result[index++]= x;//place the positive element 
            result[index++]=-x;//place the negative element
        }
        return result;
        
    }
}