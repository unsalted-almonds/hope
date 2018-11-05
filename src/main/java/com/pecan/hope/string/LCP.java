package com.pecan.hope.string;

public class LCP {
	/**
	 * @param strs:
	 *            A list of strings
	 * @return: The longest common prefix
	 */
	
	// this one needs to be refactored to look better
	
	// try a simple word by word comparison 
	
	public String longestCommonPrefix(String[] strs) {
		// write your code here

		if (strs == null || strs.length == 0) {
			return "";
		}

		int min = Integer.MAX_VALUE;

		for (String str : strs) {
			min = Math.min(str.length(), min);
		}

		int i = 0;
		boolean end = false;

		for (i = 0; i < min; i++) {
			char letter;
			if (!end) {
				letter = strs[0].charAt(i);
			} else {
				break;
			}

			for (String str : strs) {
				if (str.charAt(i) != letter) {
					end = true;
					i--;
					break;
				}
			}

		}

		i--;
		return strs[0].substring(0, i + 1);

	}
	
    public String longestCommonPrefixBetter(String[] strs) {
        // write your code here
        
        if (strs == null || strs.length == 0){
            return "";
        }
        
        String prefix = strs[0];
        
        for (int i = 1; i < strs.length; i++){
            
            int j = 0;
            for (j = 0; j < prefix.length() && j < strs[i].length(); j++){
                if (prefix.charAt(j) != strs[i].charAt(j)){
                    break;
                }
            }
            if (j == 0){
                return "";
            }
            prefix = prefix.substring(0,j);
        }
        
        return prefix;
        
    }
	
}
