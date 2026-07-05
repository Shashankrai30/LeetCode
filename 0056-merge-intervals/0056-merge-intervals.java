class Solution {
    public int[][] merge(int[][] intervals) {

        List<List<Integer>> ans = new ArrayList<>();

        for (int[] interval : intervals) {
            ans.add(Arrays.asList(interval[0], interval[1]));
        }

        Collections.sort(ans,((a,b)-> a.get(0)-b.get(0)));   

        int j=0;     

        while(j<ans.size()-1){

            if(ans.get(j).get(1)>=ans.get(j+1).get(0)){
                if(ans.get(j).get(1)<=ans.get(j+1).get(1)){
                    ans.get(j).set(1,ans.get(j+1).get(1));
                    ans.remove(ans.get(j+1));
                }
                else{
                    ans.remove(ans.get(j+1));
                }
            }
            else{
                j++;
            }
        }

        int answer[][] = new int[ans.size()][2];

        for(int i=0;i<ans.size();i++){
            answer[i][0]=ans.get(i).get(0);
            answer[i][1]=ans.get(i).get(1);
        }

        return answer;
    }
}