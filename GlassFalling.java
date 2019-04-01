/**
 * Glass Falling
 */
public class GlassFalling {

  // Do not change the parameters!
  public int glassFallingRecur(int floors, int sheets) {
    // Fill in here and change the return
	  
	  if(floors==0|| floors==1) {
		  return floors;
	  }
	  if(sheets==1) {
		  return floors;
	  }
	  
	  	
	   int result= Integer.MAX_VALUE, temp;
	  
	  for(int i=1; i<=floors; i++) {
		   	temp = Math.max(glassFallingRecur(i-1,sheets-1), glassFallingRecur(floors-i,sheets));
		    result= Math.min(temp, result);
	  }
	  
	
	  return result+1;
	  
	 
  }

  // Optional:
  // Pick whatever parameters you want to, just make sure to return an int.
  public int glassFallingMemoized() {
    // Fill in here and change the return
    return 0;
  }

  // Do not change the parameters!
  public int glassFallingBottomUp(int floors, int sheets) {
    // Fill in here and change the return
	  int [][] minTrials= new int[sheets+1][floors+1];
	  
	  for (int row=0; row<=sheets; row++) {
		  minTrials[row][0]=0;
	  }
	  
	  for(int col=0; col<=floors; col++) {
		  minTrials[0][col]=0;
	  }
	  
	  for(int floor=1; floor<=floors; floor++) {
		  minTrials[1][floor]=floor;
	  }
	  
	  for(int sheet=1; sheet<=sheets; sheet++) {
		  minTrials[sheet][1]=1;
	  }
	 
	  for(int sheet=2; sheet<=sheets; sheet++) {
		  for(int floor=2; floor<=floors; floor++) {
			  minTrials[sheet][floor]= Integer.MAX_VALUE;
			  for(int i=1; i<=floor;i++) {
				  int temp = Math.max(minTrials[sheet-1][i-1], minTrials[sheet][floor-i])+1;
				  minTrials[sheet][floor]= Math.min(minTrials[sheet][floor],temp);
				 
			  }
			  
		  }
	  }
	  
    return minTrials[sheets][floors];
  }


  public static void main(String args[]){
      GlassFalling gf = new GlassFalling();
      
      // Do not touch the below lines of code, and make sure
      // in your final turned-in copy, these are the only things printed
      int minTrials1Recur = gf.glassFallingRecur(27, 2);
      int minTrials1Bottom = gf.glassFallingBottomUp(27, 2);
      int minTrials2Recur = gf.glassFallingRecur(100, 3);
      int minTrials2Bottom = gf.glassFallingBottomUp(100, 3);
      System.out.println(minTrials1Recur + " " + minTrials1Bottom);
      System.out.println(minTrials2Recur + " " + minTrials2Bottom);
     
      
  }
}
