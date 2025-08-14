class Solution {
    public String largestGoodInteger(String num) {
        

    for(char d ='9'; d>='0';d--)
    {
        String str=""+d+d+d;
        if(num.contains(str))
        {
            return str;
        }
    }
    return "";
    }
}