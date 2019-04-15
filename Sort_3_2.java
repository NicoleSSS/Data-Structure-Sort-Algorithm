package com.nicole.practice.sort;

/**
 * 题目：重复值判断练习题
 * 说明：请设计一个高效算法，判断数组中是否有重复值。
 * 必须保证额外空间复杂度为O(1)。
 * @author Nicole
 * 分析：
 * 1.如果没有空间复杂度限制，用哈希表实现（时间复杂度O(N)，空间复杂度O(N)）
 * 2.先排序、然后判断
 * 3.选择——堆排序，
 * 但是不用递归的方式——空间复杂度O(logN)，使用到了函数栈，函数栈的大小是堆的层数）
 * 使用不用递归的堆排序
 */
public class Sort_3_2 {

	public static void main(String[] args) {
		int[] data= {1,2,3,4,5,5,6};
		int n = data.length;
		boolean isDuplicate = checkDuplicate(data, n);
		System.out.print(isDuplicate);
	}
	
	public static boolean checkDuplicate(int[] a, int n) {
		if(a == null || a.length == 0) {
			return false;
		}
		heapSort(a);//先进行堆排序
		for(int i = 1; i < n; i++) {
			if(a[i] == a[i - 1]) {
				return true;
			}
		}
		return false;
	}

	public static void heapSort(int[] a) {
		for(int i = 0; i != a.length; i++) {
			heapInsert(a, i);
		}
		for(int i = a.length - 1; i != 0; i--) {
			swap(0, i, a);
			heapify(a, 0, i);
		}
	}
	
	public static void heapInsert(int[] heap, int index) {
		while(index != 0) {
			int parent = (index -1) / 2;
			if(heap[parent] < heap[index]) {
				swap(parent, index, heap);
				index = parent;
			}else {
				break;
			}
		}
	}
	
	public static void heapify(int[] a, int index, int heapSize) {
		int left = index * 2 + 1;
		int right = index * 2 + 2;
		int tempIndex = index;
		while(left < heapSize) {
			if(a[left] > a[index]) {
				tempIndex = left;
			}
			if(right < heapSize && a[right] > a[tempIndex]) {
				tempIndex = right;
			}
			if(tempIndex != index) {
				swap(tempIndex, index, a);
			}else {
				break;
			}
			index = tempIndex;
			left = index * 2 + 1;
			right = index * 2 +2;
		}
	}
	
	public static void swap(int i, int j, int[] arr) {
		  int t = arr[i];
		  arr[i] = arr[j];
		  arr[j] = t;
	}

}
