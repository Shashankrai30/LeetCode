class Solution {
    public char findKthBit(int n, int k) {
        
        String binary= "0";

        int ind=1;

        while(ind++<=n){

            StringBuilder str = new StringBuilder();

            for(int i=0;i<binary.length();i++){
                if(binary.charAt(i)=='0'){
                    str.append('1');
                }
                else{
                    str.append('0');
                }
            }
            
            binary+="1"+str.reverse().toString();

        }

        return binary.charAt(k-1);
    }
}