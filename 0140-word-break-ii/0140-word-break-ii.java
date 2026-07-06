class Solution {
    List<String> ans = new ArrayList<>();
    public List<String> wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>();

        for(int i=0;i<wordDict.size();i++){
            set.add(wordDict.get(i));
        }
        helper(0,s,"",set);
        return ans;
    }

    void helper(int i,String s,String temp,HashSet<String> set){
        if(i==s.length()){
            ans.add(temp);
            return;
        }

        for(int ind=i;ind<s.length();ind++){
            String t=s.substring(i,ind+1);
            if(set.contains(t)){
                if (temp.isEmpty()) {
                    helper(ind + 1, s, t, set);
                }
                else {
                    helper(ind + 1, s, temp + " " + t, set);
                }
            }
        }
    }
}