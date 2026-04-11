class Solution {
    public int minimumDistance(int[] nums) {
        HashMap<Integer, List<Integer>> map=new HashMap<>();

        for(int i=0;i<nums.length;i++){
            map.putIfAbsent(nums[i],new ArrayList<>());
            map.get(nums[i]).add(i);
        }

        int ans=Integer.MAX_VALUE;

        for(int key:map.keySet()){
            if(map.get(key).size()>=3){
                for (int i = 0; i <= map.get(key).size()- 3; i++) {
                    int a = map.get(key).get(i);
                    int b = map.get(key).get(i + 1);
                    int c = map.get(key).get(i + 2);

                    int temp = 2 * (c - a); 
                    ans = Math.min(ans, temp);
                }
            }
        }
        return (ans==Integer.MAX_VALUE)?-1:ans;
    }
}