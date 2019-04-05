//SIKOBE IAN WALTER-P15/42815/2017
//YEAR 3 GROUP 2
//KMEANS ALGORITHM IN MACHINE LEARNING FOR DATA
package kmeanscluster2;

import java.util.Scanner;

public class KMEANS {

	public static void main(String[] args) {
		//since K =2 ,2 centroid1= (c1x,c1y)  , centroid2=  (c2x,c2y)
		int c1x,c1y,c2x,c2y;
		int counterc1=0,counterc2=0;


		int n,counter=0;
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);

		int[][] dataset = new int[5][5];
		int[] G = new int[5];
		//Query to get data
		System.out.println("Please enter dataset to know to which group it belongs"); 

		//insert data
		System.out.println("Please enter Weight(X)"); 
		dataset[0][0] = scan.nextInt();
		System.out.println("Please enter pH(Y)"); 
		dataset[0][1] = scan.nextInt();

		//Dataset used 
		dataset[1][0] = 1;
		dataset[1][1] = 1;
		dataset[2][0] = 2;
		dataset[2][1] = 1;
		dataset[3][0] = 4;
		dataset[3][1] = 3;
		dataset[4][0] = 5;
		dataset[4][1] = 4;





		//define initial value centroids
		c1x =dataset[0][0];
		c1y =dataset[0][1];
		c2x =dataset[1][0];
		c2y =dataset[1][1];

		//Calculating euclidian distance to get distance matrix	
		for (int row=0;row<dataset.length;row++) 
		{
			for(int column=0;column<dataset[row].length;column++) 
			{

				dataset[row][2] = (int) (Math.pow((c1x-dataset[row][0]), 2) + Math.pow((c1y-dataset[row][1]), 2));	
				dataset[row][3] = (int) (Math.pow((c2x-dataset[row][0]), 2) + Math.pow((c2y-dataset[row][1]), 2));

			}	


		}		

		//Finding group matrix		 
		for (int row=0;row<dataset.length;row++) 
		{
			for(int column=0;column<dataset[row].length;column++) 
			{
				if(dataset[row][2]< dataset[row][3])
				{
					dataset[row][2] = 1	;
					dataset[row][3] = 0;
					dataset[row][4]= 1; 
				}

				else if(dataset[row][2] > dataset[row][3])
				{
					dataset[row][2] = 0;
					dataset[row][3] = 1;
					dataset[row][4]=  2; 
				}

			}	


		}			




		//iterative section		 
		while(counter==0)//Stops looping if there is no change in group matrix
		{

			for (int row=0;row<dataset.length;row++) 
			{
				for(int column=0;column<dataset[row].length;column++) 
				{
					dataset[row][4] = G[row];
				}
			}

			//finding centroids
			for (int row=0;row<dataset.length;row++) 
			{
				for(int column=0;column<dataset[row].length;column++) 
				{
					//Find data in group 1 
					if(dataset[row][2] ==1)
					{
						c1x +=dataset[row][0];
						c1y +=dataset[row][1];
						++counterc1;

					}

					else if(dataset[row][2] ==0)
					{
						//Find data in group 1 
						c2x +=dataset[row][0];
						c2y +=dataset[row][1];
						++counterc2;

					}

				}
			}

			//Calculate value of x and y coordinates in all centroids
			c1x=c1x/counterc1;
			c1y =c1y/counterc1;
			c2x =c2x/counterc2;
			c2y =c2y/counterc2;


			//Calculating euclidian distance to get distance matrix	

			for (int row=0;row<dataset.length;row++) 
			{
				for(int column=0;column<dataset[row].length;column++) 
				{

					dataset[row][2] = (int) (Math.pow((c1x-dataset[row][0]), 2) + Math.pow((c1y-dataset[row][1]), 2));	
					dataset[row][3] = (int) (Math.pow((c2x-dataset[row][0]), 2) + Math.pow((c2y-dataset[row][1]), 2));
				}	
			}	


			//Finding group matrix
			for (int row=0;row<dataset.length;row++) 
			{
				for(int column=0;column<dataset[row].length;column++) 
				{
					if(dataset[row][2]< dataset[row][3])
					{
						dataset[row][2] = 1	;
						dataset[row][3] = 0;
						dataset[row][4]= 1; 
					}

					else if(dataset[row][2] > dataset[row][3])
					{
						dataset[row][2] = 0;
						dataset[row][3] = 1;
						dataset[row][4]=  2; 
					}

				} 	
			}	

			//Check if there is change in  group matrix(if there is no change in group matrix-->counter ==0 -stop!!)
			for (int row=0;row<dataset.length;row++) 
			{
				for(int column=0;column<dataset[row].length;column++) 
				{			 

					if(dataset[row][4]!=G[row]) 
					{

						++counter;
					}	 
				}
			}

		}

		//print results of clustering
		System.out.println("The results of the datasets in the group are:");
		for (int row=1;row<dataset.length;row++) 
		{
			for(int column=0;column<1;column++) 
			{			 

				System.out.println(dataset[row][0] +" "+ dataset[row][1] + "  is of group   " + dataset[row][4]);
			}

		}	
		System.out.println("Your query answer is:");
		System.out.println(dataset[0][0] +" "+ dataset[0][1] + "  is of group   " + dataset[0][4]);	 
	}

}
