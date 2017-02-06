package com.shilin.hope.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Example Given ["lint", "intl", "inlt", "code"], return ["lint", "inlt",
 * "intl"].
 * 
 * Given ["ab", "ba", "cd", "dc", "e"], return ["ab", "ba", "cd", "dc"].
 * 
 * All inputs will be in lower-case
 * 
 * @author Shilin_Gan
 *
 */

/**
 * 
 * this is an important technique to compare anagrams and others!!!!
 *
 */
public class AnagramArray {
	/**
	 * @param strs:
	 *            A list of strings
	 * @return: A list of strings
	 */
	public List<String> anagrams(String[] strs) {
		// write your code here
		List<String> ans = new ArrayList<String>();

		Map<String, List<String>> anagramMap = new HashMap<String, List<String>>();
		
		for (String str : strs){
			// there will be only 26 lower case letters
			// default value for char is ASCII value 0/null
			// don't confuse this with 0's ASCII value 48
			char[] count = new char[26];
			
			for (int i = 0; i < str.length(); i++){
				// this is an important technique 
				// compare this to int[256], count[(int) str.charAt(i)]
				// make use of the offered conditions!
				count[str.charAt(i) - 'a']++;
			}
			
			// cool !!!
			String anagramKey = new String(count);
			
			if (anagramMap.containsKey(anagramKey)){
				anagramMap.get(anagramKey).add(str);
			}else{
				// Arrays.asList(str) creates a list backed by array which doesn't support modifications 
				// so if using add() on it, it'll throw Exception!!!!
				anagramMap.put(anagramKey, new ArrayList<String>(Arrays.asList(str)));
			}
		}
		
		// remember how to loop through map 
		for (Map.Entry<String, List<String>> entry : anagramMap.entrySet()){
			if (entry.getValue().size() > 1){
				ans.addAll(entry.getValue());
			}
		}
		
		return ans;
	}
	
	
	public static void main(String args[]){
		
		System.out.println(new AnagramArray().anagrams(new String[]{"ab", "ba", "cd", "dc", "e"}));
		
		int[] test = new int[26];
		test[3] = 12345;
		// this is handy!!!
		System.out.println(Arrays.toString(test));
		
	}
}
