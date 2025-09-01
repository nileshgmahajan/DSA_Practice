class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
         int n=classes.length;
         
         PriorityQueue<double[]> pq=new PriorityQueue<>((a,b) -> Double.compare(b[0],a[0]));
         for(int [] c:classes)
         {
            int pass=c[0];
            int total=c[1];

            pq.offer(new double[]{gain(pass,total),pass,total});
         }

         for(int i=0;i<extraStudents;i++)
         {
            double[]top=pq.poll();
            int pass=(int)top[1];
            int total=(int)top[2];
            pass++;
            total++;
            pq.offer(new double[]{gain(pass,total),pass,total});
         }

         double sum=0.0;

         while(!pq.isEmpty())
         {
            double []cur=pq.poll();
            sum +=cur[1] / cur[2];
         }
         return sum / n;
        
    }
    private double gain(int pass,int total)
    {
        return ((double) (pass + 1) / (total + 1)) - ((double) pass / total);
    }
}