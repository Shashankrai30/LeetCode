// class Solution {
//     public List<Integer> findValidElements(int[] nums) {

//         List<Integer> ans=new ArrayList<>();

//         for(int i=0;i<nums.length;i++){
//             if(i==0 || i==nums.length-1){
//                 ans.add(nums[i]);
//             }

//             else{
//                 int leftmax=0;
//                 for(int j=0;j<=i;j++){
//                     if(nums[j]>nums[leftmax]){
//                         leftmax=j;
//                     }
//                 }

//                 if(leftmax==i){
//                     ans.add(nums[i]);
//                 }

//                 int rightmax=nums.length-1;
//                 for(int j=nums.length-1;j>=i;j--){
//                     if(nums[j]>nums[rightmax]){
//                         rightmax=j;
//                     }
//                 }

//                 if(rightmax==i && leftmax!=i){
//                     ans.add(nums[i]);
//                 }
//             }
//         }

//         return ans;
           
//     }
// }

class Solution {
    public List<Integer> findValidElements(int[] nums) {
        int n=nums.length;
        List<Integer> ans=new ArrayList<>();
        if(n==1){
            ans.add(nums[0]);
            return ans;
        }
        int[] leftmax=new int[n];
        int[] rightmax=new int[n];
        leftmax[0]=Integer.MIN_VALUE;
        for(int i=1;i<n;i++){
            leftmax[i]=Math.max(leftmax[i-1],nums[i-1]);
        }
        rightmax[0]=Integer.MIN_VALUE;
        for(int i=n-2;i>=0;i--){
            rightmax[i]=Math.max(rightmax[i+1],nums[i+1]);
        }
        for(int i=0;i<n;i++){
            if(i==0||i==n-1||nums[i]>leftmax[i]||nums[i]>rightmax[i]){
                ans.add(nums[i]);
            }
        }
        return ans;
    }
}