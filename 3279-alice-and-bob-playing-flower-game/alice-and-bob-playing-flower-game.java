class Solution {
    public long flowerGame(int n, int m) {
        long even=n / 2;
        long odd=n - even;
        long evenM=m / 2;
        long oddM=m- evenM;
        

        return odd * evenM + even * oddM;
        
    }
}