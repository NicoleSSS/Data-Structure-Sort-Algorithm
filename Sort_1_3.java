package com.nicole.practice.sort;

/**
 * ��Ŀ����������
 * @author Nicole
 * 
 * ʱ�临�Ӷȣ�O(n^2)
 * �ռ临�Ӷȣ����Ӷȣ�O(1)
 * �ȶ��ԣ��ȶ�
 * ���ͣ�n��������0 - ��n-1����
 * ��һ������1�������0�����Ƚϣ������1������С���ͽ���������
 * �ڶ�������2�������1�����Ƚϣ������2������С���ͽ���������
 * �������0�����Ƚϣ������0������С���ͽ���������
 * ����������3�������2�����Ƚϣ������3������С���ͽ���������
 * �������1�����Ƚϣ������1������С���ͽ���������
 * �������0�����Ƚϣ������0������С���ͽ���������
 * ����
 * �����е����һ����ʱ���������
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
