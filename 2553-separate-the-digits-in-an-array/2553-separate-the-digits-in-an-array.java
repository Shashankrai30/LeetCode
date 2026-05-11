class Solution {
    public int[] separateDigits(int[] nums) {

        ArrayList<Integer> arr=new ArrayList<>();

        for(int i=0;i<nums.length;i++){
            String str=nums[i]+"";

            for(int j=0;j<str.length();j++){
                arr.add((str.charAt(j)-'0'));
            }
        }

        int ans[]=new int[arr.size()];

        for(int i=0;i<arr.size();i++){
            ans[i]=arr.get(i);
        }
        return ans;
    }
}