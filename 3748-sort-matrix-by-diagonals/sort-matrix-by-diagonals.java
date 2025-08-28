class Solution {
    public int[][] sortMatrix(int[][] grid) {
        int n=grid.length;
        Map<Integer,List<Integer>> m=new HashMap<>();

        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                int key=i - j;
                m.computeIfAbsent(key, k-> new ArrayList<>()).add(grid[i][j]);
            }
        }
        for(int key : m.keySet())
        {
            List<Integer> diag=m.get(key);

            if(key >= 0)
            {
                diag.sort((a,b) ->b -a);
            }else
            {
                Collections.sort(diag);
            }
        }
        Map<Integer,Integer> index=new HashMap<>();
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                int key=i - j;
                int idx=index.getOrDefault(key,0);
                grid[i][j]=m.get(key).get(idx);
                index.put(key,idx + 1);
            }
        }
        return grid;
        
    }
}