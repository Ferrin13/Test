import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class presentPicker {
	
	public static void main (String[] args) throws IOException
	{
		String[][] results = new String[5][2];
		String[][] workWith = new String[5][2];
		String[] family = new String[]{"Dad", "Mom", "Caleb", "Hannah", "Isaac"};
		String[] list1 = new String[]{"Dad", "Mom", "Caleb", "Hannah", "Isaac"};
		String[] list2 = new String[]{"Dad", "Mom", "Caleb", "Hannah", "Isaac"};
		Random generator = new Random();
		
		for(int i = 0; i < 5; i++)
		{
			int randomNumber = i;
			while(randomNumber == i || list1[randomNumber] == null)	//Keep generating random numbers until we get one we want
			{
				randomNumber = generator.nextInt(5);
			}
			results[i][0] = list1[randomNumber];
			list1[randomNumber] = null;
		}
		
		for(int i = 0; i < 5; i++)
		{
			int randomNumber = i;
			while(randomNumber == i || list2[randomNumber] == null || list2[randomNumber].equals(results[i][0])) //Keep generating random numbers until we get one we want
			{
				randomNumber = generator.nextInt(5);
			}
			results[i][1] = list2[randomNumber];
			list2[randomNumber] = null;
		}
		
		for(int i = 0; i < 5; i ++)
		{
			for(int j = 0; j < 5; j++)
			{
				for(int k = 0; k < 2; k++)
				{
					if(results[i][0].equals(results[j][k]) && j != i)
					{
						workWith[i][0] = family[j];
					}
				}
			}
		}
		
		for(int i = 0; i < 5; i ++)
		{
			for(int j = 0; j < 5; j++)
			{
				for(int k = 0; k < 2; k++)
				{
					if(results[i][1].equals(results[j][k]) && j != i)
					{
						workWith[i][1] = family[j];
					}
				}
			}
		}
		
		/*
		for(int i = 0; i < 5; i++)
		{
			for(int j = 0; j < 2; j++)
			{
				System.out.print(results[i][j] + " ");
			}
			System.out.println("");
		}
		System.out.println("\nWorkwith's");
		for(int i = 0; i < 5; i++)
		{
			for(int j = 0; j < 2; j++)
			{
				System.out.print(workWith[i][j] + " ");
			}
			System.out.println("");
		}
		*/
		
		Scanner scan = new Scanner(System.in);
		int input = -1;
		while(input != 0)
		{
				System.out.println("Welcome to the present picker program. Please enter your number (0 to exit)\n"
					+ "1. Dad \n2. Mom \n3. Caleb \n4. Hannah \n5. Isaac");
				input = scan.nextInt();
				String person1 = results[input - 1][0];
				String person2 = results[input - 1][1];
				String workWith1 = workWith[input - 1][0];
				String workWith2 = workWith[input - 1][1];
				
				System.out.println("Your first person is " + person1 + ". You may work with " +
						workWith1 +" for getting " + person1 + "\'s gift.");
				System.out.println("Your second person is " + person2 + ". You may work with " +
						workWith2 +" for getting " + person2 + "\'s gift.");
				System.out.println("\n\nOnce you are done viewing this information, press the clear button, then press enter");
				
				System.in.read();

		}
	}	
}
