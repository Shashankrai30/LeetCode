class Solution {
    public int maximumLengthSubstring(String s) {

        HashMap<Character,Integer> map = new HashMap<>();

        int i=0;
        int j=0;

        int max=0;

        while(j<s.length()){
            map.put(s.charAt(j),map.getOrDefault(s.charAt(j),0)+1);
            int temp=1;
            for(Character key:map.keySet()){
                temp=Math.max(temp,map.get(key));
            }

            if(temp<=2){
                max=Math.max(max,j-i+1);
            }
            else{
                if(map.get(s.charAt(i))<=2){
                    map.put(s.charAt(i),map.get(s.charAt(i))-1);

                    if(map.get(s.charAt(i))==0){
                        map.remove(s.charAt(i));
                    }
                    i++;
                } 
                while(map.get(s.charAt(i))>2){
                    map.put(s.charAt(i),map.get(s.charAt(i))-1);

                    if(map.get(s.charAt(i))==0){
                        map.remove(s.charAt(i));
                    }
                    i++;
                }
            }
            j++;
        }
        return max;
    }
}