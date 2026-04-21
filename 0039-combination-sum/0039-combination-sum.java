class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer>temp=new ArrayList<>();
        helper(candidates,target,0,0,temp,ans);
        return ans;
    }
    public static void helper(int[] candidates,int target,int sum,int index,List<Integer>temp, List<List<Integer>> ans){
        if(sum==target){
            ans.add(new ArrayList<>(temp));
            return;
        }
        if(sum>target)return;
        for(int i=index;i<candidates.length;i++){
            temp.add(candidates[i]);
            sum=sum+candidates[i];
            helper(candidates,target,sum,i,temp,ans);
            temp.remove(temp.size()-1);
            sum=sum-candidates[i];
        }
    }
}