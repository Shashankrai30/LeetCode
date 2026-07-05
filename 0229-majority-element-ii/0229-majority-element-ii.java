class Solution {
    public List<Integer> majorityElement(int[] nums) {
        HashMap<Integer,Integer> map =new HashMap<>();

        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }

        List<Integer> ans = new ArrayList<>();
        int n=nums.length;

        for(int key:map.keySet()){
            int val=map.get(key);

            if(val>n/3){
               ans.add(key);
            }
        }

        return ans;
    }
}