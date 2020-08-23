class Solution {
    /*
    //基于比较法的堆排序
    public int[] topKFrequent(int[] nums, int k) {
        Arrays.sort(nums);
        int[] res = new int[k];
        PriorityQueue<Element> maxHeap = new PriorityQueue<>(new Comparator<Element>() {

            @Override
            public int compare(Element e1 ,Element e2) {
                return e2.fre - e1.fre;
            }
        }); 
        int key=0,fre=0;
        int len = nums.length;
        for(int i=0;i<len;i++) {
            if(i==0) {
                key = nums[i];
                fre++;
                continue;
            }
            if(nums[i]==key) {
                fre++;
            }else {
                maxHeap.offer(new Element(key,fre));
                key = nums[i];
                fre = 1;
            }
        }
        maxHeap.offer(new Element(key,fre));
        for(int j=0;j<k;j++) {
            res[j] = maxHeap.poll().key;
        } 
        return res;
    }
}
class Element{
    int key;
    int fre;
    public Element(int key,int fre) {
        this.key = key;
        this.fre = fre;
    }
    */
    //基于hashMap记录的堆排序
    /*
    public int[] topKFrequent(int[] nums, int k) {
        Arrays.sort(nums);
        int[] res = new int[k]; 
        Map<Integer,Integer> map = new HashMap<>();
        int len = nums.length;
        for(int i=0;i<len;i++) {
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>(){

            @Override
            public int compare(Integer var1,Integer var2) {
                return map.get(var2) - map.get(var1);
            }
        });
        for(Integer temp:map.keySet()) {
            maxHeap.offer(temp);
        }
        for(int i=0;i<k;i++) {
            res[i] = maxHeap.poll();
        }
        return res;
    }
    */
    //方法三：桶排序
      public int[] topKFrequent(int[] nums, int k) {
        Arrays.sort(nums);
        int[] res = new int[k]; 
        Map<Integer,Integer> map = new HashMap<>();
        int len = nums.length;
        for(int i=0;i<len;i++) {
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }

        List[] lists = new List[nums.length+1];//利用null这个特性排除，还可以存放多个频数相同的值
        for(Integer temp:map.keySet()) {
            int index = map.get(temp);//获得当前值的频数
            if(lists[index]==null)  {
                lists[index] = new ArrayList<Integer>();
            }
            lists[index].add(temp);//将频数对应的值存进对应的list
        }
        int m = 0;
        for(int n=lists.length-1;n>=0&&m<k;n--) {
            if(lists[n]!=null) {
                for(Object iTemp:lists[n]) {
                    res[m++] = (Integer)iTemp;
                }
            }
        }
        return res;
    }   
}