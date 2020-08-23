class Solution {
    //������������ÿһ���ַ�����λ�ʣ�����¼����״̬
    //hash���¼��λ��
    /*
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        int len = strs.length;
        if(len==0) return res;
        Map<String,List<String>> map = new HashMap<>();
        for(int i=0;i<len;i++) {
            //����Ψһkey
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            String temp = new String(chars);//���涨�������ַ����飬������λ��ӳ���Ψһkey
            if(!map.containsKey(temp)) {
                List<String> tempList = new ArrayList<>();
                map.put(temp,tempList);
            }
            map.get(temp).add(strs[i]);
        }
        return new ArrayList<List<String>>(map.values());
    }
*/
/*
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        int len = strs.length;
        if(len==0) return res;
        boolean[] visited = new boolean[len];
        for(int i=0;i<len;i++) {
            if(!visited[i]) {
                visited[i] = true;
                List<String> tempList = new ArrayList<>();
                tempList.add(strs[i]);
                char[] chars_i = strs[i].toCharArray();
                Arrays.sort(chars_i);
                for(int j=i+1;j<len;j++) {
                    if(!visited[j]) {
                        if(strs[j].length() == chars_i.length) {
                            char[] chars_j = strs[j].toCharArray();
                            Arrays.sort(chars_j);
                            if(Arrays.equals(chars_i,chars_j)) {
                                visited[j] = true;//ֻ��������λ�ʲſ�������λ�Ѿ�����
                                tempList.add(strs[j]);
                            }
                        }
                    }
                }
                Collections.sort(tempList);
                res.add(tempList);
            }
        }
        Collections.sort(res,new Comparator<List>() {

            @Override
            public int compare(List list1,List list2) {
                return list1.size() - list2.size();
            }
        });
        return res;
    }
    */
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        int len = strs.length;
        if(len==0) return res;
        Map<String,List<String>> map = new HashMap<>();
        String delimiter = "#";
        int[] freNum = new int[26];
        for(int i=0;i<len;i++) {
            //����Ψһkey,�˴���������ӳ���ϵ����key
            String key = "";
            char[] chars = strs[i].toCharArray();
            Arrays.fill(freNum,0);key="";
            for(int j=0;j<chars.length;j++)  freNum[chars[j]-'a']++;
            for(int k=0;k<26;k++) {
                key = key + freNum[k] + delimiter;
            }
            if(!map.containsKey(key)) {
                List<String> tempList = new ArrayList<>();
                map.put(key,tempList);
            }
            map.get(key).add(strs[i]);
        }
        return new ArrayList<List<String>>(map.values());
    }
}