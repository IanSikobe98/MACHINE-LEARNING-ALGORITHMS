//SIKOBE IAN WALTER-P15/42815/2017
//YEAR 3 GROUP 2
//BACK-PROPAGATION ALGORITHM IN MACHINE LEARNING FOR DATA
package backpropagation;

import java.util.Random;

public class BP {

	public static void main(String[] args) {

		//training sets
		double[][] a= {
				{0.4,-0.7,0.1},
				{0.3,-0.5,0.05},
				{0.6,0.1,0.3},
				{0.2,0.4,0.25},
				{0.1,-0.2,0.12}


		};


		Random dice = new Random();
		//Initialize weights to output layer
		double[][] w= {
				{0},
				{0}
		};
		//Randomize weights to output layer
		for (int row=0;row<w.length;row++) 
		{
			for(int column=0;column<1;column++) 
			{ 
				w[row][column]= (dice).nextDouble();
			}
		}

		//Initialize weights to hidden layer
		double[][] v= {
				{0,0},
				{0,0}
		};	

		//Randomize weights to hidden layer
		for (int row=0;row<v.length;row++) 
		{
			for(int column=0;column<v.length;column++) 
			{ 
				v[row][column]= (dice).nextDouble();
			}
		}


		//Initialize arrays to use in programs   
		double[][] IH =new double[2][1];
		double[][] O1 = new double[2][1];
		double e [][]= new double[2][1];
		double da[][] = new double[2][1];
		double v1[][]=new double[2][2];
		double fo[][] =new double[a.length][1];


		//Initialize learning rate
		double r =0.6;
		//initialize values to use in variables
		double d=0.0;
		double erra =1.0;
		double n = 0.0;


		//Stop when error rate is less than 0.001   
		while(erra>0.001) {	
			//initalize erra and error2 value 
			erra=0.0; 
			double error2 =0.0;


			double w1[][] =new double[2][1];
			//for all the data in the epoch
			for (int row=0;row<a.length;row++) 
			{
				for(int column=0;column<1;column++) 
				{         
					double error =0.0;
					//Find output of hidden layer  
					O1[0][0]=a[row][0];
					O1[1][0]=a[row][1];
					//Find transpose of vector v
					double[][]vt=trans(v);
					//Calculate input to hidden layer matrix
					IH[0][0]= (vt[0][0]*O1[0][0])+(vt[0][1]*O1[1][0]);
					IH[1][0]= (vt[1][0]*O1[0][0])+(vt[1][1]*O1[1][0]);

					//Calculate output of hidden layer matrix using sigmoid function
					IH[0][0]= 1/(1+(Math.exp(-IH[0][0])));
					IH[1][0]= 1/(1+(Math.exp(-IH[1][0])));

					//Find transpose of vector w
					double[][]wt=trans(w);
					//calculate input of output layer
					double  OH = (wt[0][0]*IH[0][0])+(wt[0][1]*IH[1][0]);
					//Calculate output of output layer
					OH =1/(1+(Math.exp(-OH)));
					//Put value of output of output layer in array fo
					fo[row][0]=OH;
					//calculate error of data i in epoch
					error = Math.pow((a[row][2]-OH),2);
					//calculate error squared of data i in epoch
					error2 +=error;

					//Full step for adjusting weights to output layer

					//Find d
					d =(a[row][2]-OH)*OH*(1-OH);

					//Find change in weights
					w1[0][0]=r*d*IH[0][0];
					w1[1][0]=r*d*IH[1][0];

					//Adjust weights of weights to output layer 
					w1[0][0]= w1[0][0] +w[0][0];
					w1[1][0]=w1[1][0]+  w[1][0];


					//Full step for adjusting weights to hidden layer

					//find e
					e[0][0]=  w[0][0]*d;
					e[1][0]=  w[1][0]*d;

					//find d which is da
					da[0][0]= (e[0][0]*IH[0][0]*(1-IH[0][0]));
					da[1][0]= (e[1][0]*IH[1][0]*(1-IH[1][0]));

					//Find transpose of dat
					double dat[][] = trans(da);
					double x1[][]=new double[2][2];


					//Find x1
					x1[0][0]=a[row][0]*dat[0][0];
					x1[0][1]=a[row][0]*dat[0][1];
					x1[1][0]=a[row][1]*dat[0][0];
					x1[1][1]=a[row][1]*dat[0][1];


					//find change in weight
					v1[0][0] = x1[0][0]*r;
					v1[0][1] = x1[0][1]*r;
					v1[1][0] = x1[1][0]*r;
					v1[1][1] = x1[1][1]*r;

					//Adjust weights to hidden layer
					v[0][0]=v[0][0]+v1[0][0];
					v[0][1]=v[0][1]+v1[0][1];
					v[1][0]=v[1][0]+v1[1][0];
					v[1][1]=v[1][1]+v1[1][1];

					//put weight values in weight vector
					w[0][0]= w1[0][0];
					w[1][0]=w1[1][0];


				}
			}
			//Calculate size of epoch
			n=a.length;
			//Calculate error rate
			erra =(1/n)*error2;


		}

		// Print final system output with error allowed
		for (int row=0;row<fo.length;row++) 
		{
			for(int column=0;column<1;column++) 
			{

				System.out.println("Final system for data " + (row+1)+" output is = "+fo[row][0]);
			}
		}


	}
    //Function for finding transpose
	public static double [][] trans(double [][]matrix)
	{
		// Transpose the matrix
		double[][] transpose = new double[matrix[0].length][ matrix.length];
		for(int i = 0; i < matrix.length; i++) {
			for (int j = 0; j <  matrix[i].length; j++) {
				transpose[j][i] = matrix[i][j];
			}
		}


		return transpose;
	}
}