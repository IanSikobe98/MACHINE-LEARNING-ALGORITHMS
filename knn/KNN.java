//SIKOBE IAN WALTER-P15/42815/2017
//YEAR 3 GROUP 2
//KNN ALGORITHM IN MACHINE LEARNING FOR DATA

package knn;

//Import packages 
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
public class KNN {
	static int[][] dataset = new int[4][4];
	public static void main(String[] args) {

		//initialize variables
		int good=0,bad=0;
		int K =3;
		int[] a = new int[2];

		//Bad=0,Good=1

		//data1
		dataset[0][0] =7;
		dataset[0][1] =7;
		dataset[0][2] =0;

		//data2
		dataset[1][0] =7;
		dataset[1][1] =4;
		dataset[1][2] =0;

		//data3
		dataset[2][0] =3;
		dataset[2][1] =4;
		dataset[2][2] =1;

		//data4
		dataset[3][0] =1;
		dataset[3][1] =4;
		dataset[3][2] =1;

		//Enter query to get attributes
		System.out.println("WRITE YOUR TOILET PAPER ATTRIBUTES:");
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		System.out.println("(SCALE OF 1 - 10)");
		System.out.println();
		System.out.println("ACID DURABILITY-SECONDS(X1)" +  " :");
		a[0]= scan.nextInt();
		System.out.println("STRENGHTH- KG/SQM(X2)" + " :");
		a[1]= scan.nextInt(); 

		//Calculate distance and place in column 3 of data
		for (int row=0;row<dataset.length;row++) 
		{
			for(int column=0;column<dataset[row].length;column++) 
			{

				dataset[row][3] = (int) (Math.pow((a[0]-dataset[row][0]), 2) + Math.pow((a[1]-dataset[row][1]), 2));	


			}	


		}	
		//sort array based on index 3 which is the label
		Arrays.sort(dataset, new Comparator<int[]>() {
			@Override
			//arguments to this method represent the arrays to be sorted   
			public int compare(int[] o1, int[] o2) {
				//get the item ids which are at index 3 of the array
				Integer itemIdOne = o1[3];
				Integer itemIdTwo = o2[3];
				// sort on item id
				return itemIdOne.compareTo(itemIdTwo);
			}
		});


		//since sorted array length = size of cluster K
		//Then the below process is for voting
		for (int row=0;row<K;row++) 
		{
			for(int column=0;column<dataset[row].length;column++) 
			{
				//if element label is good add 1 to no of votes of good
				if(dataset[row][2]==1){
					++good;
				}
				//if element label is bad add 1 to no of votes of bad
				else if(dataset[row][2]==0){

					++bad;
				}


			}	


		}	

		System.out.println();

		//Print out tissue status
		System.out.print("TISSUE PAPER STATUS:");
		//Prints out  status that is majority after voting
		System.out.println(good>bad?"Good":"Bad");

	}

}
