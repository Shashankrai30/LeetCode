class Solution {
    HashSet<List<Integer>> set = new HashSet<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        sub(nums,new ArrayList<>(),0);
        ArrayList<List<Integer>> arr = new ArrayList<>();
        
        for(List<Integer> list : set){
            arr.add(list);
        }
        return arr;
    }
    public void sub(int nums[],ArrayList<Integer> temp,int i){
        if(i==nums.length){
            set.add(new ArrayList<>(temp));
            return;
        }
        int t=nums[i];
        sub(nums,temp,i+1);
        temp.add(t);
        sub(nums,temp,i+1);
        temp.remove(temp.size()-1);
    }
}