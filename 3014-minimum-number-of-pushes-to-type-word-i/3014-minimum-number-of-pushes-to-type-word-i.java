class Solution {
    public int minimumPushes(String word) {

        HashMap<Character,Integer> map = new HashMap<>();
        int count=0;

        for(int i=0;i<word.length();i++){
            
            if(!map.containsKey(word.charAt(i))){
                map.put(word.charAt(i),map.size()/8+1);
            }

            count+=map.get(word.charAt(i));
        }       

        return count;
    }
}