class Solution {
    public String smallestPalindrome(String s) {

       if(s.length()%2==0){

         String temp = helper(0,s.length()/2-1,s);
         StringBuilder str = new StringBuilder(temp);
         return temp+str.reverse().toString();

       } 
       else{

        String temp =helper(0,s.length()/2-1,s);
        StringBuilder str = new StringBuilder(temp);
        temp=temp+s.charAt(s.length()/2);
        return temp+str.reverse().toString();
       }

    }

    String helper(int i,int j,String s){
        ArrayList<Character> arr = new ArrayList<>();

        for(int ind=i;ind<=j;ind++){
            arr.add(s.charAt(ind));
        }

        Collections.sort(arr);

        String t="";

        for(int ind=0;ind<arr.size();ind++){
            t=t+arr.get(ind);
        }

        return t;
    }
}