class Solution {
    public String reverseVowels(String s) {


      //time complexity for this coe o(n),space o(1) because no extra space used 
        Set<Character> vowels=new HashSet<>(Arrays.asList(
            'a','e','i','o','u','A','E','I','O','U'
        ));
        char [] chara=s.toCharArray();

        int left=0;
        int right=s.length()- 1;

        while(left < right)
        {
            while(left < right && !vowels.contains(chara[left]))
            {
                left++;
            }
            while(left < right && !vowels.contains(chara[right]))
            {
                right --;
            }

            char  temp=chara[left];
            chara[left]=chara[right];
            chara[right]=temp;

            left ++;
            right --;
        }

        return new String(chara);
        
    }
}