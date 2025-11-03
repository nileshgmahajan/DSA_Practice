class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        //create set that store the element in both array
        Set<Integer> intersetionElement=new HashSet<>();
        int i=0,j=0;
            
        while(i < nums1.length && j < nums2.length)
        {
            //add the same element in set 
            if(nums1[i] == nums2[j])
            {
                intersetionElement.add(nums1[i]);
                i++;
                j++;
            }//otherwise incremant the pointer of the samllest intger
            else if(nums1[i] < nums2[j])
            {
                i++;
            }else
            {
                j++;
            }

        }
        //conver the intesection to array
        int m=intersetionElement.size();
        int [] result=new int[m];
        int curr=0;
        for(int num:intersetionElement)
        {
            result[curr++]=num;//add element result set and incrment the array index;
        }
        return result;
    }
}