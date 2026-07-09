class Solution {
    public boolean validPalindrome(String s) {
        return helper(0,s.length()-1,0,s);
    }

    boolean helper(int i,int j,int count,String s){
        if(count==2) return false;

        if(i>=j) return true;

        if(s.charAt(i)==s.charAt(j)){
            return helper(i+1,j-1,count,s);
        }

        return helper(i+1,j,count+1,s) || helper(i,j-1,count+1,s);

    }
}