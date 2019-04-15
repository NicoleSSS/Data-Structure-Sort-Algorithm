package com.nicole.practice.sort;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * ��Ŀ����������
 * @author Nicole
 * 
 * ʱ�临�Ӷȣ�O(N)
 * �ռ临�Ӷȣ�O(M)����M��ʾѡ��Ͱ������
 * �ȶ��ԣ��ȶ�
 * ���ͣ�n��������0 - ��n-1����
 * ��һ��������׼��10��Ͱ��Ͱ���Ϊ0-9��
 * �ڶ�������ԭ���С�0��ÿ�����������λ��ֵk1�������Ӧ��k1��Ͱ��
 * �����������δ�0��Ͱ��9��Ͱ���������е��������һ�����С�1����
 * ���Ĳ����������С�1��ÿ����������ʮλ��ֵk2�������Ӧ��k2��Ͱ��
 * ����
 * ���������λ����Ͱ��������֮���������
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
