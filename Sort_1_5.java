package com.nicole.practice.sort;

/**
 * ��Ŀ����������
 * @author Nicole
 * 
 * ʱ�临�Ӷȣ�O(N*logN)
 * �ռ临�Ӷȣ�O(logN)~O(N)
 * �ȶ��ԣ����ȶ�
 * ���ͣ�n��������0 - ��n-1����
 * 1.˼�룺
 * ��һ�����������������ѡ��һ����m����k���������������Ϊ�ֽ��ߣ�
 * ��ԭ����С�ڵ�����m�ķ������������ߣ�������m�ķ�����������ұߣ�
 * �ڶ���������m�������������֣����ϣ��ֱ�ݹ���ÿ�������Ĺ���
 * ����
 * ���ݹ��꣬������ɡ�
 * 2.���岽�裺
 * ��һ����ѡ��һ������ֵ��m����k����������������n-1��������λ�ã�
 * �ڶ��������һ����С�ڵ������䡱����ʼֵΪ0�����������Ӧ�������ɣ�����Ӧ���ڷ��ڵ�-1��λ���ϣ���
 * �������ұ������飬�����ǰ��ֵ����i�������ڻ���ֵ������������
 * �����ǰֵ����i����С�ڵ��ڻ���ֵ���ͽ����i�����롰С�ڵ������䡱�ĺ�һ��������λ�ã�
 * Ȼ���á�С�ڵ�����������Ųһ��λ�á�
 * �����������ű�����i+1������ִ����ڶ�����ͬ�Ĳ���
 * ����
 * ������е����һ����m����n-1�����ͽ���m�롰С�ڵ������䡱�ĺ�һ��������λ�ã�һ�ε�����ɡ�
 * �����ֱַ�ݹ���������㷨
 * ����
 * �ݹ���ɣ�������ɡ�
 */
public class Sort_1_5 {

	public static void main(String[] args) {
		int[] data= {1,2,3,5,2,3};
		int n = data.length;
		int[] result = quickSort(data, n);
		for(int i = 0; i < n; i++)
			System.out.print(result[i]);
	}
	
	public static int[] quickSort(int[] A, int n) {
		if (A == null || A.length < 2) {
			return A;
		}
		sort(A, 0, n-1);
		return A;
    }

	public static void sort(int[] a, int left, int right) {
		if(left < right) {
			int random = left + (int)(Math.random() * (right - left + 1)); //���ѡ��һ������Ϊ�ֽ�ֵ
			swap(random, right, a);					//��������ֽ�ֵ�����һ����
			int mid = partition(a, left, right);	//�ƶ�С�ڵ�������
			sort(a, left, mid - 1);					//�ݹ�
			sort(a, mid + 1, right);
		}
	}
	
	public static int partition(int[] a, int left, int right) {
		int temp = left -1;
		int index = left;
		while (index <= right) {
			if (a[index] <= a[right]) {
				swap(++temp, index, a);
			}
			index++;
		}
		return temp;
	}

	public static void swap(int i, int j, int[] arr) {
		  int t = arr[i];
		  arr[i] = arr[j];
		  arr[j] = t;
	}

}
