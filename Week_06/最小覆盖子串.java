class Solution {
  	    public String minWindow(String s, String t) {
	    	if(s==null||t==null||t.length()>s.length()) {
	    		return "";
	    	}
	    	//ת��Ϊ�ַ�����
	    	char[] cArrS = s.toCharArray();
	    	char[] cArrT = t.toCharArray();
	    	//��¼��ز���
	    	int upperLimit = cArrS.length;
	    	int minLen = Integer.MAX_VALUE;//���Ž��ʼ�����ȣ���Ϊ����̣���ô��ʼ�����޴�
	    	int tlen = cArrT.length;//�����е��ַ���Ŀ���ַ�ƥ���ľ��룬��Ŀ�����ַ�Ƶ����
	    	int distance = 0;//������Ŀ�괮�Ľӽ��̶ȣ�distance==tlen�򴰿ڰ�����Ŀ�괮
	    	int begin = 0;//���Ž�����
	    	//�������ڲ���
	    	int left = 0;
	    	int right = 0;
	    	//���䳤�� [left,right)  length=right - left
	    	//��ʼ��Ŀ�괮���ַ�Ƶ��
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