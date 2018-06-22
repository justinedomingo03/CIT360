package JSON;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class MyJSON {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		System.out.print("Enter Name: ");
		String name = input.nextLine();

		// Create a JSON object with a name-name value
		JSONObject root = new JSONObject();
		root.put("name", name);
		
		// Declare array, then add to loop
		JSONArray courses = new JSONArray();
		
		while (true) {
			
			// Ask user for course name/s
			System.out.print("Enter course name:\nIf no other course/s, leave it blank, and hit enter. ");
			String course = input.nextLine();
			
			// Break loop if user leaves course field blank and hits enter
			if (course.length() == 0) {
				break;
			}
			
			// Ask user for grade in each course
			System.out.print("Enter Percent Grade (ex. 83): ");
			int grade = input.nextInt();
			
			if (input.hasNextLine()) {
				input.nextLine();
			}
			
			// Create and store JSON object
			JSONObject courseObject = new JSONObject();
			courseObject.put("grade", grade);
			courseObject.put("name", course);
			
			// Add course to array
			courses.add(courseObject);
			
		}
		
		// Add array to root object
		root.put("courses", courses);
		
		System.out.println(root.toJSONString());
		
		// Create txt file		
		File file = new File("StudentCourse&Grades.txt");
		
		try (PrintWriter writer = new PrintWriter(file)){
			writer.print(root.toJSONString());
		} catch (FileNotFoundException ex) {
			System.out.println(ex.toString());
		}
		
		System.out.println("File created successfully.\n\nPress enter to continue.");
		input.nextLine();
		
		try {
			input = new Scanner(file);
			
			StringBuilder jsonIn = new StringBuilder();
			while (input.hasNextLine()) {
				jsonIn.append(input.nextLine());
			}
			System.out.println(jsonIn.toString());
			
			// Parse string
			JSONParser parser = new JSONParser();			
			JSONObject objRoot = (JSONObject) parser.parse(jsonIn.toString());
			
			System.out.printf("Student name is %s\n", objRoot.get("name").toString());
			
			// Add parsed contents back into array
			JSONArray coursesIn = (JSONArray) objRoot.get("courses");
			
			// Loop back through the array to display contents
			for (int i = 0; i < coursesIn.size(); i++) {
				JSONObject courseIn = (JSONObject) coursesIn.get(i);
				long gradeIn = (long) courseIn.get("grade");
				String nameIn = (String) courseIn.get("name");
					
				System.out.printf("Course %s; Percent grade %d\n", nameIn, gradeIn);
			}
			
		} catch (FileNotFoundException ex) {
			System.out.println(ex.toString());
			
		} catch (ParseException ex) {
			System.out.println(ex.toString());
		}		
		
	}

}