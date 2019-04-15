package com.nicole.practice.sort;

/**
 * ��Ŀ��С��Χ������ϰ��
 * ˵������֪һ��������������飬����������ָ������������ź�˳��Ļ���
 * ÿ��Ԫ���ƶ��ľ�����Բ�����k������k�����������˵�Ƚ�С��
 * ��ѡ��һ�����ʵ������㷨���������ݽ�������
 * @author Nicole
 * ������
 * 1.ʱ�临�Ӷ�ΪO(N)���㷨���������򡢻�������
 * ���������ڱȽϵ������㷨�����ƣ����������е����
 * ���������ﲢ��֪������ķ�Χ���ų�
 * 2.ʱ�临�Ӷ�ΪO(N^2)���㷨��ð������ѡ������
 * ���������������㷨������ԭʼ�����޹أ��ų�
 * 3.ʱ�临�Ӷ�ΪO(N^2)���㷨����������
 * ������������Ĺ�����ԭʼ˳���йأ�ÿ��Ԫ���ƶ����벻����k
 * ���������ʱ�临�Ӷ�ΪO(N*k)
 * 4.ʱ�临�Ӷ�ΪO(N*logN)���㷨���������򡢹鲢����
 * ����������ԭʼ˳���޹أ��ų�
 * 5.�𰸣��Ľ���Ķ�����
 * ����ÿ�õ�һ����O(logk)
 * ��һ���������������СֵӦ����a[0]-a[k-1]�ϣ�����a[0]-a[k-1]��k�������һ��С���ѣ��Ѷ�����Сֵ��
 * �ڶ��������Ѷ�������������ԭ�����λ��0�ϣ�
 * ����������a[k]����С���ѵĶѶ�������С���ѣ��Ѷ��ǵڶ�Сֵ��
 * ���Ĳ������Ѷ�������������ԭ�����λ��1�ϣ�
 * ����
 * ���һ�������������������
 */
public class Sort_3_1 {

	public static void main(String[] args) {
		
		int[] data= {2,1,4,3,6,5,8,7,10,9};
		int n = data.length;
		int k = 2;
		int[] result = sortElement(data, n, k);
		for(int i = 0; i < n; i++)
			System.out.print(result[i]);
	}
	
	public static int[] sortElement(int[] A, int n, int k) {
		if (A == null || A.length == 0 || n < k) {
			return A;
		}
		int[] heap = getKHeap(A, k);
		for(int i = k; i < n; i++) {
			A[i-k] = heap[0];
			heap[0] = A[i];
			heapify(heap, 0, k);
		}
		for(int i = n - k; i < n; i++) {
			A[i] = heap[0];
			swap(0, k-1, heap);
			heapify(heap, 0, --k);
		}
		return A;
    }
	
	public static int[] getKHeap(int[] A, int k) {
		int[] heap = new int[k];
		for(int i = 0; i < k; i++) {
			heapInsert(heap, A[i], i);
		}
		return heap;
	}

	public static void heapInsert(int[] heap, int value, int index) {
		heap[index] = value;
		while(index != 0) {
			int parent = (index -1) / 2;
			if(heap[parent] > heap[index]) {
				swap(parent, index, heap);
				index = parent;
			}else {
				break;
			}
		}
	}
	
	public static void heapify(int[] a, int index, int heapSize) {
		int left = index * 2 + 1;
		int right = index * 2 + 2;
		int tempIndex = index;
		while(left < heapSize) {
			if(a[left] < a[index]) {
				tempIndex = left;
			}
			if(right < heapSize && a[right] < a[tempIndex]) {
				tempIndex = right;
			}
			if(tempIndex != index) {
				swap(tempIndex, index, a);
			}else {
				break;
			}
			index = tempIndex;
			left = index * 2 + 1;
			right = index * 2 +2;
		}
	}
	
	public static void swap(int i, int j, int[] arr) {
		  int t = arr[i];
		  arr[i] = arr[j];
		  arr[j] = t;
	}

}
