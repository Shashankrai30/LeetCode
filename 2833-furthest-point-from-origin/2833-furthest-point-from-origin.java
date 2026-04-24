class Solution {
    public int furthestDistanceFromOrigin(String moves) {
      int lcount=0;
      int rcount=0;
      for(int i=0;i<moves.length();i++){
       if(moves.charAt(i)=='L'){
            lcount++;
        }
        else if(moves.charAt(i)=='R'){
            rcount++;
        }
      }
      int count=0;
      for(int i=0;i<moves.length();i++){
        if(moves.charAt(i)=='L'){
            count--;
        }
        else if(moves.charAt(i)=='_'){
            if(lcount>rcount){
                count--;
            }
            else{
                count++;
            }
        }
        else{
            count++;
        }
      } 
      return Math.abs(count); 
    }
}