class Solution {
    public int[] recoverOrder(int[] order, int[] friends) {

        HashSet<Integer> set = new HashSet<>();

        for(int f:friends){
            set.add(f);
        }

        int i=0;

        for(int o:order){
            if(set.contains(o)){
                friends[i++]=o;
            }
        }
        return friends;
    }
}