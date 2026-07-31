class Solution {
    public int minimumPushes(String word) {
        
        HashMap<Character,Integer> map = new HashMap<>();

        for(int i=0;i<word.length();i++){
            
            map.put(word.charAt(i),map.getOrDefault(word.charAt(i),0)+1);            

        }

        List<Map.Entry<Character,Integer>> list = new ArrayList<>(map.entrySet());


        Collections.sort(list,(a,b)->b.getValue()-a.getValue());

        int count=0;
        int ans=0;

        for(Map.Entry<Character,Integer> lis:list){

            ans+=lis.getValue()*(count/8+1);
            count++;
        }

        return ans;
    }
}