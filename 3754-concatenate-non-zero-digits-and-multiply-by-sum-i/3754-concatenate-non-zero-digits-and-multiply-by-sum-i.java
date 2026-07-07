class Solution {
    public long sumAndMultiply(int n) {
        
        String s=String.valueOf(n);

        String str="0";
        int sum=0;

        for(char ch:s.toCharArray()){
            if(ch!='0'){
                str=str+ch;
                sum=sum+ch-'0';
            }
        }

        long ans=Integer.valueOf(str);
        ans=ans*sum;

        return ans;
    }
}