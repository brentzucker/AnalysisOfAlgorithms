import java.io.*;

public class Utility {

	public static int[] getArrayFromFile(String filename) {
		
		String input = readFromFile(filename);

		int[] int_arr = stringToIntArray(input);

        return int_arr;
	}

	public static String readFromFile(String filename) {
		String input = "";
		try {
            FileReader fileReader = new FileReader(filename);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line = null;
            while((line = bufferedReader.readLine()) != null) {
                input += line;
            }   

            bufferedReader.close();         
        }
        catch(FileNotFoundException ex) {
            System.out.println("Unable to open file '" + filename + "'");                
        }
        catch(IOException ex) {
            System.out.println("Error reading file '" + filename + "'");                  
        }
        return input.trim();
	}

	public static int[] stringToIntArray(String input) {
		String[] str_arr = input.split(" ");
        int[] int_arr = new int[str_arr.length];

        for (int i = 0; i < int_arr.length; i++) {
        	if (!str_arr[i].equals("")) {
        		try {
        		int_arr[i] = Integer.parseInt(str_arr[i]);
	        	}
	        	catch (NumberFormatException nfe) {
	        		System.out.println(str_arr[i] + " is not a number.");
	        	}
        	}
        }
        return int_arr;
	}
}