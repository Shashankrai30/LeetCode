class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        int max=0;

        HashMap<Character,Integer> map = new HashMap<>();

        int start=0;
        for(int i=0;i<s.length();i++){
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
            while(map.get(s.charAt(i))>1){
                map.put(s.charAt(start),map.get(s.charAt(start))-1);
                start++;
            }
            max=Math.max(max,i-start+1);
        }

        return max;
    }
}