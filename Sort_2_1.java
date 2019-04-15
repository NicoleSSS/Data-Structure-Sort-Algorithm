package com.nicole.practice.sort;

/**
 * ��Ŀ����������
 * @author Nicole
 * 
 * ʱ�临�Ӷȣ�O(N)
 * �ռ临�Ӷȣ�O(M)����M��ʾѡ��Ͱ������
 * �ȶ��ԣ��ȶ�
 * ���ͣ�n��������0 - ��n-1����
 * ��һ�����ҵ�һ�������е���Сֵ�����ֵ��
 * �ڶ������������ֵ����Сֵ�ľ����½�k��Ͱ��
 * �������������е��������Ӧ��Ͱ�У�
 * ���Ĳ����ӵ�һ��Ͱ��ʼ����ȡ��ֵ�������е�Ͱ��ȡ�꣬���������
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
