class Solution {
    public int closestTarget(String[] words, String target, int startIndex) {
        int n=words.length;
        if (words[startIndex].equals(target)) return 0;

        int l=(startIndex-1+n)%n;
        int r=(startIndex+1)%n;

        int steps=1;

        while(steps<=n){
            if(words[l].equals(target)){
                return steps;
            }
            if(words[r].equals(target)){
                return steps;
            }

            l=(l-1+n)%n;
            r=(r+1)%n;
            steps++;
        }

        return -1;
    }
}