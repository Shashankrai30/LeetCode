class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()) return false;

        HashMap<Character,Integer> map = new HashMap<>();

        for(int i=0;i<s.length();i++){
            char s1=s.charAt(i);
            char t1=t.charAt(i);

            map.put(s1,map.getOrDefault(s1,0)+1);
            map.put(t1,map.getOrDefault(t1,0)-1);

            if(map.get(s1)==0){
                map.remove(s1);
            }
            if(map.containsKey(t1) && map.get(t1)==0){
                map.remove(t1);
            }
        }

        return (map.size()==0);
    }
}