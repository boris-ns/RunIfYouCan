package engine.map;

import java.util.ArrayList;

public class TestMapGenerator {

	public static void main(String[] args) {
		ArrayList<char[]> charMap = MapGenerator.generateMapAsCharArray();
		
		for(int i = 0; i < charMap.size(); ++i) {
			for(int j = 0; j < charMap.get(i).length; ++j) {
				System.out.print(charMap.get(i)[j]);
			}
			System.out.println();
		}
	}

}
