package annadaline;

import java.util.Random;

public class ADALINE {
		public static void main(String[] args) {
		// TODO Auto-generated method stub
		double r = 0.2;
		double counter =1,LMS =0;
		double counter2 = 100;
    double[] w  = {0,0,0};

    for(int c1=0 ; c1<w.length;c1++) {
    	
    	Random dice = new Random();
    	w[c1] = (dice).nextDouble();
    	System.out.println("w"+(c1+1)+" :"+w[c1]);
    	}


    
    

		double[][] a= {
				{1,1,-1,0,0,0},
				{1,-1,1,0,0,0},
				{-1,1,-1,0,0,0},
				{-1,-1,-1,0,0,0}
		};
		
		while(counter!=0)				
{
	   
	   for(int row=0;row<a.length;row++)
		{
	   for(int column=0;column<1;column++) 	
		{
		   //summation function
		a[row][3] =w[0] + (a[row][0]*w[1])+(a[row][1]*w[2]);
		//error function
		a[row][4] =  a[row][2]-a[row][3];
		a[row][5] = Math.pow(a[row][4], 2);
	
		
		if (a[row][4]!=0) {
			w[0] = w[0] + (r*a[row][4]);
			
			w[1] = w[1] + (r*a[row][4]*a[row][0]);
			
		
			w[2] = w[2] + (r*a[row][4]*a[row][1]);
			
		
	
			LMS +=a[row][5] ;
			

					}
	
		
		}		
		    
		}	
			
			
			
			if(counter2>LMS)
			{
				counter2 = LMS;
				counter =1;	
				LMS =0;
			}
			else {
				counter = 0;
			}
		}
		System.out.println("LMS value:" + LMS );
		System.out.println("" );
		System.out.println("Weights when lms has reached  " );
		System.out.println("------------------------------" );
		System.out.println("Weights:  W0="+w[0]+"     W1= " +w[1]+"     W2= "+w[2]);
		
	
		
		
		
		   for(int row=0;row<a.length;row++)
			{
		   for(int column=0;column<1;column++) 	
			{
			   System.out.println("Output"+(row+1)+":=  "+a[row][2]);
			   
			}}	
		
		
		
		}



}
