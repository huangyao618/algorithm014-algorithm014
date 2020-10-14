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
        if(intervals.length<=1) return intervals;//��ǰ����
        int len = intervals.length;
        for(int i=0;i<len-1;i++) {
            int[] arr1 = intervals[i];
            int[] arr2 = intervals[i+1];
            if(arr1[1]<arr2[0]) {//ǰ�����������
                list.add(arr1);
            }else if(arr1[1]<arr2[1]) {//ǰ��������ϲ��������ϵ
                arr2[0] = arr1[0];
            }else {//ǰ��������ϲ���������ϵ
                arr2[0] = arr1[0];
                arr2[1] = arr1[1];
            }
            if(i==len-2)     list.add(arr2);
        }
        return list.toArray(new int[list.size()][]);
    }
}