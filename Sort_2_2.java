package com.nicole.practice.sort;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 题目：基数排序
 * @author Nicole
 * 
 * 时间复杂度：O(N)
 * 空间复杂度：O(M)——M表示选择桶的数量
 * 稳定性：稳定
 * 解释：n个数排序（0 - （n-1））
 * 第一步：首先准备10个桶，桶编号为0-9；
 * 第二步：将原序列【0】每个数按照其个位数值k1，放入对应的k1号桶；
 * 第三步：依次从0号桶到9号桶，倒出所有的数，组成一个序列【1】；
 * 第四步：将新序列【1】每个数按照其十位数值k2，放入对应的k2号桶；
 * ……
 * 当根据最高位进入桶，并倒出之后，排序结束
 * 
 */
public class Sort_2_2 {

	public static void main(String[] args) {
		
		int[] data= {1,2,3,5,2,3};
		int n = data.length;
		int[] result = radixSort(data,n);
		for(int i = 0; i < n; i++)
			System.out.print(result[i]);
	}
	
	public static int[] radixSort(int[] A, int n) {
		if (A == null || A.length < 2) {
			return A;
		}
		int negNum = 0;
		for(int i = 0; i < n; i++) {
			negNum += A[i] < 0 ? 1 : 0;
		}
		
		int[] negA = new int[negNum];
		int[] posA = new int[n-negNum];
		int negi = 0;
		int posi = 0;
		for(int i = 0; i < n; i++) {
			if(A[i] < 0) {
				negA[negi++] = - A[i];
			}else {
				posA[posi++] = A[i];
			}
		}
		
		radixSortForPositive(negA);
		radixSortForPositive(posA);
		int index = 0;
		for(int i = negA.length-1; i >= 0; i--) {
			A[index++] = -negA[i];
		}
		
		for(int i = 0; i < posA.length; i++) {
			A[index++] = posA[i];
		}
		return A;
    }

	public static void radixSortForPositive(int[] a) {
		
		ArrayList<LinkedList<Integer>> q1 = new ArrayList<>();
		ArrayList<LinkedList<Integer>> q2 = new ArrayList<>();
		
		for(int i = 0; i < 10; i++) {
			q1.add(new LinkedList<Integer>());
			q2.add(new LinkedList<Integer>());
		}
		for(int i = 0; i < a.length; i++) {
			q1.get(a[i] % 10).offer(a[i]);
		}
		long base = 10;
		while(base <= Integer.MAX_VALUE) {
			for(int i = 0; i < 10; i++) {
				LinkedList<Integer> queue = q1.get(i);
				while(!queue.isEmpty()) {
					int value = queue.poll();
					q2.get((int)(value/base) % 10).offer(value);
				}
			}
			ArrayList<LinkedList<Integer>> tmp = q1;
			q1 = q2;
			q2 = tmp;
			base *= 10;
		}
		int index = 0;
		for(int i = 0; i < 10; i++) {
			LinkedList<Integer> queue = q1.get(i);
			while (!queue.isEmpty()) {
				a[index++] = queue.poll();
			}
		}
	}

}
