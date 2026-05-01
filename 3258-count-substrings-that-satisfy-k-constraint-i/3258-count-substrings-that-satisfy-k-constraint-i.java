class Solution {
    public int countKConstraintSubstrings(String s, int k) {
       int i=0;
       int j=0;
       int count=0;

       HashMap<Character,Integer> map=new HashMap<>();
       map.put('0',0);
       map.put('1',0);

       while(j<s.length()){
        map.put(s.charAt(j),map.getOrDefault(s.charAt(j),0)+1);

        while(map.get('0')>k && map.get('1')>k){
            map.put(s.charAt(i),map.get(s.charAt(i))-1);
            i++;
        }
        count=count+j-i+1;
        j++;
       } 

       return count;
    }
}