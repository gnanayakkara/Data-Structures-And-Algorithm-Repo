package interviews;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

/*
 * 16 Oct 2022
 */

public class FirstNonRepeatCharacter {
	
	Map<Character,Integer> map = new LinkedHashMap<Character,Integer>();

	public static void main(String[] args) {
		
		FirstNonRepeatCharacter character = new FirstNonRepeatCharacter();
		character.findNonRepeating("buddybhaskar");
	}
	
	void findNonRepeating(String word) {
		
		for(Character c : word.toCharArray()){
			
			if(map.get(c) == null){
				map.put(c,1);
			}else{
				map.put(c,map.get(c)+1);
			}
			
		}
		
		for(Entry<Character, Integer> key : map.entrySet()){
			
			int i = map.get(key.getKey());
			
			if(i == 1){
				System.out.println(key.getKey());
				break;
			}
			
		}
	}
}
