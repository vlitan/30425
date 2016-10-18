package underworld.utils;

import java.io.File;
import java.util.Scanner;

public class FileReader {
	public static void printFileContents(String pathToFile){
		try{
			File inFile = new File(pathToFile);
			Scanner in = new Scanner(inFile);
			while (in.hasNextLine()){
				System.out.println(in.nextLine());
			}
			in.close();
		}
		catch(Exception e){
			System.out.println("error while opening the file at " + pathToFile);
		}
	}
}
