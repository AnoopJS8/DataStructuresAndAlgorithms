package arrays;

/*The cost of a stock on each day is given in an array, find the max profit that you can make by buying and 
 * selling in those days. For example, if the given array is {100, 180, 260, 310, 40, 535, 695},
 *  the maximum profit can earned by buying on day 0, selling on day 3. Again buy on day 4 and sell on day 6.
 *  If the given array of prices is sorted in decreasing order, then profit cannot be earned at all.
 *  */

class Interval {
	private int buy;
	private int sell;

	public Interval() {
		this.buy = -1;
		this.sell = -1;
	}

	public int getBuy() {
		return buy;
	}

	public void setBuy(int buy) {
		this.buy = buy;
	}

	public int getSell() {
		return sell;
	}

	public void setSell(int sell) {
		this.sell = sell;
	}

}

//This function finds the buy sell schedule for maximum profit
public class StockBuySell {
	
	public static void stockBuySell(int[] price,int n){
		if(n==1)
			return;//Prices must be given for atleast two days.
		int count=0;//count of solution pairs.
		
		Interval[] sol=new Interval[n/2+1];//because we are finding pairs.
		
		for(int i=0;i<(n/2+1);i++){
			sol[i]=new Interval();
		}
		
		int i=0;
		while(i<n-1)
		{
			// Find Local Minima. Note that the limit is (n-2) as we are
	        // comparing present element to the next element. 
			while((i<n-1) && price[i+1]<=price[i]){
				i++;
			}
			// If we reached the end, break as no further solution possible
			if(i==n-1)
				break;
			//System.out.println(i);
			// Store the index of minima and increment the index by 1.
			//System.out.println(sol[count].getBuy());
			//System.out.println(i);
			sol[count].setBuy(i);
			++i;
			// Find Local Maxima.  Note that the limit is (n-1) as we are
	        // comparing to previous element
			while((i<n) && price[i]>=price[i-1]){
				i++;
			}
			
			//store the index of the maxima
			sol[count].setSell(i-1);
						
			//increment the buy/sell pair
			count++;
		}
		//print solution
		if (count==0)
			System.out.println("No Solution Found");
		else{
			for(int c=0;c<count;c++)
			{
				System.out.printf("Buy on day : %d\t and sell on day : %d\n",sol[c].getBuy(),sol[c].getSell());
			}
		}
	}
	
	public static void main(String[] args) {
		
		int price[] = {100, 180, 260, 310, 40, 535, 695};
		int len=price.length;
		stockBuySell(price, len);
		
	}
}
