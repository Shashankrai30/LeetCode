class Solution {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        Arrays.sort(players);
        Arrays.sort(trainers);

        int i=0;
        int j=0;
        int c=0;

        while(i<players.length && j<trainers.length){
            if(trainers[j]>=players[i]){
                i++;
                j++;
                c++;
            }
            else{
                j++;
            }
        }

        return c;
    }
}