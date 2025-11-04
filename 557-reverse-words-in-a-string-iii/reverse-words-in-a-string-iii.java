class Solution {
    //Approach 2 (In-Place Two Pointer)
    //time complexity o(n);
    //space complexity o(1);
 public String reverseWords(String s) {
    char[] arr=s.toCharArray();
    int n=arr.length;

    int start=0;

    for(int end=0;end<=n;end++)
    {
        if(end == n || arr[end] ==' ')
        {
            reverse(arr,start,end - 1);
            start=end + 1;
        }

    }
     
     return new String(arr);
    }
    public void reverse(char []arr,int left,int right)
    {

        while(left < right)
        {
            char temp=arr[left];
            arr[left]=arr[right];
            arr[right]=temp;

            left ++;
            right --;
        }


        // String[] words = s.split(" ");
        // StringBuilder result = new StringBuilder();

        // for (int i = 0; i < words.length; i++) {
        //     StringBuilder reversedWord = new StringBuilder(words[i]);
        //     result.append(reversedWord.reverse());
        //     if (i < words.length - 1) {
        //         result.append(" ");
        //     }
        // }

        // return result.toString();
    }
}