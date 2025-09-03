class Solution {
    static class PlaceWick
    {
        int []tree;
        int n;

        PlaceWick(int n)
        {
            this.n=n;
            tree=new int[n + 1];
            // Arrays.fill(tree,Integer.MIN_VALUE);
        }
        void updated(int i,int val)
        {
            while(i<=n)
            {
                // tree[i]=Math.max(tree[i],val);
                tree[i] +=val;
                i +=i & -i;
            }
        }
        int query(int i)
        {
            // int res=Integer.MIN_VALUE;
            int res=0;
            while(i > 0)
            {
                // res=Math.max(res,tree[i]);
                res +=tree[i];
                i -=i & -i;
            }
            return res;
        }
        int rangeSum(int l,int r)
        {
            if(l > r)return 0;
            return query(r) - query(l - 1);
        }
    }
    public int numberOfPairs(int[][] points) {
        int n=points.length;

        Arrays.sort(points,(a,b)->
        {
            if(a[0]==b[0])return b[1] - a[1];
            return a[0]- b[0];
        });

        int[] ys=new int[n];
        for(int i=0;i<n;i++) ys[i]=points[i][1];
        int [] sorteYs=ys.clone();

        Arrays.sort(sorteYs);

        Map<Integer,Integer> comp=new HashMap<>();
        int idx=1;

        for(int val:sorteYs)
        {
            if(!comp.containsKey(val)) comp.put(val,idx++);
        }  
        for(int i=0;i<n;i++)
        {
            points[i][1]=comp.get(points[i][1]);
        }  
        int count=0;
        // PlaceWick bit=new PlaceWick(n);

        for(int i=0;i<n - 1;i++)
        {
            PlaceWick bit=new PlaceWick(n);

            for(int j=i + 1;j<n;j++)
            {
                int yi=points[i][1],yj=points[j][1];
            
            if(yi >= yj)
            {
                int blockker=bit.rangeSum(yj,yi);
                if(blockker == 0)
                {
                    count ++;
                }
            }
            bit.updated(points[j][1],1);
            }
        }
        return count;
    }
}