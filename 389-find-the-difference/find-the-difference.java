class Solution {
    public char findTheDifference(String s, String t) {
    char mislength=0;
    int stringlength=t.length();

    for(int i=0;i<stringlength;i++)
    {
        if(i<s.length())
        {
            mislength ^=s.charAt(i);
        }
        mislength ^=t.charAt(i);
    }
      return mislength;
    }
}