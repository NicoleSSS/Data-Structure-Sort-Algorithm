package com.nicole.practice.sort;

/**
 * 题目：冒泡排序
 * @author Nicole
 * 
 * 时间复杂度：O(n^2)
 * 空间复杂度：复杂度：O(1)
 * 稳定性：稳定
 * 解释：n个数排序（0 - （n-1））
 * 在（0 - （n-1））范围中，从第0个数开始，两两比较，最大数放在最后第n-1位置上；
 * 在（0 - （n-2））范围中，从第0个数开始，两两比较，最大数放在最后第n-2位置上；
 * ……
 * 当进行到第0个数时，排序完成
 */
public class Sort_1_1 {

	public static void main(String[] args) {
		
		int[] data= {1,2,3,5,2,3};
		int n = data.length;
		int[] result = bubbleSort(data,n);
		for(int i = 0; i < n; i++)
			System.out.print(result[i]);
	}
	
	public static int[] bubbleSort(int[] A, int n) {
        // write code here
		if (A == null || A.length < 2) {
			return A;
		}
		for(int i = 0;i < n; i++){
            for(int j = 1; j < n-i; j++){
                if(A [j-1] > A [j]){
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
