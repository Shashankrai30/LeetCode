class Solution {
    public String removeDuplicateLetters(String s) {
       HashMap<Character,Integer> map = new HashMap<>();

        for(int i=0;i<s.length();i++){
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        }

        HashSet<Character> set = new HashSet<>();

        Stack<Character> q = new Stack<>();

        for(int i=0;i<s.length();i++){
            if(q.isEmpty() || (q.peek()<s.charAt(i) && !set.contains(s.charAt(i)))){
                q.push(s.charAt(i));
                set.add(s.charAt(i));
            }
            else{
                while(!q.isEmpty() && map.get(q.peek())>0 && !set.contains(s.charAt(i)) && q.peek()>s.charAt(i)){
                    
                    set.remove(q.peek());
                    q.pop();

                }

                if(!set.contains(s.charAt(i))){
                    q.push(s.charAt(i));
                    set.add(s.charAt(i));
                }
            }

            map.put(s.charAt(i),map.get(s.charAt(i))-1);
        }

        String ans="";

        while(!q.isEmpty()){
            ans=q.pop()+ans;
        }

        return ans;  
    }
}