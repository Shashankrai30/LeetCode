class Solution {
    public int maximumLengthSubstring(String s) {
        HashMap<Character,Integer> map = new HashMap<>();

        int len=0;

        int i=0;
        int j=0;

        while(j<s.length() && i<=j){
            map.put(s.charAt(j),map.getOrDefault(s.charAt(j),0)+1);

            
            while(map.get(s.charAt(j))>2){
                map.put(s.charAt(i),map.get(s.charAt(i))-1);
                i++;
            }

            len=Math.max(len,j-i+1);

            j++;
        }

        len=Math.max(len,j-i);

        return len;
    }
}