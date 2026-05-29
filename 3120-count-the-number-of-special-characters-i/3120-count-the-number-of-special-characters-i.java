class Solution {
    public int numberOfSpecialChars(String word) {

        HashSet<Character> Set= new HashSet<>();

        int count=0;

        for(int i=0;i<word.length();i++){

            char ch=word.charAt(i);

            

            if(ch>='a' && ch<='z'){

                char temp=(char)(ch-'a'+'A');
                if(Set.contains(temp) && !Set.contains(ch)){
                    count++;
                }
            }
            else{

                 char temp=(char)(ch-'A'+'a');
                 if(Set.contains(temp) && !Set.contains(ch)){
                    count++;
                }
            }

            Set.add(ch);
        }
        return count;
    }
}