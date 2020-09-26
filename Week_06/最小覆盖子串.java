class Solution {
  	    public String minWindow(String s, String t) {
	    	if(s==null||t==null||t.length()>s.length()) {
	    		return "";
	    	}
	    	//转化为字符数组
	    	char[] cArrS = s.toCharArray();
	    	char[] cArrT = t.toCharArray();
	    	//记录相关参数
	    	int upperLimit = cArrS.length;
	    	int minLen = Integer.MAX_VALUE;//最优解初始化长度，因为求最短，那么初始化无限大
	    	int tlen = cArrT.length;//窗口中的字符与目标字符匹配后的距离，或目标中字符频数和
	    	int distance = 0;//窗口与目标串的接近程度，distance==tlen则窗口包含有目标串
	    	int begin = 0;//最优解的起点
	    	//滑动窗口参数
	    	int left = 0;
	    	int right = 0;
	    	//区间长度 [left,right)  length=right - left
	    	//初始化目标串的字符频数
	    	Map<Character,Integer> targetFreq = new HashMap<Character,Integer>();
	    	Map<Character,Integer> winFreq = new HashMap<Character,Integer>();
	    	for(int i=0;i<tlen;i++) {
	    		if(targetFreq.containsKey(cArrT[i])) {
	    			targetFreq.put(cArrT[i], targetFreq.get(cArrT[i]).intValue()+1);
	    		}else {
	    			targetFreq.put(cArrT[i],1);
	    		}
	    	}
	    	while(right<upperLimit) {
	    		  if(targetFreq.containsKey(cArrS[right])) {
	    			  if((!winFreq.containsKey(cArrS[right]))||winFreq.get(cArrS[right])<targetFreq.get(cArrS[right])) {
	    				  distance++;
	    			  }
	  	    		if(winFreq.containsKey(cArrS[right])) {
		    			winFreq.put(cArrS[right], winFreq.get(cArrS[right]).intValue()+1);
		    		}else {
		    			winFreq.put(cArrS[right],1);
		    		}
	    		  }
	    		  right++;
	    		  while(distance==tlen) {
		    		  if(targetFreq.containsKey(cArrS[left])) {
		    			  if((int)winFreq.get(cArrS[left])==(int)targetFreq.get(cArrS[left])) {
		    				  distance--;
		    				  if(right-left<minLen) {
		    					  minLen = right - left;
		    					  begin = left;
		    				  }
		    			  }
			    			winFreq.put(cArrS[left], winFreq.get(cArrS[left]).intValue()-1);
		    		  }
		    		  left++;
	    		  }
	    	}
  		  if(minLen ==Integer.MAX_VALUE) {
			  return "";
		  }
		  return s.substring(begin, begin+minLen);
	    	
	    }
}