class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        String ans="";

        for(int i=0;i<words.length;i++){
            int sum=0;
            for(char ch:words[i].toCharArray()){
                sum=sum+weights[ch-'a'];
            }

            int temp=sum%26;
            char t=(char)('z'-temp);
            ans=ans+t;
        }

        return ans;
    }
}