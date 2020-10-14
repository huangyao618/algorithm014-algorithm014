class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> list = new ArrayList<>();
        Arrays.sort(intervals,new Comparator<int[]>(){

            @Override
            public int compare(int[] arr1,int[] arr2) {
                if(arr1[0]!=arr2[0]) {
                    return arr1[0] - arr2[0];
                }
                return arr1[0] - arr2[0];
            }
        });
        if(intervals.length<=1) return intervals;//提前结束
        int len = intervals.length;
        for(int i=0;i<len-1;i++) {
            int[] arr1 = intervals[i];
            int[] arr2 = intervals[i+1];
            if(arr1[1]<arr2[0]) {//前后两区间分立
                list.add(arr1);
            }else if(arr1[1]<arr2[1]) {//前后两区间合并，交叉关系
                arr2[0] = arr1[0];
            }else {//前后两区间合并，包含关系
                arr2[0] = arr1[0];
                arr2[1] = arr1[1];
            }
            if(i==len-2)     list.add(arr2);
        }
        return list.toArray(new int[list.size()][]);
    }
}