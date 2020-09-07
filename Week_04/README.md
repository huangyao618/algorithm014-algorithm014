学习笔记

BFS和DFS:
	DFS有两种实现方式，一个是利用递归的底层的java虚拟机栈（方法的调用和返回，对应栈帧元素的入栈和出栈）去实现遍历（搜索），另一个是手动的去维护一个栈数据结构，实现遍历。
	BFS主要是利用队列数据结构实现一个遍历和搜索。

贪心算法：
	提供了一个局部最优解的求解方式，有时它可以单纯的用来求解全局最优解，这时候往往是比较高效的;但更多的时候用来辅助某一个步的决策，然后利用搜索、回溯来寻找全局的最优解或更大范围内的
 的最优解已获得一个全局最优解。

二分法：
	提供一个不需要遍历所有元素，可以在log(n）的时间复杂度内求解问题的方法；但其需要具备以下条件：元素是有序排列的，数据是有界的，可以使用索引任意访问。

使用二分查找，寻找一个半有序数组 [4, 5, 6, 7, 0, 1, 2] 中间无序的地方：
	思考：数组可以分为两个部分，可以在坐标轴中形象的描绘出来观察，mid ，left，right的区别；
		一：向后收缩的条件（旋转轴在left左侧）
			a、nums[mid] > nums[right]   --->mid和right分别位于轴点的两侧，mid位于轴的左侧，那么left就向后移动 left = mid + 1
	        二、向前收缩的条件
			a、如果nums[mid] <= nums[right] --->mid和right位于轴的同侧，即右侧，那么是right = mid + 1?.当然不是，因为存在mid就是轴点的情况，这样就把轴点排除
			在查找范围，所以right = mid，但这时我们要考虑循环查找的条件不能为left<=right,而是left<right,不然循环可能退不出来。
		三、存在提前结束的条件，即存在nums[mid]>nums[mid+1]，那么第一个出现此条件的点就是轴点。

代码:
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while(left < right) {
            int mid = left + (right - left)/2;
            if(mid+1<nums.length&&nums[mid]>nums[mid+1]) {
                return mid+1;
            }
            if(nums[mid]>nums[right]) {
                left = mid + 1;
            }else {
                right = mid;//当mid恰好是分界线时，right = mid -1 会导致错误结果
            }
        }
        return left;//存在没有旋转依然处于升序的情况       
    }