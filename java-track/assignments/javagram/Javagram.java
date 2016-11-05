package javagram;

import javagram.filters.*;
import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class Javagram {

	public static void main(String[] args) {

		// Create the base path for images		
		String[] baseParts = {System.getProperty("user.dir"), "images"};
		String dir = String.join(File.separator, baseParts);
		String relPath = null;
		Picture picture = null;
		Scanner in = new Scanner(System.in);
		String imagePath = "path not set";
		
		// prompt user for image to filter and validate input
		do {
					
			// try to open the file
			try {
				
				System.out.println("Image path (relative to " + dir + "):");
				relPath = in.next();
				
				imagePath = dir + File.separator + relPath;
				
				picture = new Picture(imagePath);
				
			} 
			catch (RuntimeException e) {
				System.out.println("Could not open image: " + imagePath);
			}
			
		} while(picture == null);
		
		// TODO - prompt user for filter and validate input
		int filterChoice = displayFilterMenu(in);
		
		// TODO - pass filter ID int to getFilter, and get an instance of Filter back 
		Filter filter = null;
		try{
			filter = getFilter(filterChoice);
		}
		catch(Exception e){
			System.err.println("getFilter threw an exception: " + e.getMessage());
		}

		// filter and display image
		Picture processed = filter.process(picture);
		processed.show();
		
		System.out.println("Image successfully filtered");
		
		// save image, if desired
		System.out.println("Would you like to save the image? y/n");
		String selection = in.next();
		while(selection.equals("y") != true && selection.equals("n") != true){
			System.out.println("Invalid choice, please enter y or n");
			selection = in.next();
		}
		if(selection.equals("n")){
			System.out.println("Image not saved");
		}
		else if(selection.equals("y")){
			System.out.println("Save image to (relative to " + dir + ")");
			System.out.println("New Filename?");
			String fileName = in.next();
			if(fileName.equals(relPath)){
				System.out.println("Filename is the same as the original. Overwrite? y/n");
				String overwrite = in.next();
				while(selection.equals("y") != true && selection.equals("n") != true){
					System.out.println("Invalid choice, please enter y or n");
					overwrite = in.next();
				}
				if(overwrite.equals("y")){
					save(dir, fileName, processed);
				}
				else{
					System.out.println("Image not saved");
				}			
			}
			else{
				save(dir, fileName, processed);
			}
		}
		// close input scanner
		in.close();
	}
	
	private static int displayFilterMenu(Scanner in){
		System.out.println("Which filter would you like to use?");
		System.out.println("1. Blue Filter");
		System.out.println("2. Invert Filter");
		System.out.println("3. Grayscale Filter");
		int choice = in.nextInt();
		while(choice < 1 || choice > 3){
			System.out.println("Invalid choice, please choose from the list");
			choice = in.nextInt();
		}
		return choice;
	}
	
	private static void save(String dir, String fileName, Picture processed){
		String absFileName = dir + File.separator + fileName;
		processed.save(absFileName);
		System.out.println("Image saved to " + absFileName);
	}
	
	private static Filter getFilter(int choice) {
		// TODO - use a switch statement
		if(choice < 1 || choice > 3){
			throw new IllegalArgumentException();
		}
		else if(choice == 1){
			return new BlueFilter();
		}
		else if(choice == 2){
			return new InvertFilter();
		}
		else{
			return new GrayscaleFilter();
		}
	}

}