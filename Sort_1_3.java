package com.nicole.practice.sort;

/**
 * 题目：插入排序
 * @author Nicole
 * 
 * 时间复杂度：O(n^2)
 * 空间复杂度：复杂度：O(1)
 * 稳定性：稳定
 * 解释：n个数排序（0 - （n-1））
 * 第一步：第1个数与第0个数比较，如果第1个数更小，就交换两数；
 * 第二步：第2个数与第1个数比较，如果第2个数更小，就交换两数，
 * 接着与第0个数比较，如果第0个数更小，就交换两数；
 * 第三步：第3个数与第2个数比较，如果第3个数更小，就交换两数，
 * 接着与第1个数比较，如果第1个数更小，就交换两数，
 * 接着与第0个数比较，如果第0个数更小，就交换两数；
 * ……
 * 当进行到最后一个数时，排序完成
 */
public class Sort_1_3 {

	public static void main(String[] args) {
		
		int[] data= {1,2,3,5,2,3};
		int n = data.length;
		int[] result = insertionSort(data,n);
		for(int i = 0; i < n; i++)
			System.out.print(result[i]);
	}
	
	public static int[] insertionSort(int[] A, int n) {
		if (A == null || A.length < 2) {
			return A;
		}
        for(int i = 1; i < n; i++) {
        	for(int j = i; j > 0 ; j--) {
        		if(A[j-1] > A[j]) {
        			swap(j-1, j, A);
        		}
        	}
        }
		return A;
    }
	
	public static void swap(int i, int j, int[] arr) {
		  int t = arr[i];
		  arr[i] = arr[j];
		  arr[j] = t;
	}

}
