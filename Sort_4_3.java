package com.nicole.practice.sort;


/**
 * ��Ŀ�������������ϰ��
 * ˵��������һ�����飬�����һ����Ч�㷨������Ҫ��������������ĳ��ȡ�
 * ����һ��int����A������Ĵ�Сn���뷵��һ����Ԫ�飬�����������еĳ��ȡ�
 * (ԭ����λ�ô�0��ʼ���,��ԭ�������򣬷���0)��
 * ��֤A��Ԫ�ؾ�Ϊ��������
 * @author Nicole
 * ���Ž⣺
 * ʱ�临�Ӷȣ�O(N)
 * ����ռ临�Ӷȣ�O(1)
 * ���ͣ�n������0 - ��n-1����
 * ��һ���������ұ�����������һ������max��¼���������ֵ����ֵ
 * �ڶ��������max���ڵ�ǰ������¼�����ֵ��λ��m1������������
 * �����������max���ڵ�ǰ��������m1��ֱ��maxС�ڵ��ڵ�ǰ����
 * ���Ĳ������ҵ��ұ�����������һ������min��¼���������ֵ���Сֵ
 * ���岽�����minС�ڵ�ǰ������¼�����ֵ��λ��m2������������
 * �����������minС�ڵ�ǰ��������m2��ֱ��min���ڵ��ڵ�ǰ��
 * ���߲���m2��m1�ķ�Χ���������������ĳ���
 * 
 * 
 */
public class Sort_4_3 {

	public static void main(String[] args) {
		int[] data = {1,4,6,5,9,10};
		int n = data.length;
		int len = shortestSubsequence(data, n);
		System.out.println(len);
	}
	
	public static int shortestSubsequence(int[] A, int n) {
		int m1 = 0, m2 = 0;
		int max = 0,min = n - 1;
		for(int i = 0; i < n; i++) {
			if(A[i] > A[max]) {
				max = i;
			}else if(A[i] < A[max]) {
				m1 = i;
			}
		}
		for(int j = n-1; j >= 0; j--) {
			if(A[j] < A[min]) {
				min = j;
			}else if(A[j] > A[min]) {
				m2 = j;
			}
		}
		if(m1 - m2 == 0) {
			return 0;
		}else 
			return m1-m2 + 1;
    }

}
