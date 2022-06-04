package leetcode;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Map.Entry;

/*
 * 2 Jun 2022
 * https://leetcode.com/problems/sort-characters-by-frequency/
 */

public class SortCharactersByFrequency {

	public static void main(String[] args) {
		String output = frequencySort("tree");
		System.out.println(output);
	}
	
	private static String frequencySort(String s) {
		
		Map<Character,Integer> map = new HashMap<Character, Integer>();
		StringBuilder builder = new StringBuilder();
		
		for(Character character : s.toCharArray()) {
			map.put(character, map.getOrDefault(character, 0)+1);
		}
		
		PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>(new Comparator<Map.Entry<Character, Integer>>() {
			
			@Override
			public int compare(Entry<Character, Integer> o1, Entry<Character, Integer> o2) {
				return o2.getValue()- o1.getValue();
			}
		});
		
		pq.addAll(map.entrySet());
		
		while(!pq.isEmpty()) {
			
			Map.Entry<Character, Integer> entry = pq.poll();
			
			for(int i = 0; i < entry.getValue(); i++) {
				builder.append(entry.getKey());
			}
		}
		
		return builder.toString();
	}
}
