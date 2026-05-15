class Solution {
    public boolean isGood(int[] nums) {
        int n=nums.length;
        int max=0;

        HashMap<Integer,Integer> map=new HashMap<>();

        for(int num:nums){
            max=Math.max(num,max);
            map.put(num,map.getOrDefault(num,0)+1);
        }

        for(int num:nums){
            if(map.get(num)>1 && num!=max) return false; 
        }

        return (n==max+1 && map.get(max)==2);
    }
}