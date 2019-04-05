//SIKOBE IAN WALTER-P15/42815/2017
//YEAR 3 GROUP 2
//BAYES ALGORITHM IN MACHINE LEARNING FOR DATA
package bayes;

import java.util.Scanner;

public class BAYES {
	public static void main(String[] args) {
		//initialize variables	
		int Pyes =0;
		int Pno =0;
		//dataset
		String[][] a= {
				{"Sunny","Hot","High","Weak","No"},
				{"Sunny","Hot","High","Strong","No"},
				{"Overcast","Hot","High","Weak","Yes"},
				{"Rain","Mild","High","Weak","Yes"}, 
				{"Rain","Cool","Normal","Weak","Yes"},
				{"Rain","Cool","Normal","Strong","No"},
				{"Overcast","Cool","Normal","Strong","Yes"},
				{"Sunny","Mild","High","Weak","No"},
				{"Sunny","Cool","Normal","Weak","Yes"},
				{"Rain","Mild","Normal","Weak","Yes"},
				{"Sunny","Mild","Normal","Strong","Yes"},
				{"Overcast","Mild","High","Strong","Yes"},
				{"Overcast","Hot","Normal","Weak","Yes"},
				{"Rain","Mild","High","Strong","No"},
		};
		double [][] I = new double[5][2];//final array for probabilities of instance
		double [][] OA;//outlook table
		double [][] TA;//temperature table
		double [][] HA;//humidity table
		double [][] WA;//wind table
		double fyes=0,fno=0;

		//Function for modifying each of the tables
		OA= overcast(a);
		TA=temperature(a);
		HA=humidity(a);
		WA=wind(a);


		//counts number of yes and no
		for (int row=0;row<a.length;row++) 
		{
			for(int column=0;column<1;column++) 
			{
				if(a[row][4]=="Yes")
					++Pyes;
				else if(a[row][4]=="No")
					++Pno;
			}
		}	
		//prompt user for input
		System.out.println("Please enter instance to know if you will play");
		@SuppressWarnings("resource")


		Scanner scan1 = new Scanner(System.in);
		System.out.println("Outlook(Sunny=1,Overcast=2,Rain=3):");
		int out = scan1.nextInt();
		System.out.println("Temperature(Hot=1,Mild=2,Cool=3):");
		int temp = scan1.nextInt();
		System.out.println("Humidity(High=1,Normal=2):");
		int hum = scan1.nextInt();
		System.out.println("Wind(Strong=1,weak=2):");
		int win = scan1.nextInt();
		//if statements to fill out table I
		{
			if(out ==1)	
			{
				I[0][0] = OA[0][0];
				I[0][1] = OA[0][1];

			}

			else if(out == 2)	
			{
				I[0][0] = OA[1][0];
				I[0][1] = OA[1][1];

			}
			else if(out == 3)	
			{
				I[0][0] = OA[2][0];
				I[0][1] = OA[2][1];
			}

		}
		{if(temp ==1)	
		{
			I[1][0] = TA[0][0];
			I[1][1] = TA[0][1];

		}

		else if(temp ==2)	
		{
			I[1][0] = TA[1][0];
			I[1][1] = TA[1][1];

		}
		else if(temp == 3)	
		{
			I[1][0] = TA[2][0];
			I[1][1] = TA[2][1];
		}

		}


		{if(hum ==1)	
		{
			I[2][0] = HA[0][0];
			I[2][1] = HA[0][1];

		}

		else if(hum ==2)	
		{
			I[2][0] = HA[1][0];
			I[2][1] = HA[1][1];

		}

		}

		{if(win ==1)	
		{
			I[3][0] = WA[0][0];
			I[3][1] = WA[0][1];

		}

		else if(win ==2)	
		{
			I[3][0] = WA[1][0];
			I[3][1] = WA[1][1];

		}

		}








		double Tot = Pyes+Pno;
		//find D/H
		I[4][0]=Pyes/Tot;
		I[4][1]=Pno/Tot;
        //Prompt user to choose btn ML and MAP	
		System.out.println("Please select method for classifying instance:");
		System.out.println("------------------------------------------------");
		System.out.println("1.MAP");
		System.out.println("2.Maximum Likelihood");

		int sel = scan1.nextInt();
		if(sel==1) {



			//Use of MAP Function to find label   
			fyes =I[0][0]*I[1][0]*I[2][0]*I[3][0]*I[4][0];
			fno =I[0][1]*I[1][1]*I[2][1]*I[3][1]*I[4][1];
		}


		//Use of Maximum Likelihood Function to find label
		else if(sel==2) {
			fyes =I[0][0]*I[1][0]*I[2][0]*I[3][0];
			fno =I[0][1]*I[1][1]*I[2][1]*I[3][1];	

		}
		String result ;
		result = (fyes>fno)? "Yes":"No";
		System.out.println("Will he play Tennis? "+result);
	}
	//function to fill overcast table
	public static double [][] overcast(String [][]i)
	{
		double [][] OA = new double[3][2];
		double Syes=0,Sno=0;
		double Oyes=0,Ono =0;
		double Ryes=0,Rno =0;
		double Yt  =0;
		double Nt= 0;
		for (int row=0;row<i.length;row++) 
		{
			for(int column=0;column<1;column++) 
			{
				if(i[row][0] == "Sunny"&&i[row][4]=="Yes" ) 
				{
					++Syes;
				}	

				else if(i[row][0] == "Sunny"&&i[row][4]=="No" ) 
				{
					++Sno;
				}
				else if(i[row][0] == "Overcast"&&i[row][4]=="Yes" ) 
				{
					++Oyes;
				}
				else if(i[row][0] == "Overcast"&&i[row][4]=="No" ) 
				{
					++Ono;
				}
				else if(i[row][0] == "Rain"&&i[row][4]=="Yes" ) 
				{
					++Ryes;
				}
				else if(i[row][0] == "Rain"&&i[row][4]=="No" ) 
				{
					++Rno;
				}	
			}


		}
		Yt = Syes+Oyes+Ryes;
		Nt = Sno+Ono+Rno;
		OA[0][0] = Syes/Yt;
		OA[0][1] = Sno/Nt;
		OA[1][0] = Oyes/Yt;
		OA[1][1] = Ono/Nt;
		OA[2][0] = Ryes/Yt;
		OA[2][1] = Rno/Nt;
		return  OA;


	}
	//function to fill temperature table
	public static double [][] temperature(String [][]i)
	{
		double [][] TA = new double[3][2];
		double Syes=0,Sno=0;
		double Oyes=0,Ono =0;
		double Ryes=0,Rno =0;
		double Yt  =0;
		double Nt= 0;
		for (int row=0;row<i.length;row++) 
		{
			for(int column=0;column<1;column++) 
			{
				if(i[row][1] == "Hot"&&i[row][4]=="Yes" ) 
				{
					++Syes;
				}	

				else if(i[row][1] == "Hot"&&i[row][4]=="No" ) 
				{
					++Sno;
				}
				else if(i[row][1] == "Mild"&&i[row][4]=="Yes" ) 
				{
					++Oyes;
				}
				else if(i[row][1] == "Mild"&&i[row][4]=="No" ) 
				{
					++Ono;
				}
				else if(i[row][1] == "Cool"&&i[row][4]=="Yes" ) 
				{
					++Ryes;
				}
				else if(i[row][1] == "Cool"&&i[row][4]=="No" ) 
				{
					++Rno;
				}	
			}	
		}
		Yt = Syes+Oyes+Ryes;
		Nt = Sno+Ono+Rno;
		TA[0][0] = Syes/Yt;
		TA[0][1] = Sno/Nt;
		TA[1][0] = Oyes/Yt;
		TA[1][1] = Ono/Nt;
		TA[2][0] = Ryes/Yt;
		TA[2][1] = Rno/Nt;
		return  TA;	
	}
	//function to fill humidity table
	public static double [][] humidity(String [][]i)
	{

		double [][] HA = new double[3][2];
		double Syes=0,Sno=0;
		double Oyes=0,Ono =0;
		double Ryes=0,Rno =0;
		double Yt  =0;
		double Nt= 0;
		for (int row=0;row<i.length;row++) 
		{
			for(int column=0;column<1;column++) 
			{
				if(i[row][2] == "High"&&i[row][4]=="Yes" ) 
				{
					++Syes;
				}	

				else if(i[row][2] == "High"&&i[row][4]=="No" ) 
				{
					++Sno;
				}
				else if(i[row][2] == "Normal"&&i[row][4]=="Yes" ) 
				{
					++Oyes;
				}
				else if(i[row][2] == "Normal"&&i[row][4]=="No" ) 
				{
					++Ono;
				}

			}
		}
		Yt = Syes+Oyes+Ryes;
		Nt = Sno+Ono+Rno;
		HA[0][0] = Syes/Yt;
		HA[0][1] = Sno/Nt;
		HA[1][0] = Oyes/Yt;
		HA[1][1] = Ono/Nt;
		HA[2][0] = Ryes/Yt;
		HA[2][1] = Rno/Nt;
		return  HA;
	}
	//function to fill wind table
	public static double [][] wind(String [][]i)
	{
		double [][] WA = new double[3][2];
		double Syes=0,Sno=0;
		double Oyes=0,Ono =0;
		double Ryes=0,Rno =0;
		double Yt  =0;
		double Nt= 0;
		for (int row=0;row<i.length;row++) 
		{
			for(int column=0;column<1;column++) 
			{
				if(i[row][3] == "Strong"&&i[row][4]=="Yes" ) 
				{
					++Syes;
				}	

				else if(i[row][3] == "Strong"&&i[row][4]=="No" ) 
				{
					++Sno;
				}
				else if(i[row][3] == "Weak"&&i[row][4]=="Yes" ) 
				{
					++Oyes;
				}
				else if(i[row][3] == "Weak"&&i[row][4]=="No" ) 
				{
					++Ono;
				}

			}
		}
		Yt = Syes+Oyes+Ryes;
		Nt = Sno+Ono+Rno;
		WA[0][0] = Syes/Yt;
		WA[0][1] = Sno/Nt;
		WA[1][0] = Oyes/Yt;
		WA[1][1] = Ono/Nt;
		WA[2][0] = Ryes/Yt;
		WA[2][1] = Rno/Nt;
		return  WA;	

	}
}