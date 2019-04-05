//SIKOBE IAN WALTER-P15/42815/2017
//YEAR 3 GROUP 2
//ANN PERCEPTRON ALGORITHM IN MACHINE LEARNING FOR DATA
package annperceptron;
import java.util.Random;


public class ANNPERCEPTRON {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Initialize variables i.e threshold,learning rate
		double t = 0.5,r = 0.1;
		int counter =1,b=1;
		//Initialize weight matrix
		double[] w = {0,0,0,0};

		//Randomize Weights
		for(int c1=0 ; c1<w.length;c1++) {

			Random dice = new Random();
			w[c1] = (dice).nextDouble();
			System.out.println("w"+(c1+1)+" :"+w[c1]);
		}

		//Enter dataset 
		double[][] a= {
				{b,0,0,1,0,0,0,0,0,0},
				{b,0,1,1,0,0,0,0,0,0},
				{b,1,0,1,0,0,0,0,0,0},
				{b,1,1,0,0,0,0,0,0,0},

		};
		//Print initial input and output
		System.out.println("Input is: ");
		for(int row=0;row<a.length;row++)


		{
			for(int column=0;column<1;column++) {

				System.out.println("sensor " +(row+1) +" input values = " +a[row][0] + "  "+a[row][1]+ "  " + a[row][2] + "  "+a[row][3]);
			}


		}
		System.out.println(" ");
		//Print expected output
		System.out.println("expected output is: ");
		for(int row=0;row<a.length;row++)

		{
			for(int column=0;column<1;column++) {

				System.out.println("sensor " +(row+1) +" expected output = " +a[row][3] );

			}


		}


		//Iterate until full epoch has no error i.e error!=0
		while(counter!=0) {
			//Intialize counter for epoch
			counter =0;
			for(int row=0;row<a.length;row++)
			{
				for(int column=0;column<1;column++) {
					//summation function
					a[row][4] = (a[row][0]*w[0])+(a[row][1]*w[1])+(a[row][2]*w[2]);
					//activation function(Check if value is greater than or less than threshold)
					if(a[row][4]>t)
					{
						//If greater allocate value 1 as output
						a[row][5]=1;
					}
					else {
						//If lesser allocate value 0 as output
						a[row][5]=0;
					}

					//Find error of inputs in epoch
					a[row][6]= a[row][3]-a[row][5];

					//Find change in weights 
					a[row][7]= a[row][6]*a[row][0]*r;
					a[row][8]= a[row][6]*a[row][1]*r;
					a[row][9]= a[row][6]*a[row][2]*r;

					//Adjust Weights
					w[0]= a[row][7] +w[0];
					w[1]= a[row][8] +w[1];
					w[2]= a[row][9] +w[2];

				}	
			}
			//Count number of inputs in data which have error
			for(int row=0;row<a.length;row++)
			{
				for(int column=0;column<a[row].length;column++) {
					if(a[row][6]!=0)
						counter++;
				}
			}


		}

		//Print System output for each sensor
		System.out.println(" ");
		System.out.println("System Output is:");
		for(int row=0;row<a.length;row++)


		{
			for(int column=0;column<1;column++) {

				System.out.println("sensor " +(row+1) +"  = " +a[row][5]);
			}


		}

		//Print outputs when error is 0 for whole epoch
		System.out.println("Weights:  W0="+w[0]+"     W1= " +w[1]+"     W2= "+w[2]);
	}

}
