package com.nicole.practice.sort;

/**
 * 题目：选择排序
 * @author Nicole
 * 
 * 时间复杂度：O(n^2)
 * 空间复杂度：复杂度：O(1)
 * 稳定性：不稳定
 * 解释：n个数排序（0 - （n-1））
 * 在（0 - （n-1））范围中，选出一个最小值第k个，与第0个数交换
 * 在（1 - （n-1））范围中，选出一个最小值第k个，与第1个数交换
 * ……
 * 当进行到第n-1个数，排序完成
 */
public class Sort_1_2 {

	public static void main(String[] args) {
		
		int[] data= {1,2,3,5,2,3};
		int n = data.length;
		int[] result = selectionSort2(data,n);
		for(int i = 0; i < n; i++)
			System.out.print(result[i]);
	}

	/**
	 * 方法一：
	 * @param data
	 * @param n
	 * @return
	 */
	public static int[] selectionSort(int[] data, int n) {
		if (data == null || data.length < 2) {
			return data;
		}
		for(int i = 0; i < n; i++) {
			int temp = i;
			for(int j = i+1; j < n; j++) {
				if(data[j] < data[temp]) {
					temp = j;
				}
			}
			if(temp != i) {
				swap(temp, i, data);
			}
		}
		return data;
	}
	
	/**
	 * 方法二：二元选择排序
	 * @param data
	 * @param n
	 * @return
	 */
	public static int[] selectionSort2(int[] data, int n) {
		for(int i = 0; i < n/2; i++) {
			int maxIndex = n-1-i;
			int minIndex = i;
			int minOrign = maxIndex;
			for(int j = i+1; j < n-i; j++) {
				if(data[minIndex] > data[j]) {
					minIndex = j;
				}
				if(data[maxIndex] < data[n-1-j]) {
					maxIndex = n-1-j;
				}
			}
			if(minIndex != i) {
				swap(i, minIndex, data);
				if(i == maxIndex || i == n-1) {
					maxIndex = minIndex;
				}
			}
			if(minOrign != maxIndex) {
				swap(minOrign, maxIndex, data);
			}
		}
		return data;
	}
	
	
	public static void swap(int i, int j, int[] arr) {
		  int t = arr[i];
		  arr[i] = arr[j];
		  arr[j] = t;
	}
	
}
