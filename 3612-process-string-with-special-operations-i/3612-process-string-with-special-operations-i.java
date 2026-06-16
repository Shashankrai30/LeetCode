class Solution {
    public String processStr(String s) {

        StringBuilder str=new StringBuilder();

        for(char ch:s.toCharArray()){
            if(ch=='*'){
                if(str.length()>0){
                    str.deleteCharAt(str.length()-1);
                }
            }
            else if(ch=='#'){
                str.append(str);
            }
            else if(ch=='%'){
                str.reverse();
            }
            else{
                str.append(ch);
            }
        }

        return str.toString();
    }
}