package com.nicole.practice.sort;

/**
 * 题目：相邻两数最大差值练习题
 * 说明：有一个整形数组A，请设计一个复杂度为O(n)的算法，算出排序后相邻两数的最大差值。
 * 给定一个int数组A和A的大小n，请返回最大的差值。
 * 保证数组元素多于1个。
 * @author Nicole
 * 时间复杂度：O(N)
 * 额外空间复杂度：O(1)
 * 思想：桶排序
 * 解释：n个数（0 - （n-1））
 * 第一步：遍历数组，找到数组中的最小值min和最大值max
 * 第二步：根据数组长度n，将[min,max)分为n个等量区间，每个区间对应一个桶，
 * 第三步：将元素入桶，并将最大值放在n+1号桶中（桶值为max）
 * 因为第一个桶中必然有min，第n+1个桶中有max，中间的桶必然存在空桶
 * 又因为同一个桶中数的差值不会大于区间长度，所以不用考虑同一个桶的相邻数，只用考虑桶间的相邻数
 * 第四步：对于桶中的值，从左到右来看，只需要考虑每个桶的最小值和上一个非空桶的最大值的差值k，并记录下来
 * 第五步：如果差值大于k，就不断更新，直到最后一个值，结束
 */
public class Sort_4_4 {

	public static void main(String[] args) {
		int[] data = {1, 2, 5, 4, 6};
		int n = data.length;
		int gap = maxGap(data, n);
		System.out.println(gap);
		
		
	}
	
	public static int maxGap(int[] A, int n) {
		if (A == null || A.length < 2) {
			return 0;
		}
		
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		for(int i = 0; i < n; i++) {
			min = Math.min(min, A[i]);
			max = Math.max(max, A[i]);
		}
		if(min == max) {
			return 0;
		}
		
		boolean[] hasA = new boolean[n + 1];
		int[] maxs = new int[n + 1];
		int[] mins = new int[n + 1];
		int index = 0;
		for(int i = 0; i < n; i++) {
			index = bucket(A[i], n, min, max);
			mins[index] = hasA[index] ? Math.min(mins[index], A[i]) : A[i];
			maxs[index] = hasA[index] ? Math.max(maxs[index], A[i]) : A[i];
			hasA[index] = true;
		}
		
		int res = 0;
		int lastMax = 0;
		int i = 0;
		while(i <= n) {
			if(hasA[i++]) {
				// 找到第一个不空的桶
				lastMax = maxs[i-1];
				break;
			}
		}
		for(; i <= n; i++) {
			if(hasA[i]) {
				res = Math.max(res, mins[i] - lastMax);
				lastMax = maxs[i];
			}
		}
		
		return res;
		
	}
	// 使用long类型是为了防止相乘时溢出
	public static int bucket(long nums, long n, long min, long max) {
		return (int) ((nums - min) * n / (max - min));
	}
	

}
