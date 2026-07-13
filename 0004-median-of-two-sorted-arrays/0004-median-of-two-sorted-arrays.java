class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        
        int temp[] = new int[nums1.length+nums2.length];

        int i=0;
        int j=0;
        int k=0;

        while(i<nums1.length && j<nums2.length){
            if(nums1[i]<nums2[j]){
                temp[k]=nums1[i];
                k++;
                i++;
            }
            else{
                temp[k]=nums2[j];
                k++;
                j++;
            }
        }

        while(i<nums1.length){
            temp[k]=nums1[i];
            k++;
            i++;
        }

        while(j<nums2.length){
            temp[k]=nums2[j];
            k++;
            j++;
        }

        if(temp.length%2==0){
            double ans=(temp[temp.length/2]+temp[temp.length/2-1])/2.0;
            return ans;
        }

        return temp[(temp.length-1)/2];
    }
}