学习笔记

对位运算技巧有了更进一步的掌握，掌握了一种内存和时间复杂度的重要优化策略
对排序的时间复杂度有了更深的认识，尤其是对归并和快速排序的理解更透彻，两者是基于分治思想下的两个不同的策略，一个是分成两个有序的区间，一个是找到中间点，分成两个独立的区间

基于排序算法的java实现
1、冒泡排序
	public void bubleSort(int[] arr) {
		int len = arr.length;
		if(len<=1) return;
		boolean isExchange = true;
		for(int i=0;i<len&&isExchange;i++) {
			isExchange = false;
			for(int j=0;j<len-i-1;j++) {
				if(arr[j]>arr[j+1]) {
					isExchange = true;
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
	}

2、快速排序
	public void quickSort(int[] arr,int left,int right) {
		if(left>=right) return;
		int pivot = partition(arr,left,right);
		quickSort(arr,left,pivot -1);
		quickSort(arr,pivot+1,right);
	}
	
	private int partition(int[] arr, int left, int right) {
		// TODO Auto-generated method stub
		int low = left,high = right;
		int pivot_Item = arr[left];
		while(left<right) {
			while(left<arr.length&&arr[left]<=pivot_Item) left++;
			while(right>0&&arr[right]>pivot_Item) right--;
			if(left<right) {
				int temp = arr[right];
				arr[right] = arr[left];
				arr[left] = temp;
			}
		}
		arr[low] = arr[right];
		arr[right] = pivot_Item;
		return right;
	}


3、插入排序
	public void insertSort(int[] arr) {
		int len = arr.length;
		if(len<=1) return;
		for(int i=0;i<len;i++) {
			if(i==0) continue;
			int j=i,temp = arr[j];
			while(j-1>=0&&temp<arr[j-1]) {
				arr[j] = arr[j-1];
				j--;
			}
			arr[j] = temp;
		}
	}


4、希尔排序(优化后的插入排序)
	
	
5、选择排序
	public void selectSort(int[] arr) {
		int len = arr.length;
		if(len<=1) return;
		for(int i=0;i<len;i++) {
			int minIndex = i;//第i个最小值对应的索引
			for(int j=i+1;j<len;j++) {
				if(arr[j]<arr[minIndex]) {
					minIndex = j;
				}
			}
			int temp = arr[i];
			arr[i] = arr[minIndex];
			arr[minIndex] = temp;
		}
	}	
	
6、堆排序	
	public void heapSort(int[] arr) {
		int len = arr.length;
		if(len<=1) return;
		PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>();
		for(int i=0;i<len;i++) {
			priorityQueue.add(arr[i]);
		}
		int k = 0;
		while(!priorityQueue.isEmpty()) {
			arr[k++] = priorityQueue.poll();
		}
	}
	

7、归并排序
	public void mergeSort(int[] arr,int left,int right) {
		if(left>=right) return;
		int mid = (left + right)>>1;
		mergeSort(arr,left,mid);
		mergeSort(arr,mid+1,right);
		merge(arr,left,mid,right);
	}
	
	private void merge(int[] arr, int left, int mid, int right) {
		// TODO Auto-generated method stub
		int[] tempArr = new int[right-left+1];
		int i=left,j=mid+1,k=0;
		while(i<=mid&&j<=right) {
			tempArr[k++] = (arr[i]<arr[j])?arr[i++]:arr[j++];
		}
		while(i<=mid) tempArr[k++] = arr[i++];
		while(j<=right) tempArr[k++] = arr[j++];
		for(int p=0;p<tempArr.length;p++) arr[left+p] = tempArr[p];
	}
	
8、计数排序
	public void countSort(int[] arr) {
		//适用数值范围有限且都为正整数的排序，数值范围不能过大，否则对于空间要求过去庞大
		int len = arr.length;
		int max_size = 1000000;
		if(len<=1) return;
		int[] tempArr = new int[max_size];
		for(int i=0;i<len;i++) {
			tempArr[arr[i]]++;
		}
		int k = 0;
		for(int j=0;j<max_size;j++) {
			while(tempArr[j]>0) {
				arr[k++] = j;
				tempArr[j]--;
			}
		}
	}

9、桶排序


10、基数排序


