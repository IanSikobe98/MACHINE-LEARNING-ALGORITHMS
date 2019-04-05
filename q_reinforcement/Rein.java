//SIKOBE IAN WALTER-P15/42815/2017
//YEAR 3 GROUP 2
//Q-REINFORCEMENT ALGORITHM IN MACHINE LEARNING FOR DATA

//importing packages
package q_reinforcement;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.List; 

public class Rein {




	public static void main(String[] args)  {
		//Goal state is the last row or column in the matrix				
		//define gamma		
		double gamma = 0.8;


		//reward matrix
		int R[][] = {
				{-1,-1,-1,-1,0,-1},
				{-1,-1,-1,0,-1,100},
				{-1,-1,-1,0,-1,-1},
				{-1,0,0,-1,0,-1}, 
				{0,-1,-1,0,-1,100},
				{-1,0,-1,-1,0,100}, 


		};
		//zero matrix
		double Q[][]=new double[R.length][R[1].length];
		for (int row=0;row<Q.length;row++) 
		{
			for(int column=0;column<Q[row].length;column++) 
			{

				Q[row][column]=0.0;

			}
		}


		//random no variable
		int ran;
		//random action variable
		int act=0;
		//int gl=5;

		//Arrays to be used in operartions
		List<Integer> list = new ArrayList<>(); 
		List<Integer> list2 = new ArrayList<>(); 
		//List<Integer> list3 = new ArrayList<>(); 
		int seta[]=new int[R.length];

		//random number generator variable
		Random dice = new Random();




		//variable for counting number of episodes
		int it=0;

		//loop for each episode 
		for(int p=0;p<30;p++) 
		{
			//initialize variable for next state
			int numitt=0;
			//Randomly chooses initial state
			ran = (dice).nextInt(R.length);	

			//loops until it reaches goal state which is the final element
			while(numitt!=(R.length-1)) 
			{
				//take next state as new state if number of iterations in episode is greater than 0
				if(it>0) {
					ran = numitt;
				}

				System.out.println("initial state: "+ran);
				//for finding next state 

				//finds all possible actions and put them in a list
				for (int row=0;row<1;row++) 
				{
					for(int column=0;column<R[row].length;column++) 
					{
						if(R[ran][column]!=-1) {
							list.add(column);
						}
					}
				}

				//randomly chooses a state from the list
				act =list.get(dice.nextInt((list.size())));

				System.out.println("Next state chosen:"+act);

				for (int row=0;row<1;row++) 
				{
					for(int column=0;column<R[row].length;column++) 
					{
						if(R[act][column]!=-1) {
							list2.add(column);
						}	
					}
				}

				//finds all the possible actions from the next state and puts them in list seta[]  
				for(int k=0;k<list2.size();k++) 
				{
					int q=list2.get(k);
					System.out.println("option"+(k+1)+" :"+q);
					seta[k] = (int) Q[act][q];
				}

				//clears up the lists for use in the next iteration    
				list2.clear(); 
				list.clear(); 

				//finds out the maximum value Q  of this next state based on all possible actions
				int maxim = seta[0];
				for(int l = 0; l <seta.length;l++)
				{
					if(seta[l] > maxim)
					{
						maxim = seta[l];
					}
				}


				//computes the Q-reinforcement formula
				Q[ran][act]= ((R[ran][act] +(gamma*maxim)));
				System.out.println("Q Value selected: "+Q[ran][act]);
				System.out.println(" ");

				//assigns next state to be used as current state 
				numitt = act;

				//counts the number of iterations
				it++;


			}


		}

		//normalizing data in Q matrix after iterations
		for (int row=0;row<Q.length;row++) 
		{
			for(int column=0;column<Q[row].length;column++) 
			{
				if(R[row][column]==-1)
					Q[row][column]=R[row][column];	

			}
			System.out.println();

		}	

		//Prints out final Q matrix
		System.out.println("FINAL Q MATRIX");
		System.out.println("--------------");
		for (int row=0;row<Q.length;row++) 
		{
			for(int column=0;column<Q[row].length;column++) 
			{

				System.out.print(Q[row][column]+"\t");	

			}
			System.out.println();

		}	


		//part for choosing path
		int nxt =0;
		int initst;

		//Prompts user to choose path
		System.out.println("");
		System.out.println("PLEASE INSERT YOUR INITIAL STATE:(BTN 1-6)");
		Scanner scan1 =new Scanner(System.in);
		initst = scan1.nextInt();
		initst--;

		//variable for number of iterations
		int it2 =0;
		//prints out chosen path
		System.out.println("");
		System.out.println("CHOSEN PATH");
		System.out.println("--------------");

		//This method basically starts from initial state,chooses its next state based on maximum value

		while(nxt!=R.length-1) {
			if(it2>0)
			{
				initst=nxt;
			}
			System.out.print((initst+1)+" -->");
			//finds next state based on maximum value
			double maimus = Q[initst][0];

			for (int row=0;row<1;row++) 
			{
				for(int column=0;column<Q[row].length;column++) 
				{
					if(Q[initst][column]>maimus)

					{
						maimus=Q[initst][column];
						nxt=column;

					}

				}
				//adds up iterations	    					
				it2++;
			}

		}
		System.out.print(nxt+1);
		scan1.close();
	}

}	
