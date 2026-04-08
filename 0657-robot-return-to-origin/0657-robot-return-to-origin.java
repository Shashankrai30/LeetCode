class Solution {
    public boolean judgeCircle(String moves) {
        int x=0,y=0;
        int len=moves.length();
        for(int i=0;i<len;i++){
            char c=moves.charAt(i);
            if(c=='U'){
                x++;
            }
            else if(c=='D'){
                x--;
            }
             else if(c=='L'){
                y++;
            }
            else{
                y--;
            }
        }
        return x==0 && y==0;
    }
}