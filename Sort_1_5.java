package com.nicole.practice.sort;

/**
 * 题目：快速排序
 * @author Nicole
 * 
 * 时间复杂度：O(N*logN)
 * 空间复杂度：O(logN)~O(N)
 * 稳定性：不稳定
 * 解释：n个数排序（0 - （n-1））
 * 1.思想：
 * 第一步：随机的再数组中选择一个数m（第k个），以这个数作为分界线，
 * 将原数组小于等于数m的放在这个数的左边，大于数m的放在这个数的右边；
 * 第二步：对数m的左右两个部分（集合）分别递归调用快速排序的过程
 * ……
 * 当递归完，排序完成。
 * 2.具体步骤：
 * 第一步：选择一个划分值数m（第k个），让这个数与第n-1个数交换位置，
 * 第二步：设计一个“小于等于区间”（初始值为0）（这个区间应该是意会吧，区间应该在放在第-1的位置上），
 * 从左至右遍历数组，如果当前数值（第i个）大于划分值，就向后遍历；
 * 如果当前值（第i个）小于等于划分值，就将这第i个数与“小于等于区间”的后一个数交换位置，
 * 然后让“小于等于区间向右挪一个位置”
 * 第三步：接着遍历第i+1个数，执行与第二步相同的操作
 * ……
 * 如果进行到最后一个数m（第n-1），就将数m与“小于等于区间”的后一个数交换位置，一次迭代完成。
 * 两部分分别递归快速排序算法
 * ……
 * 递归完成，排序完成。
 */
public class Sort_1_5 {

	public static void main(String[] args) {
		int[] data= {1,2,3,5,2,3};
		int n = data.length;
		int[] result = quickSort(data, n);
		for(int i = 0; i < n; i++)
			System.out.print(result[i]);
	}
	
	public static int[] quickSort(int[] A, int n) {
		if (A == null || A.length < 2) {
			return A;
		}
		sort(A, 0, n-1);
		return A;
    }

	public static void sort(int[] a, int left, int right) {
		if(left < right) {
			int random = left + (int)(Math.random() * (right - left + 1)); //随机选择一个数作为分界值
			swap(random, right, a);					//交换这个分界值和最后一个数
			int mid = partition(a, left, right);	//移动小于等于区间
			sort(a, left, mid - 1);					//递归
			sort(a, mid + 1, right);
		}
	}
	
	public static int partition(int[] a, int left, int right) {
		int temp = left -1;
		int index = left;
		while (index <= right) {
			if (a[index] <= a[right]) {
				swap(++temp, index, a);
			}
			index++;
		}
		return temp;
	}

	public static void swap(int i, int j, int[] arr) {
		  int t = arr[i];
		  arr[i] = arr[j];
		  arr[j] = t;
	}

}
