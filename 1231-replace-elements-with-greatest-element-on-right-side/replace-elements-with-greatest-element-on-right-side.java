class Solution {
    public int[] replaceElements(int[] arr) {
        int n=arr.length;
        int lastElement=-1;
        for(int i=n - 1;i>=0;i--)
        {
            int temp=arr[i];
            arr[i]=lastElement;
            lastElement=Math.max(lastElement,temp);
        }
        return arr;
        
    }
}