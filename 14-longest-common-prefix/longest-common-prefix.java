class Solution {
    public String longestCommonPrefix(String[] strs) {

        String prefix=strs[0];//inital prifix first word assign

        for(int i=1;i<strs.length;i++)//for loop start with secode word
        {
            while(!strs[i].startsWith(prefix))
            {
                prefix=prefix.substring(0,prefix.length() - 1);
            }
        }
        return prefix;

        /**
        Here is the dry run step-by-step for your code using the input:

["flower", "flow", "flight"]

\U0001f50e Initial State
prefix = "flower"


We will compare this with each next string.

✅ Iteration 1: Compare with "flow"
Check: does "flow".startsWith("flower")?

❌ No

So reduce prefix one character at a time:

"flow".startsWith("flowe") → ❌

prefix = "flowe"


"flow".startsWith("flow") → ✔

prefix = "flow"


Now prefix matched.
Move to next string.

✅ Iteration 2: Compare with "flight"
Check: does "flight".startsWith("flow")?

❌ No

Reduce prefix:

"flight".startsWith("flo") → ❌

prefix = "flo"


"flight".startsWith("fl") → ✔

prefix = "fl"


Now prefix matched.

\U0001f389 Final prefix = "fl"

This is returned by the function.

✔ Final Output
"fl"
        
        
         */
        
    }
}