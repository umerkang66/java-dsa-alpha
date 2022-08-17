package arrays;

public class BuyAndSellStocks {
  public static void main(String[] args) {
    int[] nums = { 7, 1, 5, 3, 6, 4 };
    System.out.println(buyAndSellStocks(nums));
  }

  private static int buyAndSellStocks(int[] nums) {
    int buyPrice = Integer.MAX_VALUE;
    int maxProfit = 0;

    for (int i = 0; i < nums.length; i++) {
      // current price can be potentially selling price
      if (buyPrice < nums[i]) {
        // if buyPrice is less than selling price, it means we can be in profit
        int currentProfit = nums[i] - buyPrice;
        // check if this profit is maximum we can have, if it is update it
        maxProfit = Math.max(maxProfit, currentProfit);
      } else {
        // if buying price is high selling is price is low it means it is best for
        // buying, we can update it for buying
        buyPrice = nums[i];
      }
    }

    return maxProfit;
  }
}
