class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
    //     Stack<Integer> s=new Stack<>();
    //     int nextGrater[] = new int[nums2.length];

    //     for(int i=nums2.length-1;i>=0;i--)
    //     {
    //         while(!s.isEmpty() && s.peek() <= nums2[i])
    //         {
    //             s.pop();//remove the top element
    //         }
    //         if(s.isEmpty())
    //         {
    //             nextGrater[i]=-1;
                
    //         }else
    //         {
    //                 nextGrater[i]=s.peek();//peek the top element
    //         }
    //         s.push(nums2[i]);//push top element

    //     }


    //     int result[]= new int[nums1.length];
    //     for(int i=0;i<nums1.length;i++)
    //     {
    //         int indexnumber=findIndex(nums2,nums1[i]);
    //         result[i]=nextGrater[indexnumber];
    //     } 
    //     return result;
    // }
    //     private int findIndex(int [] nums,int target)
    //     {
    //         for(int i=0;i<nums.length;i++)
    //         {
    //             if(nums[i] == target)
    //             {
    //                 return  i;
    //             }
               
    //         }
    //         return -1;

            //-------------best approch  O(m + n)
              Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();

        for (int num : nums2) {
            while (!stack.isEmpty() && num > stack.peek()) {
                map.put(stack.pop(), num);
            }
            stack.push(num);
        }

        int[] result = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            result[i] = map.getOrDefault(nums1[i], -1);
        }

        return result;
        //----------brute force  o(n2)
        //  int[] result = new int[nums1.length];

        // for (int i = 0; i < nums1.length; i++) {
        //     int num = nums1[i];
        //     int index = -1;

        //     // Step 1: Find the index of nums1[i] in nums2
        //     for (int j = 0; j < nums2.length; j++) {
        //         if (nums2[j] == num) {
        //             index = j;
        //             break;
        //         }
        //     }

        //     // Step 2: Search to the right of found index
        //     int nextGreater = -1;
        //     for (int j = index + 1; j < nums2.length; j++) {
        //         if (nums2[j] > num) {
        //             nextGreater = nums2[j];
        //             break;
        //         }
        //     }

        //     result[i] = nextGreater;
        // }

        // return result;
        }
        
}
    
