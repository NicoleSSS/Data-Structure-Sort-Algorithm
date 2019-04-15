package com.nicole.practice.sort;


/**
 * 题目：最短子数组练习题
 * 说明：对于一个数组，请设计一个高效算法计算需要排序的最短子数组的长度。
 * 给定一个int数组A和数组的大小n，请返回一个二元组，代表所求序列的长度。
 * (原序列位置从0开始标号,若原序列有序，返回0)。
 * 保证A中元素均为正整数。
 * @author Nicole
 * 最优解：
 * 时间复杂度：O(N)
 * 额外空间复杂度：O(1)
 * 解释：n个数（0 - （n-1））
 * 第一步：从左到右遍历，单独用一个变量max记录遍历过部分的最大值
 * 第二步：如果max大于当前数，记录下这个值的位置m1，继续遍历，
 * 第三步：如果max大于当前数，更新m1，直到max小于等于当前数；
 * 第四步：从右到右遍历，单独用一个变量min记录遍历过部分的最小值
 * 第五步：如果min小于当前数，记录下这个值的位置m2，继续遍历，
 * 第六步：如果min小于当前数，更新m2，直到min大于等于当前数
 * 第七步：m2到m1的范围，就是最短子数组的长度
 * 
 * 
 */
public class Sort_4_3 {

	public static void main(String[] args) {
		int[] data = {1,4,6,5,9,10};
		int n = data.length;
		int len = shortestSubsequence(data, n);
		System.out.println(len);
	}
	
	public static int shortestSubsequence(int[] A, int n) {
		int m1 = 0, m2 = 0;
		int max = 0,min = n - 1;
		for(int i = 0; i < n; i++) {
			if(A[i] > A[max]) {
				max = i;
			}else if(A[i] < A[max]) {
				m1 = i;
			}
		}
		for(int j = n-1; j >= 0; j--) {
			if(A[j] < A[min]) {
				min = j;
			}else if(A[j] > A[min]) {
				m2 = j;
			}
		}
		if(m1 - m2 == 0) {
			return 0;
		}else 
			return m1-m2 + 1;
    }

}
