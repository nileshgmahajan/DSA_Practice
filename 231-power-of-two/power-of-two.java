class Solution {
    public boolean isPowerOfTwo(int n) {
        //n > 0 not for negative number power
        
        //n=1 ->binary-0001 ->(1 & 0)]==0 ->true
        //n=16->binary 10000->(16 & 15)==0 ->true;
        //n =3 ->binary 0011 ->(3 & 2 )==0->false
        return n > 0 && (n & (n - 1)) == 0;  
        
    }
}