
// -----------------------------------------------------
// Assignment #3 COMP 249 Section S
// Part: 1
// Written by:  Anne Ehresmann - 27858906, and Seth Cole - 27795580
// -----------------------------------------------------
public class DuplicateISBNException extends Exception {
	
	/**
	 * 
	 */


	public DuplicateISBNException(){
		super("That ISBN already exists!");
	}
	
	public DuplicateISBNException(String msg){
		super(msg);
	}
	
	public String getMessage(){
		return super.getMessage();
		}
	

}
