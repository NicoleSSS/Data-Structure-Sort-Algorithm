package com.nicole.practice.sort;

/**
 * ��Ŀ��ϣ�����򡪡��ؼ���������ѡ��
 * @author Nicole
 * 
 * ʱ�临�Ӷȣ�O(N*logN)
 * �ռ临�Ӷȣ�O(1)
 * �ȶ��ԣ����ȶ�
 * ���ͣ�n��������0 - ��n-1����
 * 1.˼�룺
 * ��һ����ѡ��һ������k��һ�����1�������粽��Ϊ3
 * �ڶ�������k+1�����������k�����0�������бȽϣ������k+1������С��
 * �ͽ�����������Ϊ����ǰ��k�����½��ˣ�����ֹͣ��
 * ����������k+2�����������k�����1�������бȽϣ������k+2������С��
 * �ͽ�����������Ϊ����ǰ��k�����½��ˣ�����ֹͣ��
 * ����
 * ���ȽϽ��е���n-1����ʱ����һ�ֱȽ�ֹͣ�����Ĳ���Ϊk-1�����粽������Ϊ2
 * ��i�����ظ�����ĵڶ�������������������ע�⣺k��Ϊ��k-1��
 * ����
 * ���ȽϽ��е���n-1����ʱ���ڶ��ֱȽ�ֹͣ�����Ĳ���Ϊk-2�����粽������Ϊ1
 * ��j�����ظ�����ĵڶ�������������������ע�⣺k��Ϊ��k-2��
 * ����
 * ���ȽϽ��е���n-1����ʱ�������ֱȽ�ֹͣ�����k=1��ֹͣ�����������
 * ���k>1,��k=k-1�������ظ��ڶ���������������
 * ����
 * ֱ��k=1���ҽ��е���n-1����ʱ����������ֹͣ��������ɡ�
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
