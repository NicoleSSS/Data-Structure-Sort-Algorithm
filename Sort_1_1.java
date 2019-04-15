package com.nicole.practice.sort;

/**
 * ��Ŀ��ð������
 * @author Nicole
 * 
 * ʱ�临�Ӷȣ�O(n^2)
 * �ռ临�Ӷȣ����Ӷȣ�O(1)
 * �ȶ��ԣ��ȶ�
 * ���ͣ�n��������0 - ��n-1����
 * �ڣ�0 - ��n-1������Χ�У��ӵ�0������ʼ�������Ƚϣ��������������n-1λ���ϣ�
 * �ڣ�0 - ��n-2������Χ�У��ӵ�0������ʼ�������Ƚϣ��������������n-2λ���ϣ�
 * ����
 * �����е���0����ʱ���������
 */
public class Sort_1_1 {

	public static void main(String[] args) {
		
		int[] data= {1,2,3,5,2,3};
		int n = data.length;
		int[] result = bubbleSort(data,n);
		for(int i = 0; i < n; i++)
			System.out.print(result[i]);
	}
	
	public static int[] bubbleSort(int[] A, int n) {
        // write code here
		if (A == null || A.length < 2) {
			return A;
		}
		for(int i = 0;i < n; i++){
            for(int j = 1; j < n-i; j++){
                if(A [j-1] > A [j]){
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
