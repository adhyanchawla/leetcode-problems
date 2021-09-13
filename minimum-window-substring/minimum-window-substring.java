class Solution {
    public String minWindow(String s1, String s2) {
        
        HashMap<Character, Integer> map1 = new HashMap<>();
		HashMap<Character, Integer> map2 = new HashMap<>();
		
		for(int i = 0; i < s2.length(); i++) {
		    char ch = s2.charAt(i);
		    
		    if(!map2.containsKey(ch)) {
		        map2.put(ch, 1);
		    } else {
		        map2.put(ch, map2.get(ch) + 1);
		    }
		}
		
		
		String oans = "";
		
		int i = -1, j = -1;
		int mc = 0;
		int dmc = s2.length();
		
		//can neither acquire nor release
		while(i < s1.length() - 1) {
		    //1. acquire till mc != dmc
		    while(i < s1.length() - 1 && mc < dmc) {
		        i++;
		        
		        //acquire the ith character
		        char ch = s1.charAt(i);
		        
		       if(!map1.containsKey(ch)) {
		            map1.put(ch, 1);
		        } else {
		            map1.put(ch, map1.get(ch) + 1);
		        }
		        
		        //impact on match count
		        if(map2.containsKey(ch) && map1.getOrDefault(ch, 0) <= map2.getOrDefault(ch, 0)) {
		            mc++;
		        }
		    }
		    
		    //2. release tab tk jabtk mc == dmc and j < i
		    
		    while(j < i && mc == dmc) {
		        String ans = s1.substring(j + 1, i + 1);
		        if(oans.length() == 0 || ans.length() < oans.length()) {
		            oans = ans;
		        }
		        
		        j++;
		        //release jth
		        char ch = s1.charAt(j);
		        int freq = map1.get(ch);
		        
		        if(freq == 1) {
		            map1.remove(ch);
		        } else {
		            map1.put(ch, freq - 1);
		        }
		        
		        //impact on match count
		 
		        if(map1.getOrDefault(ch, 0) < map2.getOrDefault(ch, 0)) {
		            mc--;
		        }
		        
		    }
		    
		    
		}
		
		return oans;
    }
}