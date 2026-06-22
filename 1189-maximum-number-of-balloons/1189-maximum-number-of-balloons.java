class Solution {
    public int maxNumberOfBalloons(String text) {
        HashMap<Character,Integer> map =new HashMap<>();

        map.put('b',0);
        map.put('a',0);
        map.put('l',0);
        map.put('o',0);
        map.put('n',0);

        for(char ch:text.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }


        int count=0;

        while(map.get('b')>0 && map.get('a')>0 && map.get('l')>1 && map.get('o')>1 && map.get('n')>0){
            count++;
            map.put('b',map.get('b')-1);
            map.put('a',map.get('a')-1);
            map.put('l',map.get('l')-2);
            map.put('o',map.get('o')-2);
            map.put('n',map.get('n')-1);
        }

        return count;
    }
}