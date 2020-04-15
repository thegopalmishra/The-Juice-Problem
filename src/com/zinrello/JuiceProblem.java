package com.zinrello;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


/**
 * @author Gopal Mishra
 *
 */
public class JuiceProblem {
	
	private static List <Character> juicesInShelfInSortedOrder =  null;

	/**
	 * @param o : Object
	 * @since 15/04/2020
	 * @description Prints object to console
	 *
	 */
	public static void cout(Object o){
//		System.out.println(o);
	}
	
	
	/**
	 * @param filename : Name of file with complete path
	 * @since 15/04/2020
	 * @return List<String> : List of lines in a file
	 *
	 */
	public static List<String> readInput(String filename){
		List<String> lines = new ArrayList<>();
		try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filename))) {
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				lines.add(line);
			}
		} catch (FileNotFoundException e) {	
			cout("Input file not found. Please check the name and path again");
		} catch (IOException e) {
			cout("IO exception occurred.");
		}
		return  lines;
	}
	
	
	/**
	 * @param lines : List<String> : List of lines in a file
	 * @since 15/04/2020
	 * @return void
	 *
	 */
	public static void writeOutput(List<StringBuilder> lines) throws IOException {
		String outputFilePath = "src\\resources\\output.txt";
		try (BufferedWriter bw = new BufferedWriter(
				new OutputStreamWriter(
						new FileOutputStream(
								new File(outputFilePath))))) {
			for (StringBuilder string : lines) {
				bw.write(string.toString());
				bw.newLine();
			}
		}
	}

	
	/**
	 * @param uniqueFruitsAndCalories : A numeral string where first value denotes number of unique fruits and rest denotes calories for each of them
	 * @param juicesInShelf : A string whose individual character denotes a juice on shelf
	 * @since 15/04/2020
	 * @return List<String> : Map whose key denotes unique fruits and values denotes respective calories
	 * @description Used to map unique fruits with their respective calories
	 *
	 */
	private static Map <Character, Integer> getJuiceCaloriesList(String uniqueFruitsAndCalories, String juicesInShelf) {

		Map <Character, Integer> fruitCaloriesMap = new HashMap<>();
		
		String[] uniqueFruitsAndCaloriesArray = uniqueFruitsAndCalories.split(" ");
		cout("Number of unique Fruits and resp Calories: " + Arrays.toString(uniqueFruitsAndCaloriesArray));
		if(uniqueFruitsAndCaloriesArray.length > 27) {
			throw new RuntimeException("Can't have more than 26 unique fruits");
		}
		
		juicesInShelfInSortedOrder  = juicesInShelf.chars()
				.mapToObj(c -> (char) c)
				.collect(Collectors.toList());
		Collections.sort(juicesInShelfInSortedOrder);
		
		cout("Sorted Fruit Juices: " + juicesInShelfInSortedOrder.toString());
		
		// To get unique fruits
		List <Character> uniqueFruits = juicesInShelfInSortedOrder.stream()
				.distinct()
				.collect(Collectors.toList());
		
		for (int i = 0; i < uniqueFruits.size(); i++) {
			fruitCaloriesMap.put(uniqueFruits.get(i), Integer.parseInt(uniqueFruitsAndCaloriesArray[i + 1]));
		}
		return fruitCaloriesMap;
	}

	
	/**
	 * @param uniqueFruitsAndCalories : Map<Character,Integer> whose key denotes unique fruits and values denotes respective calories
	 * @param calorieIntake : An integer denoting calorie intakes
	 * @since 15/04/2020
	 * @return void
	 * @throws IOException 
	 * @description Creates cocktail for given calorie intakes if possible else asks to consume water 
	 *
	 */
	private static StringBuilder cocktailMaker(Map <Character, Integer> uniqueFruitsAndCalories, int calorieIntake) {
		int count = 0;
		StringBuilder combination = new StringBuilder(""); 
		// If cocktail should have unique juices use below loop
		for (Map.Entry<Character, Integer> entry: uniqueFruitsAndCalories.entrySet()) {
			if (uniqueFruitsAndCalories.containsValue(calorieIntake)) {
				cout(entry.getKey());
				combination.append(entry.getKey());
			} else if (entry.getValue() < calorieIntake) {
				count += entry.getValue();
				combination.append(entry.getKey());
			}
		}		
		if (count == calorieIntake) {
			cout("Coctail Combination : " + combination);
		} else {
			cout("SORRY, YOU JUST HAVE WATER");
			combination.setLength(0);
			combination.append("SORRY, YOU JUST HAVE WATER");
		}
		return combination;
		
		
	}


	public static void main(String[] args) throws IOException {

		List <String> list = readInput("src\\resources\\input.txt");
		List <StringBuilder> output = new ArrayList<>();

		int friendsInvited = Integer.parseInt(list.get(0));
		if (friendsInvited > 200) {
			throw new RuntimeException("Can't invite more than 200 friends");
		}
		cout("Friends Invited: " + friendsInvited + "\n");

		int[] calorieIntake = new int[friendsInvited];

		for (int i = 0; i < friendsInvited; i++) {
			calorieIntake[i] = Integer.parseInt(list.get((i + 1) * 3));
			cout("Calorie Intake of Friend " + (i + 1) + ": " + calorieIntake[i]);
			String uniqueJuicesAndCalories = list.get(3 * i + 1);
			String juicesOnShelf = list.get(3 * i + 2).toLowerCase();
			output.add(cocktailMaker(getJuiceCaloriesList(uniqueJuicesAndCalories, juicesOnShelf), calorieIntake[i]));
			cout("");
		}
		writeOutput(output);
	}

}