
// -----------------------------------------------------
// Assignment #3 COMP 249 Section S
// Part: 1
// Written by:  Anne Ehresmann - 27858906, and Seth Cole - 27795580
// -----------------------------------------------------

import java.io.PrintWriter;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;




public class BookInventory1 {

	private static Book bkArr[];
	private Scanner read = null;
	private Scanner key = new Scanner(System.in);
	
	private PrintWriter pw = null;
	
	public BookInventory1(){
		bkArr = null;
	}

	
	public void fixInventory(String fIn, String fOut){

		
		try{
			System.out.print("Attempting to open " + fIn+"...\n");
			read = new Scanner(new FileInputStream(fIn));
		}
		catch(FileNotFoundException e){
			System.out.println("Could not find the specified file!");
		}
		System.out.println("Detecting number of entries in " + fIn +"...\n");
		int numBooks = getNumBooks(fIn);
		System.out.println("The inventory currently has " + numBooks + " books.");
		if(numBooks > 1){
			System.out.println("Importing...");	
			bkArr = new Book[numBooks];
			
			for(int i = 0; i < bkArr.length; i++){
				bkArr[i] = new Book(read.nextLine());
			}
			System.out.println("Checking for duplicate ISBNs...");
			int dupe = scanISBN();
			while(dupe != -1){
				System.out.println("Entry #" + (dupe+1) + " has a duplicate ISBN. Please enter a new ISBN: ");
				long newISBN = key.nextLong();
	
				while(compareISBN(newISBN)){
						try{
							if(compareISBN(newISBN)) throw new DuplicateISBNException();
							
						}
					catch(DuplicateISBNException e){
						System.out.println("Please enter another ISBN: ");
						newISBN = key.nextLong();
							}

						}
						
					System.out.println("New ISBN is OK. Changing value...");
					bkArr[dupe].setIsbn(newISBN);
				System.out.println("Scanning for more duplicate ISBNs...");
			dupe = scanISBN();
			}
			System.out.println("All duplicate ISBNs have been changed! Attempting to write to file...");
			
			try{
			pw = new PrintWriter(new FileOutputStream(fOut));
			}
			
			catch(FileNotFoundException e){
				System.out.println("Something went wrong opening the file! Terminating...");
				System.exit(0);
			}
			
			for(int i = 0; i <bkArr.length; i++){
				pw.println(bkArr[i]);
			}
			
			System.out.println("Writing complete! Closing files...");
			pw.close();
			read.close();
		}
		else{
			System.out.println("No books need to be fixed! Closing files...");
			read.close();
		}


	}


	//Reads file and displays contents
	public String displayFileContents(String fIn){
	
		
		String ret ="";
		try{
			read = new Scanner(new FileInputStream(fIn));
		}
		catch(FileNotFoundException e){
			System.out.print("Couldn't find the specified file! Terminating...");
			System.exit(0);
		}
		int numBooks = getNumBooks(fIn);
		for(int i = 0; i < numBooks; i++){
			ret += (read.nextLine() + "\n");
		}
		read.close();
		return ret;
			}
	
	
	//Private method checking number of lines in the file.
	private int getNumBooks(String fIn){
		int lines = 0;
		try{
			BufferedReader reader = new BufferedReader(new FileReader(fIn));
			while (reader.readLine() != null) lines++;
			reader.close();
		}
		catch(FileNotFoundException e){
			System.out.print("Could not find the specified file. Terminating...");
			System.exit(0);
		}
		catch(IOException e){
			System.out.println(e);
		}

		return lines;

	}
	//To be used by fixInventory. Returns the array entry which needs to be changed. Returns -1 if there are no duplicate ISBNs.
	private int scanISBN(){
		int i = 0;
		long isbnCheck;
		boolean dupeFound = false;
		outerloop:
		for(int j = 0; j < bkArr.length; j++){
			isbnCheck = bkArr[j].getIsbn();	

			for(i=0; i < bkArr.length; i++){
				if(i != j){
					if(isbnCheck == bkArr[i].getIsbn()){
						dupeFound = true;
						break outerloop;
					}
				}
			}
		}
		if(dupeFound){
			return i;
		}
		else{
			return -1;
		}

	}
	
	//Compares a new isbn to the existing ISBNs
	private boolean compareISBN(long newISBN){
		boolean check = false;
		for(int i = 0; i<bkArr.length; i++){
			if(newISBN == bkArr[i].getIsbn()){
				check = true;
				break;
			}
			}
		return check;
	}
}
