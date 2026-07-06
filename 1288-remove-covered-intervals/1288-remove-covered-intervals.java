class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        List<List<Integer>> ans = new ArrayList<>();

        for (int[] interval : intervals) {
            ans.add(Arrays.asList(interval[0], interval[1]));
        }  

        int i=0;
        while(i<ans.size()){
            boolean checked=false;
            int j=0;
            while(j<ans.size()){
                if(i==j){
                    j++;
                    continue;
                }

                if(ans.get(i).get(0)>=ans.get(j).get(0) && ans.get(i).get(1)<=ans.get(j).get(1)){
                    ans.remove(ans.get(i));
                    checked=true;
                    break;
                }
                
                else{
                    j++;
                }
            }
            if(!checked){
                i++;
            }
        }
        return ans.size();
    }
}