import java.io.*;
import java.util.*;

public class GradeCalculator {
	
	public static void main(String[] args) {
		
		Boolean validFile = false;
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the name of the text file containing your grades");
		
		//Loop and ask user to enter a valid file name until they have done so
		while (!validFile) {
			String filename = scanner.nextLine();
			
			//Adds a file extension to the end of the filename if the user has not supplied one
			if (filename.length()>3 && filename.substring(filename.length() - 4) == ".txt") {
				
			}
			else {
				filename = filename + ".txt";
			}			
		
			try {
				BufferedReader reader = new BufferedReader(new FileReader(filename));
				List<String> grades = new ArrayList<>();
				String line;
				
				//Each line of the text file is added as an element to the list
			    while ((line = reader.readLine()) != null) {
			      grades.add(line);
			    }
			    
			    validFile = true;
				scanner.close();
			    reader.close();  
			   
			    List<List<String>> gradesAsList = new ArrayList<>();
			    double credits = 0.0;
			    double average = 0.0;
			 
			    System.out.println("\nUnit Information:\n");
			    
			    for (int i=0; i<grades.size(); i++) {
			    	
			    	//Split each line of the text file
			    	String str[] = grades.get(i).split(",");
			    	List<String> splitLine = new ArrayList<String>();
			    	splitLine = Arrays.asList(str);
			    	gradesAsList.add(splitLine);
			    	
			    	//Print out unit information
			    	System.out.printf("%-14s %-4s %-4s\n", gradesAsList.get(i).get(0), gradesAsList.get(i).get(1), gradesAsList.get(i).get(2));
			    	
			    	//
			    	average += Double.parseDouble(gradesAsList.get(i).get(1)) * Double.parseDouble(gradesAsList.get(i).get(2));
			    	credits += Double.parseDouble(gradesAsList.get(i).get(1));
			    }
			    
			    System.out.printf("\nCredits taken: %.0f", credits);
			    System.out.printf("\nAverage: %.2f\n", average/credits);
			    
			}
			
			catch(Exception e) {
				System.out.println("That file does not exist, try again");
			}
			
		}
		
	}

}
