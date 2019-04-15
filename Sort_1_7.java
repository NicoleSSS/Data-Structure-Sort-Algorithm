package com.nicole.practice.sort;

/**
 * 题目：希尔排序——关键：步长的选择
 * @author Nicole
 * 
 * 时间复杂度：O(N*logN)
 * 空间复杂度：O(1)
 * 稳定性：不稳定
 * 解释：n个数排序（0 - （n-1））
 * 1.思想：
 * 第一步：选择一个步长k（一般大于1），例如步长为3
 * 第二步：第k+1个数向左边跳k个与第0个数进行比较，如果第k+1个数更小，
 * 就交换两数，因为再向前跳k个就月结了，于是停止。
 * 第三步：第k+2个数向左边跳k个与第1个数进行比较，如果第k+2个数更小，
 * 就交换两数，因为再向前跳k个就月结了，于是停止。
 * ……
 * 当比较进行到第n-1个数时，第一轮比较停止，更改步长为k-1，例如步长调整为2
 * 第i步：重复上面的第二步、第三步、……（注意：k变为了k-1）
 * ……
 * 当比较进行到第n-1个数时，第二轮比较停止，更改步长为k-2，例如步长调整为1
 * 第j步，重复上面的第二步、第三步、——（注意：k变为了k-2）
 * ……
 * 当比较进行到第n-1个数时，第三轮比较停止，如果k=1，停止，排序结束。
 * 如果k>1,则将k=k-1，继续重复第二步、第三步……
 * ……
 * 直到k=1，且进行到第n-1个数时，整个过程停止，排序完成。
 * 
 */
public class Sort_1_7 {

	public static void main(String[] args) {
		int[] data= {1,2,3,5,2,3};
		int n = data.length;
		int[] result = shellSort(data, n);
		for(int i = 0; i < n; i++)
			System.out.print(result[i]);
	}
	
	public static int[] shellSort(int[] A, int n) {
		if (A == null || A.length < 2) {
			return A;
		}
		int mid = n / 2;
		int index = 0;
		while(mid > 0) {
			for(int i = mid; i < n; i++) {
				index = i;
				while(index >= mid) {
					if(A[index - mid] > A[index]) {
						swap(index-mid, index, A);
						index -= mid;
					}else {
						break;
					}
				}
			}
			mid /= 2;
		}
		return A;
		
	}
	
	public static void swap(int i, int j, int[] arr) {
		  int t = arr[i];
		  arr[i] = arr[j];
		  arr[j] = t;
	}

}
