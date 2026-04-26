class Solution {
    public List<Integer> findValidElements(int[] nums) {

        List<Integer> ans=new ArrayList<>();

        for(int i=0;i<nums.length;i++){
            if(i==0 || i==nums.length-1){
                ans.add(nums[i]);
            }

            else{
                int leftmax=0;
                for(int j=0;j<=i;j++){
                    if(nums[j]>nums[leftmax]){
                        leftmax=j;
                    }
                }

                if(leftmax==i){
                    ans.add(nums[i]);
                }

                int rightmax=nums.length-1;
                for(int j=nums.length-1;j>=i;j--){
                    if(nums[j]>nums[rightmax]){
                        rightmax=j;
                    }
                }

                if(rightmax==i && leftmax!=i){
                    ans.add(nums[i]);
                }
            }
        }

        return ans;
           
    }
}