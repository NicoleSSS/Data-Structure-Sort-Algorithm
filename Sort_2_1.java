package com.nicole.practice.sort;

/**
 * 题目：计数排序
 * @author Nicole
 * 
 * 时间复杂度：O(N)
 * 空间复杂度：O(M)——M表示选择桶的数量
 * 稳定性：稳定
 * 解释：n个数排序（0 - （n-1））
 * 第一步：找到一个数组中的最小值和最大值；
 * 第二步：根据最大值到最小值的距离新建k个桶；
 * 第三步：将所有的数放入对应的桶中；
 * 第四步：从第一个桶开始依次取出值，当所有的桶都取完，则排序结束
 */
public class Sort_2_1 {

	public static void main(String[] args) {
		int[] data= {1,2,3,5,2,3};
		int n = data.length;
		int[] result = countingSort(data, n);
		for(int i = 0; i < n; i++)
			System.out.print(result[i]);
	}
	
	public static int[] countingSort(int[] A, int n) {
		if (A == null || A.length < 2) {
			return A;
		}
		int min = A[0];
		int max = A[0];
		for(int i = 1; i < n; i++) {
			min = Math.min(A[i], min);
			max = Math.max(A[i], max);
		}
		int[] count = new int[max - min + 1];
		for(int i = 0; i < n; i++) {
			count[A[i] - min]++;
		}
		int index = 0;
		for(int i = 0; i < count.length; i++) {
			while(count[i]-- > 0) {
				A[index++] = i + min;
			}
		}
		return A;
    }

}
