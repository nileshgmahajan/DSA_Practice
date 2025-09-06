class Solution {
    public int[][] merge(int[][] intervals) {

        //sort the interval using  lamda function
        Arrays.sort(intervals,(a,b) -> a[0] - b[0]);

        int index=0;

        //merge the overlaping sort
        for(int i=1;i<intervals.length;i++)
        {
            //this condtion 1st ending elment >= 2nd starting element
            if(intervals[index][1] >= intervals[i][0])
            {
                //overlap merge
                intervals[index][1]=Math.max(intervals[index][1],intervals[i][1]);
            }else
            {
                //no overlap mov the forward index 
                index ++;//
                intervals[index]=intervals[i];
            }
        }
        //copy only the merge part
        return Arrays.copyOfRange(intervals,0,index+1);
        
    }
}