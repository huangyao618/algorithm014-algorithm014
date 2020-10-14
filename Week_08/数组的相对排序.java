class Solution {
    /*
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer,Integer> map = new HashMap<>();
        int len1 = arr1.length, len2 = arr2.length;
        for(int i=0;i<len2;i++) {
            map.put(arr2[i],i);
        }
        int[] newArr = new int[len1];
        int left = 0,right = len1-1;
        for(int k=0;k<len1;k++) {
            if(map.containsKey(arr1[k])) {
                newArr[left++] = arr1[k];
            }else {
                newArr[right--] = arr1[k];
            }
        }
        //System.out.println(left);
        _mySort(newArr,0,left-1,map);
        _myOtherSort(newArr,left,len1-1);
        return newArr;
    }

    public void _mySort(int[] arr,int left,int right,Map<Integer,Integer> map) {
        if(right<=left) {
            return;
        }
        boolean isExchange = true;
        for(int i=0;i<right - left&&isExchange;i++) {
            isExchange = false;
            for(int j=left;j<right - i;j++) {
                if(map.get(arr[j])>map.get(arr[j+1])) {
                    isExchange = true;
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }
    public void _myOtherSort(int[] arr,int left,int right) {
        if(right<=left) return;
       boolean isExchange = true;
        for(int i=0;i<right - left&&isExchange;i++) {
            isExchange = false;
            for(int j=left;j<right - i;j++) {
                if(arr[j]>arr[j+1]) {
                    isExchange = true;
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }       
    }
    */
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int len1 = arr1.length,len2 = arr2.length;
        int[] map = new int[1001];
        int[] ref = new int[len1];
        for(int i=0;i<len1;i++) {
            map[arr1[i]]++;//索引表示数值，值表示数值的个数
        }
        int cnt = 0;
        for(int j =0;j<len2;j++) {//arr2的优先级最高
            while(map[arr2[j]]>0) {
                ref[cnt++] = arr2[j];
                map[arr2[j]]--; 
            }
        }
        for(int k=0;k<1001;k++) {
            while(map[k]>0) {
                ref[cnt++] = k;
                map[k]--;
            }
        }
        return ref;
    }
}