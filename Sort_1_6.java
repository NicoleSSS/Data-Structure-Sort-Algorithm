package com.nicole.practice.sort;

/**
 * 题目：堆排序
 * @author Nicole
 * 
 * 时间复杂度：O(N*logN)
 * 空间复杂度：O(1)
 * 稳定性：不稳定
 * 解释：n个数排序（0 - （n-1））
 * 1.思想：
 * 第一步：将n个数建成大小为n的大根堆，堆顶（第0个）是整个堆的最大值，
 * 第二步：将堆顶数（第0个）与堆的最后一个数（第n-1）交换，然后把最大值脱离，放在数组中；
 * 第三步：将n-1个数调整为n-1的大根堆，堆顶（第0个）是整个数堆的最大值，
 * 第四步：将堆顶数（第0个）与堆的最后一个数（第n-2）交换，然后把最大值脱离，放在数组的前面；
 * ……
 * 当进行到最后一个数都放在数组中时，排序结束
 */

public class Sort_1_6 {

	public static void main(String[] args) {
		int[] data= {1,2,3,5,2,3};
		int n = data.length;
		int[] result = heapSort(data, n);
		for(int i = 0; i < n; i++)
			System.out.print(result[i]);
	}
	
	public static int[] heapSort(int[] A, int n) {
		if (A == null || A.length < 2) {
			return A;
		}
		buildMaxHeap(A,n);
		for(int i = n-1; i >= 1; i--) {
			swap(0, i, A);
			adjustMaxHeap(A, i, 0);
		}
		return A;
    }
	
	
	public static void buildMaxHeap(int[] a, int n) {
		int mid = n / 2;
		for(int i = mid; i >= 0; i--) {
			adjustMaxHeap(a, n, i);
		}
	}


	public static void adjustMaxHeap(int[] a, int heapSize, int index) {
		int left = index *2 + 1;
		int right = index *2 +2;
		int maxTemp = index;
		if(left < heapSize && a[left]> a[maxTemp]) {
			maxTemp = left;
		}
		
		if(right < heapSize && a[right]> a[maxTemp]) {
			maxTemp = right;
		}
		
		if(maxTemp != index) {
			swap(maxTemp, index, a);
			adjustMaxHeap(a, heapSize, maxTemp);
		}
	}

	public static void swap(int i, int j, int[] arr) {
		  int t = arr[i];
		  arr[i] = arr[j];
		  arr[j] = t;
	}

}
