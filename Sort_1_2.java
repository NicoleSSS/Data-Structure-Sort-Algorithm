package com.nicole.practice.sort;

/**
 * ��Ŀ��ѡ������
 * @author Nicole
 * 
 * ʱ�临�Ӷȣ�O(n^2)
 * �ռ临�Ӷȣ����Ӷȣ�O(1)
 * �ȶ��ԣ����ȶ�
 * ���ͣ�n��������0 - ��n-1����
 * �ڣ�0 - ��n-1������Χ�У�ѡ��һ����Сֵ��k�������0��������
 * �ڣ�1 - ��n-1������Χ�У�ѡ��һ����Сֵ��k�������1��������
 * ����
 * �����е���n-1�������������
 */
public class Sort_1_2 {

	public static void main(String[] args) {
		
		int[] data= {1,2,3,5,2,3};
		int n = data.length;
		int[] result = selectionSort2(data,n);
		for(int i = 0; i < n; i++)
			System.out.print(result[i]);
	}

	/**
	 * ����һ��
	 * @param data
	 * @param n
	 * @return
	 */
	public static int[] selectionSort(int[] data, int n) {
		if (data == null || data.length < 2) {
			return data;
		}
		for(int i = 0; i < n; i++) {
			int temp = i;
			for(int j = i+1; j < n; j++) {
				if(data[j] < data[temp]) {
					temp = j;
				}
			}
			if(temp != i) {
				swap(temp, i, data);
			}
		}
		return data;
	}
	
	/**
	 * ����������Ԫѡ������
	 * @param data
	 * @param n
	 * @return
	 */
	public static int[] selectionSort2(int[] data, int n) {
		for(int i = 0; i < n/2; i++) {
			int maxIndex = n-1-i;
			int minIndex = i;
			int minOrign = maxIndex;
			for(int j = i+1; j < n-i; j++) {
				if(data[minIndex] > data[j]) {
					minIndex = j;
				}
				if(data[maxIndex] < data[n-1-j]) {
					maxIndex = n-1-j;
				}
			}
			if(minIndex != i) {
				swap(i, minIndex, data);
				if(i == maxIndex || i == n-1) {
					maxIndex = minIndex;
				}
			}
			if(minOrign != maxIndex) {
				swap(minOrign, maxIndex, data);
			}
		}
		return data;
	}
	
	
	public static void swap(int i, int j, int[] arr) {
		  int t = arr[i];
		  arr[i] = arr[j];
		  arr[j] = t;
	}
	
}
