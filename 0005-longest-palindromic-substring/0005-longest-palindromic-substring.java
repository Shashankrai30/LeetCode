class Solution {
    public String longestPalindrome(String s) {
        String ans="";

        for(int i=0;i<s.length();i++){

            String temp=expand(s,i,i);

            if(temp.length()>ans.length()){
                ans=temp;
            }

            temp=expand(s,i,i+1);

            if(temp.length()>ans.length()){
                ans=temp;
            }

        }

        return ans;
    }

    String expand(String s,int i,int j){

        while(i>=0 && j<s.length() && s.charAt(i)==s.charAt(j)){
            i--;
            j++;
        }

        return s.substring(i+1,j);
    }
}