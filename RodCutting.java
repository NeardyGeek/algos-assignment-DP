/**
 * Rod cutting problem described in Chapter 15 of textbook
   Author: Gen. Li
 */
public class RodCutting {

  // Do not change the parameters!
  public int rodCuttingRecur(int rodLength, int[] lengthPrices) {
	  int [] r = new int[rodLength+1];
	  for(int i=0; i<rodLength+1; i++) {
		  r[i]= Integer.MIN_VALUE;
	  }
	  
	  
	  
    return rodCuttingMemo(rodLength, lengthPrices, r);
  }
  
  public int rodCuttingMemo(int rodLength, int[] lengthPrices, int[] r) {
	  	
	  	
	 if(r[rodLength]>=0) {
		 return r[rodLength];
	 }
	  
	  int ans=0;
	  if(rodLength==0) {
		   ans = 0;
	  }else {
		   ans= Integer.MIN_VALUE;
		   
		  
	  }
	  
	  for(int i=0; i<rodLength; i++) {
		  ans= Math.max(ans, lengthPrices[i]+rodCuttingMemo(rodLength-i-1, lengthPrices, r));
		 r[rodLength]=ans;
	  }
	 
	  
	  return ans;
  }

  // Do not change the parameters!
  public int rodCuttingBottomUp(int rodLength, int[] lengthPrices) {
	  int [] r = new int[rodLength+1];
	  r[0]=0;
	  
	  for(int length=1; length<rodLength+1; length++) {
		  int ans= Integer.MIN_VALUE;
		  for(int i=0; i<length; i++) {
			  ans= Math.max(ans, lengthPrices[i]+r[length-i-1]);
			 
		  }
		  r[length]=ans;
	  }
	  
	  
	  return r[rodLength];
  }


  public static void main(String args[]){
      RodCutting rc = new RodCutting();

      // In your turned in copy, do not touch the below lines of code.
      // Make sure below is your only output.
      int length1 = 7;
      int[] prices1 = {1, 4, 7, 3, 19, 5, 12};
      int length2 = 14;
      int[] prices2 = {2, 5, 1, 6, 11, 15, 17, 12, 13, 9, 10, 22, 18, 26};
      int maxSell1Recur = rc.rodCuttingRecur(length1, prices1);
     int maxSell1Bottom = rc.rodCuttingBottomUp(length1, prices1);
      int maxSell2Recur = rc.rodCuttingRecur(length2, prices2);
      int maxSell2Bottom = rc.rodCuttingBottomUp(length2, prices2);
     System.out.println(maxSell1Recur + " " + maxSell1Bottom);
     System.out.println(maxSell2Recur + " " + maxSell2Bottom);
      
  }
}
