package com.nicole.practice.sort;

/**
 * 题目：有序数组合并练习题
 * 说明：有两个从小到大排序以后的数组A和B，其中A的末端有足够的缓冲空容纳B。
 * 请编写一个方法，将B合并入A并排序。
 * @author Nicole
 * 例如：
 * 数组A：2 4 6 □ □ □
 * 数组B：1 3 5
 * 首先A[2]和B[2]比较，将较大的数拷贝到A[5],数组A变为2 4 6 □ □ 6
 * 接着A[1]和B[2]比较，将较大的数拷贝到A[4],数组A变为2 4 6 □ 5 6
 * 接着A[1]和B[1]比较，将较大的数拷贝到A[3],数组A变为2 4 6 4 5 6
 * 接着A[0]和B[1]比较，将较大的数拷贝到A[2],数组A变为2 4 3 4 5 6
 * 接着A[0]和B[0]比较，将较大的数拷贝到A[1],将较小的数拷贝到A[0]
 * 数组A变为1 2 3 4 5 6
 * 
 * 关键：从后往前覆盖
 * 
 * 
 */
public class Sort_3_3 {

	public static void main(String[] args) {
		int[] A1 = {1, 2, 3, 4, 5};
		int[] B = {5, 6, 7};
		int n = A1.length;
		int m = B.length;
		int[] A = new int[n + m];
		for(int i = 0; i < n; i++) {
			A[i] = A1[i];
		}
		int[] result = mergeAB(A, B, n, m);
		for(int i = 0; i < result.length; i++) {
			System.out.print(result[i]);
		}
	}
	
	public static int[] mergeAB(int[] A, int[] B, int n, int m) {
		while (m != 0) {
			if (n == 0) {
				A[m - 1] = B[m - 1];
				m--;
			} else {
				A[m + n - 1] = A[n - 1] > B[m - 1] ? A[--n] : B[--m];
			}
		}
		return A;
	}

}
