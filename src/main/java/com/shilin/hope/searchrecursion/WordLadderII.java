package com.shilin.hope.searchrecursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * Given two words (start and end), and a dictionary, find all shortest
 * transformation sequence(s) from start to end, such that:
 * 
 * Only one letter can be changed at a time Each intermediate word must exist in
 * the dictionary Notice
 * 
 * All words have the same length. All words contain only lowercase alphabetic
 * characters.
 * 
 * Example Given: start = "hit" end = "cog" dict =
 * ["hot","dot","dog","lot","log"] Return [ ["hit","hot","dot","dog","cog"],
 * ["hit","hot","lot","log","cog"] ]
 * 
 * @author Shilin
 *
 */
public class WordLadderII {
	public static void main(String[] args){
		Set<String> dict = new HashSet<String>();
		dict.addAll(Arrays.asList("si","go","se","cm","so","ph","mt","db","mb","sb","kr","ln","tm","le","av","sm","ar","ci","ca","br","ti","ba","to","ra","fa","yo","ow","sn","ya","cr","po","fe","ho","ma","re","or","rn","au","ur","rh","sr","tc","lt","lo","as","fr","nb","yb","if","pb","ge","th","pm","rb","sh","co","ga","li","ha","hz","no","bi","di","hi","qa","pi","os","uh","wm","an","me","mo","na","la","st","er","sc","ne","mn","mi","am","ex","pt","io","be","fm","ta","tb","ni","mr","pa","he","lr","sq","ye"));
		System.out.println(new WordLadderII().findLadders("qa", "sq",dict));
		
		//System.out.println(new WordLadderII().differByOne("hot", "cog"));
	}
	
    /**
     * @param start, a string
     * @param end, a string
     * @param dict, a set of string
     * @return a list of lists of string
     */
    public List<List<String>> findLadders(String start, String end, Set<String> dict) {
        // write your code here  
        List<List<String>> result = new ArrayList<List<String>>();
        
        Map<String, List<String>> backTrack = new HashMap<String, List<String>>();
        
        Queue<String> level = new LinkedList<String>();
        level.offer(start);
        
        Set<String> visited = new HashSet<String>();
        boolean found = false;
        while(!level.isEmpty()){
            Set<String> levelVisited = new HashSet<String>();
            Queue<String> tmp = new LinkedList<String>();
            while (!level.isEmpty()) {
                String current = level.poll();
                visited.add(current);
                
                if (differByOne(current, end)) {
                    found = true;
                    result.addAll(buildPath(backTrack, current, end));
                }
                if (found) {
                	return result;
                    //continue;
                }
                
                for (String str : dict) {
                    if (visited.contains(str) || !differByOne(str, current)) {
                        continue;
                    }
                    if (!levelVisited.contains(str)){
                        tmp.add(str);
                    }
                    
                    levelVisited.add(str);
                    if (backTrack.containsKey(str)){
                        backTrack.get(str).add(current);
                    } else {
                        List<String> parentList = new ArrayList<String>();
                        parentList.add(current);
                        backTrack.put(str, parentList);
                    }
                }
            }
            visited.addAll(levelVisited);
            level = tmp;
        }
        
        return result;
    }
    
    private List<List<String>> buildPath(Map<String, List<String>> backTrack, String current, String end){
        List<List<String>> solution = new ArrayList<List<String>>();
        //System.out.println("current = " + current + " end = " + end);
        //System.out.println(backTrack);
        List<String> path = new LinkedList<String>();
        path.add(0, end);
        path.add(0, current);
        buildPath(backTrack, current, solution, path);
       // System.out.println(solution);
        return solution;
    }
    
    private void buildPath(Map<String, List<String>> backTrack, String current, List<List<String>> solution, List<String> path){
       
        if (!backTrack.containsKey(current)){
            solution.add(new LinkedList<String>(path));
            return;
        }
        for (String parent : backTrack.get(current)) {
        	path.add(0, parent);
            buildPath(backTrack, parent, solution, path);
            path.remove(0);
        }
        
        
    }
    
    
    private boolean differByOne(String a, String b) {
        char[] arrayA = a.toCharArray();
        char[] arrayB = b.toCharArray();
        
        int differences = 0;
        for (int i = 0; i < arrayA.length; i++){
            if (arrayA[i] != arrayB[i] && ++differences > 1) {
                return false;
            }
        }
        
        return differences == 1;
    }
}
