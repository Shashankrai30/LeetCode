class Solution {
    public boolean isPalindrome(String s) {

        StringBuilder str = new StringBuilder();

        for(int i=0;i<s.length();i++){

            if((s.charAt(i)>='a' && s.charAt(i)<='z') || (s.charAt(i)>='A' && s.charAt(i)<='Z') || (s.charAt(i)>='0' && s.charAt(i)<='9')){
                str.append(Character.toLowerCase(s.charAt(i)));
            }
        }

        return palindrome(str.toString());
    }

    boolean palindrome(String S){

        int i=0;
        int j=S.length()-1;

        while(i<j){
            if(S.charAt(i)==S.charAt(j)){
                i++;
                j--;
            }
            else{
                return false;
            }
        }

        return true;
    }
}