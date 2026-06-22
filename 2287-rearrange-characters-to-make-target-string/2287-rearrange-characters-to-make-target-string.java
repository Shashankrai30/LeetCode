class Solution {
    public int rearrangeCharacters(String s, String target) {
       HashMap<Character,Integer> map =new HashMap<>();

        for(Character ch:target.toCharArray()){
            map.put(ch,0);
        }

        for(char ch:s.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }


        int count=0;

        boolean ans=true;

        while(ans){
            for(Character ch:target.toCharArray()){
                if(map.get(ch)==0){
                    ans=false;
                }
                else{
                    map.put(ch,map.get(ch)-1);
                }
            }
            if(ans){
                count++;
            }
        }

        return count; 
    }
}