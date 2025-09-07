class Solution {
    public int[] sumZero(int n) {
        int []  result=new int[n];
        int index=0;
        if(n % 2 ==1) //odd condition
        {
            result[index++] =0; //add the 0 if odd and also increment the index
        } 

        for(int x=1;index<n;x++)
        {
            result[index++]= x;//place the positive element and al0 increment the index 
            result[index++]=-x;//place the negative element and also incremant the index
        }
        return result;
        
    }
}