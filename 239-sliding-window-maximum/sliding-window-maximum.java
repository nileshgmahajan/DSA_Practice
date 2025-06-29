class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {

        if(nums == null || k<=0)
        {
            return new int[0];
        }

        int n=nums.length;
        int [] result=new int[n - k + 1];
        Deque<Integer> deque=new ArrayDeque<>();//store the indices 
        for(int i=0;i<n;i++)
        {
            //remove the indices that are out of the current window
                while(!deque.isEmpty() && deque.peek()<i - k + 1)
                {
                    deque.poll();
                }
                while(!deque.isEmpty() && nums[deque.peekLast()]<nums[i])
                {
                    deque.pollLast();
                }
                deque.offer(i);//add current index

                //start adding max elements to result when first window complete
                if(i>= k -1)
                {
                    result[i - k + 1]=nums[deque.peek()];
                }
        }
        return result;
}
}