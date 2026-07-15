class Solution {
    public boolean divideArray(int[] nums) {

       HashMap<Integer,Integer> map = new HashMap<>();

       for(int n:nums){
        map.put(n,map.getOrDefault(n,0)+1);
       } 

       for(int key:map.keySet()){
        if(map.get(key)%2!=0){
            return false;
        }
       }

       return true;
    }
}