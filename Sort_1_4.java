package com.nicole.practice.sort;

/**
 * 题目：归并排序
 * @author Nicole
 * 
 * 时间复杂度：O(N*logN)
 * 空间复杂度：O(N)
 * 稳定性：稳定
 * 解释：n个数排序（0 - （n-1））
 * 第一步：让数组中的每一个数看成最大长度为1的有序区间，
 * 然后把相邻为1的有序区间进行合并（排序合并），得到最大长度为2的有序区间；
 * 第二步：把相邻为2的有序区间进行合并（排序合并），得到最大长度为4的有序区间；
 * ……
 * 直到让数组中所有的数合并成一个区间
 */
public class Sort_1_4 {

	public static void main(String[] args) {
		
		int[] data= {1,2,3,5,2,3};
		int n = data.length;
		int[] result = mergeSort(data, n);
		for(int i = 0; i < n; i++)
			System.out.print(result[i]);
	}
	
	public static int[] mergeSort(int[] A, int n) {
		if (A == null || A.length < 2) {
			return A;
		}
		//mergeSortUp2Down(A, 0, n-1);
		mergeSortDown2Up(A, n);
		return A;
    }

	/**
	 * 归并排序（从上往下）
	 * @param a：待排序的数组
	 * @param left：数组的起始地址
	 * @param right：数组的结束地址
	 */
	public static void mergeSortUp2Down(int[] a, int left, int right) {
		if(left < right) {
			int mid = (left + right) / 2;
			//分割左边
			mergeSortUp2Down(a, left, mid);
			//分割右边
			mergeSortUp2Down(a, mid+1, right);
			//经过上面的分割，每个数都占一个区间
			System.out.printf("%d-%d-%d",left,mid,right);
			System.out.println();
			merge(a, left, mid, right);
		}
	}

	public static void mergeSortDown2Up(int[] a,int n) {
		for(int gap = 1; gap < n; gap *=2) {
			mergeGroups(a, n, gap);
		}
	}
	
	/**
	 * 对数组a做若干次合并：
	 * 数组a的总长度为len，将它分为若干个长度为gap的子数组；
     * 将"每2个相邻的子数组" 进行合并排序。
	 * @param a
	 * @param len
	 * @param gap
	 */
	public static void mergeGroups(int[] a, int len, int gap) {
		int i;
		int twolen = 2 * gap; // 两个相邻的子数组的长度
		
		// 将"每2个相邻的子数组" 进行合并排序。
		for(i = 0; i + twolen - 1 < len; i += twolen) {
			System.out.printf("%d-%d-%d", i, i+gap-1, i+ twolen -1);
			System.out.println();
			merge(a, i, i+gap-1, i+ twolen -1);
		}
		
		if(i+gap-1 < len-1) {
			System.out.printf("%d-%d-%d", i, i+gap-1, len -1);
			System.out.println();
			merge(a, i, i+gap-1, len-1);
		}
	}
	/**
	 * 讲一个数组中的两个相邻有序区间合并成一个
	 * 
	 * @param a：包含2个有序区间的数组
	 * @param left：第1个有序区间的起始地址
	 * @param mid：第1个有序区间的结束地址 
	 * @param right：第2个有序区间的结束地址
	 */
	public static void merge(int[] a, int left, int mid, int right) {
		int[] temp = new int[right-left+1];		//temp是汇总2个有序区的临时区域
		int leftIndext = left;				//第1个有序区间的索引
		int rightIndex = mid+1;				//第2个有序区间的索引
		int tempIndex = 0;					//临时区域的索引
		while(leftIndext <= mid && rightIndex <= right) {
			if(a[leftIndext] < a[rightIndex]) {
				temp[tempIndex++] = a[leftIndext++];
			}else {
				temp[tempIndex++] = a[rightIndex++];
			}
		}
		
		while(leftIndext <= mid) {
			temp[tempIndex++] = a[leftIndext++];
		}
		
		while(rightIndex <= right) {
			temp[tempIndex++] = a[rightIndex++];
		}
		//将排序后的元素，全部都整合到数组a中
		for(int i = 0; i < temp.length; i++) {
			a[left + i] = temp[i];
		}
	}

}
