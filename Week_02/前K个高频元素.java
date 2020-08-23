class Solution {
    /*
    //���ڱȽϷ��Ķ�����
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
    //����hashMap��¼�Ķ�����
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
    //��������Ͱ����
      public int[] topKFrequent(int[] nums, int k) {
        Arrays.sort(nums);
        int[] res = new int[k]; 
        Map<Integer,Integer> map = new HashMap<>();
        int len = nums.length;
        for(int i=0;i<len;i++) {
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }

        List[] lists = new List[nums.length+1];//����null��������ų��������Դ�Ŷ��Ƶ����ͬ��ֵ
        for(Integer temp:map.keySet()) {
            int index = map.get(temp);//��õ�ǰֵ��Ƶ��
            if(lists[index]==null)  {
                lists[index] = new ArrayList<Integer>();
            }
            lists[index].add(temp);//��Ƶ����Ӧ��ֵ�����Ӧ��list
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