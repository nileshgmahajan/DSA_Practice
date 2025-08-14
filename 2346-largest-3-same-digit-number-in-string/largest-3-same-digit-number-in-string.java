class Solution {
    public String largestGoodInteger(String num) {
        
//check all largest to smallest possible "good integer"
    for(char d ='9'; d>='0';d--)//
    {
        String str=""+d+d+d;//male 999 or  888 
        if(num.contains(str))
        {
            return str;
        }
    }
    return "";
    }
}