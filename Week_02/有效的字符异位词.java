class Solution {
    //方法一：暴力方法,
/*
 public boolean isAnagram(String s, String t) {
        char[] cArr1 = s.toCharArray();
        char[] cArr2 = t.toCharArray();
        Arrays.sort(cArr1);
        Arrays.sort(cArr2);
        //return (new String(cArr1)).equals(new String(cArr2));
        return Arrays.equals(cArr1,cArr2);//Arrays的重写equals方法不是固定的数组对象而是Arrays类来实现两个数组的比较
    } 
    */
    /*
 public boolean isAnagram(String s, String t) {
     int[] arr1 = new int[256];
     int[] arr2 = new int[256];
     for(int i=0;i<s.length();i++) {
         arr1[s.charAt(i)]++;
     }
     for(int j=0;j<t.length();j++) {
         arr2[t.charAt(j)]++;
     }
     for (int i=0;i<256;i++) {
         if(arr1[i]!=arr2[i]) {
             return false;
         }
     }
     return true;
    }
    */
    /*
    //方法二：两遍HashMap,然后比较map内容是否相等
    public boolean isAnagram(String s, String t) {
        //boundary condition
        Map<Character,Integer> map1 = new HashMap<>();
        Map<Character,Integer> map2 = new HashMap<>();
        char[] cArr1 = s.toCharArray();
        char[] cArr2 = t.toCharArray();
        if(cArr1.length!=cArr2.length) return false;
        for(int i=0;i<cArr1.length;i++) {
            map1.put(cArr1[i],map1.getOrDefault(cArr1[i],0) + 1);
        } 
        for(int i=0;i<cArr2.length;i++) {
            map2.put(cArr2[i],map2.getOrDefault(cArr2[i],0) + 1);
        } 
        if(map2.equals(map1)) {
            return true;
        }
        return false;
    }
    */
    /*
  public boolean isAnagram(String s, String t) {
        //boundary condition
        if(s.length()!=t.length()) {
            return false;
        }
        Map<Character,Integer> map1 = new HashMap<>();
        char[] cArr1 = s.toCharArray();
        char[] cArr2 = t.toCharArray();
        for(int i=0;i<cArr1.length;i++) {
            map1.put(cArr1[i],map1.getOrDefault(cArr1[i],0) + 1);
        } 
        for(int i=0;i<cArr2.length;i++) {
            if(map1.containsKey(cArr2[i])) {
                map1.put(cArr2[i],map1.get(cArr2[i])-1);
            }else {
                return false;
            }
        } 
        for(Character c:map1.keySet()) {
            if(map1.get(c)!=0) {
                return false;
            }
        }
        return true;
    }
    */
 public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length())  return false;
        char[] cArr1 = s.toCharArray();
        char[] cArr2 = t.toCharArray();
        int[] counter = new int[26];
        for(int i=0;i<cArr1.length;i++) {
            counter[cArr1[i]-'a']++;//用正整数记录频数
            counter[cArr2[i]-'a']--; //用负整数记录频数
        }
        for(int j=0;j<26;j++) {
            if(counter[j]!=0)  return false;
        }
            return true;
    }
}