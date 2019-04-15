package com.nicole.practice.sort;

/**
 * ��Ŀ��������
 * @author Nicole
 * 
 * ʱ�临�Ӷȣ�O(N*logN)
 * �ռ临�Ӷȣ�O(1)
 * �ȶ��ԣ����ȶ�
 * ���ͣ�n��������0 - ��n-1����
 * 1.˼�룺
 * ��һ������n�������ɴ�СΪn�Ĵ���ѣ��Ѷ�����0�����������ѵ����ֵ��
 * �ڶ��������Ѷ�������0������ѵ����һ��������n-1��������Ȼ������ֵ���룬���������У�
 * ����������n-1��������Ϊn-1�Ĵ���ѣ��Ѷ�����0�������������ѵ����ֵ��
 * ���Ĳ������Ѷ�������0������ѵ����һ��������n-2��������Ȼ������ֵ���룬���������ǰ�棻
 * ����
 * �����е����һ����������������ʱ���������
 */

public class Sort_1_6 {

	public static void main(String[] args) {
		int[] data= {1,2,3,5,2,3};
		int n = data.length;
		int[] result = heapSort(data, n);
		for(int i = 0; i < n; i++)
			System.out.print(result[i]);
	}
	
	public static int[] heapSort(int[] A, int n) {
		if (A == null || A.length < 2) {
			return A;
		}
		buildMaxHeap(A,n);
		for(int i = n-1; i >= 1; i--) {
			swap(0, i, A);
			adjustMaxHeap(A, i, 0);
		}
		return A;
    }
	
	
	public static void buildMaxHeap(int[] a, int n) {
		int mid = n / 2;
		for(int i = mid; i >= 0; i--) {
			adjustMaxHeap(a, n, i);
		}
	}


	public static void adjustMaxHeap(int[] a, int heapSize, int index) {
		int left = index *2 + 1;
		int right = index *2 +2;
		int maxTemp = index;
		if(left < heapSize && a[left]> a[maxTemp]) {
			maxTemp = left;
		}
		
		if(right < heapSize && a[right]> a[maxTemp]) {
			maxTemp = right;
		}
		
		if(maxTemp != index) {
			swap(maxTemp, index, a);
			adjustMaxHeap(a, heapSize, maxTemp);
		}
	}

	public static void swap(int i, int j, int[] arr) {
		  int t = arr[i];
		  arr[i] = arr[j];
		  arr[j] = t;
	}

}
