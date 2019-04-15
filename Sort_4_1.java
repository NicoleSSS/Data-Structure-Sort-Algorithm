package com.nicole.practice.sort;

/**
 * ��Ŀ����ɫ������ϰ�⣨�����������⣩��
 * ˵������һ��ֻ��0��1��2����Ԫ�ع��ɵ��������飬
 * ��ʹ�ý�����ԭ�����������ʹ�ü�����������
 * ����һ��ֻ��0��1��2����������A�����Ĵ�С��
 * �뷵�����������顣��֤�����СС�ڵ���500��
 * @author Nicole
 * 
 * ʱ�临�Ӷȣ�O(N)
 * �ռ临�Ӷȣ�O(1)
 * ���ͣ�n��������0 - ��n-1����
 * ��һ���������������ߣ�-1��λ�ã�����һ������0������Ϊ0��
 * ����������ұߣ�n��λ�ã�����һ������2������Ϊ0
 * �ڶ������������ұ������飬
 * 		�����һ��ֵΪ0��������0�����ƶ�һλ��
 * 		�����һ��ֵΪ1���������ұ�����
 * 			�����kλΪ0���򽻻���0λ�͵�kλ��ֵ������0�����ƶ�һλ��
 * 			�����kΪΪ0���򽻻���kΪ�͵�n-1λ��ֵ������2�����ƶ�һλ��
 * 		�����һ��ֵΪ2���򽻻���0λ�ڵ�n-1λ��ֵ������2�����ƶ�һλ��
 * �������������������
 * ����
 * ����ǰλ��������2��λ���غ�ʱ���������
 */
public class Sort_4_1 {

	public static void main(String[] args) {
		int[] A = {0, 1, 1, 0, 2, 2};
		int n = A.length;
		int[] result = sortThreeColor(A, n);
		for(int i = 0; i < result.length; i++) {
			System.out.print(result[i]);
		}
	}
	
	public static int[] sortThreeColor(int[] A, int n) {
		if(A == null || n < 2) {
			return A;
		}
		
		int left = -1;
		int right = n;
		int index = 0;
		while(index < right) {
			if(A[index] == 0) {
				swap(++left, index++, A);
			}else if(A[index]==2) {
				swap(index, --right, A);
			}else {
				index ++;
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
