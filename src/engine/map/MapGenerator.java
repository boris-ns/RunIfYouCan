package engine.map;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

import game.GameObject;
import game.objects.Wall;

public class MapGenerator {
		
	/**
	 * Static method that generates game map from *.txt file.
	 * In *.txt file '*' represents Wall objects.
	 * @return GameObject type ArrayList-matrix with all objects 
	 */
	public static ArrayList<ArrayList<GameObject>> generateMap(LinkedList<GameObject> objects) {
		return addObjectsToMap(objects);
	}
	
	/**
	 * Method that calls readDataFromFile() and returns text file as ArrayList matrix of chars.
	 * @return ArrayList of char arrays
	 */
	public static ArrayList<char[]> generateMapAsCharArray() {
		return readDataFromFile();
	}
	
	/**
	 * Method that goes through ArrayList of char arrays that are read from text file before.
	 * And according to each char method adds appropriate GameObject.
	 * @param objects - list of objects that are added into the game.
	 * @return ArrayList matrix of objects
	 */
	private static ArrayList<ArrayList<GameObject>> addObjectsToMap(LinkedList<GameObject> objects) {
		ArrayList<ArrayList<GameObject>> map = new ArrayList<ArrayList<GameObject>>();
		
		ArrayList<char[]> dataArray = readDataFromFile();
		for(int i = 0; i < dataArray.size(); ++i) {
			for(int j = 0; j < dataArray.get(i).length; ++j) {
				if(dataArray.get(i)[j] == '*') {
					objects.add(new Wall(j * Wall.SIZE, i * Wall.SIZE));
				}
			}
		}
		
		return map;
	}
	
	/**
	 * Method that reads text-file and converts it to ArrayList of char arrays
	 * @return ArrayList of char arrays
	 */
	private static ArrayList<char[]> readDataFromFile() {
		ArrayList<char[]> charMap = new ArrayList<char[]>();
		File file = new File(loadRandomMap());
		
		Scanner scanner = null;
		try {
			scanner = new Scanner(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		while(scanner.hasNextLine()) {
			char[] line = scanner.nextLine().toCharArray();
			charMap.add(line);
		}
		
		return charMap;
	}
	
	/**
	 * Method that gets all files from 'maps' folder and randomly chooses one file(map)
	 * that will be generated.
	 * @return String representation of choosen file (map)
	 */
	private static String loadRandomMap() {
		File mapsFolder = new File("maps/");
		File[] filesInFolder = mapsFolder.listFiles();
		ArrayList<String> filesStr = new ArrayList<String>();
		
		for (int i = 0; i < filesInFolder.length; ++i) {
			if (filesInFolder[i].isFile()) {
				filesStr.add(filesInFolder[i].getName());
			}
		}
		
		int randomNumber = ThreadLocalRandom.current().nextInt(0, filesStr.size());
		
		return "maps/" + filesStr.get(randomNumber);
	}	
}
