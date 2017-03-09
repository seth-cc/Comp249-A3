
// -----------------------------------------------------
// Assignment #3 COMP 249 Section S
// Part: 1
// Written by:  Anne Ehresmann - 27858906, and Seth Cole - 27795580
// -----------------------------------------------------
import java.util.Scanner;
import java.io.File;
public class Driver {

	public static void main(String[] args) {
		Scanner key = new Scanner(System.in);
	

		
		
		
		System.out.print("Please enter the output file name: ");
		String fOutName = key.next();
		File fileOut = new File(fOutName);

		while (fileOut.exists()){
			System.out.println("That file already exists!");
			System.out.println("The file "+ fOutName + " has a size of " + fileOut.length() + " bytes." );
			System.out.print("Please enter a new file name: ");
			fileOut = null;
			fileOut = new File(key.next());
			
		}
		
		BookInventory1 test = new BookInventory1();
		
		
		test.fixInventory("Initial_Book_Info.txt", fileOut.getName());
		
		System.out.println("Content of first file:");
		System.out.println(test.displayFileContents("Initial_Book_Info.txt"));
		
		System.out.println("\n\nContent of new file:");
		System.out.println(test.displayFileContents(fileOut.getName()));
	key.close();
	}

}
