class Solution {
    public int hammingWeight(int n) {
        
        String temp="";

        while(n>1){
            String ch = n%2+"";
            temp=ch+temp;
            n=n/2;
        }
        temp=(n+"")+temp;

        int count=0;

        for(int i=0;i<temp.length();i++){
            if(temp.charAt(i)=='1'){
                count++;
            }
        }

        return count;
    }
}