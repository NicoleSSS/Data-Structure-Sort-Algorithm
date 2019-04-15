package com.nicole.practice.sort;

/**
 * ��Ŀ����������ϲ���ϰ��
 * ˵������������С���������Ժ������A��B������A��ĩ�����㹻�Ļ��������B��
 * ���дһ����������B�ϲ���A������
 * @author Nicole
 * ���磺
 * ����A��2 4 6 �� �� ��
 * ����B��1 3 5
 * ����A[2]��B[2]�Ƚϣ����ϴ����������A[5],����A��Ϊ2 4 6 �� �� 6
 * ����A[1]��B[2]�Ƚϣ����ϴ����������A[4],����A��Ϊ2 4 6 �� 5 6
 * ����A[1]��B[1]�Ƚϣ����ϴ����������A[3],����A��Ϊ2 4 6 4 5 6
 * ����A[0]��B[1]�Ƚϣ����ϴ����������A[2],����A��Ϊ2 4 3 4 5 6
 * ����A[0]��B[0]�Ƚϣ����ϴ����������A[1],����С����������A[0]
 * ����A��Ϊ1 2 3 4 5 6
 * 
 * �ؼ����Ӻ���ǰ����
 * 
 * 
 */
public class Sort_3_3 {

	public static void main(String[] args) {
		int[] A1 = {1, 2, 3, 4, 5};
		int[] B = {5, 6, 7};
		int n = A1.length;
		int m = B.length;
		int[] A = new int[n + m];
		for(int i = 0; i < n; i++) {
			A[i] = A1[i];
		}
		int[] result = mergeAB(A, B, n, m);
		for(int i = 0; i < result.length; i++) {
			System.out.print(result[i]);
		}
	}
	
	public static int[] mergeAB(int[] A, int[] B, int n, int m) {
		while (m != 0) {
			if (n == 0) {
				A[m - 1] = B[m - 1];
				m--;
			} else {
				A[m + n - 1] = A[n - 1] > B[m - 1] ? A[--n] : B[--m];
			}
		}
		return A;
	}

}
