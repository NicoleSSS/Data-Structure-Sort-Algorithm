package com.nicole.practice.sort;

/**
 * 题目：三色排序练习题（荷兰国旗问题）：
 * 说明：有一个只由0，1，2三种元素构成的整数数组，
 * 请使用交换、原地排序而不是使用计数进行排序。
 * 给定一个只含0，1，2的整数数组A及它的大小，
 * 请返回排序后的数组。保证数组大小小于等于500。
 * @author Nicole
 * 
 * 时间复杂度：O(N)
 * 空间复杂度：O(1)
 * 解释：n个数排序（0 - （n-1））
 * 第一步：在数组的最左边（-1的位置）设立一个区间0，长度为0，
 * 在数组的最右边（n的位置）设立一个区间2，长度为0
 * 第二步：从左向右遍历数组，
 * 		如果第一个值为0，则区间0向右移动一位；
 * 		如果第一个值为1，继续向右遍历，
 * 			如果第k位为0，则交换第0位和第k位的值，区间0向右移动一位；
 * 			如果第k为为0，则交换第k为和第n-1位的值，区间2向左移动一位；
 * 		如果第一个值为2，则交换第0位于第n-1位的值，区间2相左移动一位；
 * 第三步：继续向左遍历
 * ……
 * 当当前位置与区间2的位置重合时，排序结束
 */
public class Sort_4_1 {

	public static void main(String[] args) {
		int[] A = {0, 1, 1, 0, 2, 2};
		int n = A.length;
		int[] result = sortThreeColor(A, n);
		for(int i = 0; i < result.length; i++) {
			System.out.print(result[i]);
		}
	}
	
	public static int[] sortThreeColor(int[] A, int n) {
		if(A == null || n < 2) {
			return A;
		}
		
		int left = -1;
		int right = n;
		int index = 0;
		while(index < right) {
			if(A[index] == 0) {
				swap(++left, index++, A);
			}else if(A[index]==2) {
				swap(index, --right, A);
			}else {
				index ++;
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
