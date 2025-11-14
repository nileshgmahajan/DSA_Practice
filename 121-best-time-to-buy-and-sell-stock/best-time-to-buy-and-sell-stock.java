class Solution {
    public int maxProfit(int[] prices) {
        //brute force approch o(n2); profit = sellPrice - buyPrice
        /** int max=0;
        for(int i=0;i<prices.length;i++)
        {
            for(int j=i + 1;j<prices.length;j++)
            {
                if(prices[j] > prices[i])
                {
                     max=Math.max(max,prices[j] - prices[i]);
                }
            }
        }
        return max;**/

        int minprice=prices[0];
        int maxprofit=0;
        //Using one pass + track minimum price.

        for(int price:prices)
        {
            if(price < minprice)
            {
                minprice=price;
            }else
            {
              maxprofit=Math.max(maxprofit,price - minprice);
            }
        }
        return maxprofit;
        
    }
    
}