package com.nicole.practice.sort;

/**
 * ��Ŀ���ظ�ֵ�ж���ϰ��
 * ˵���������һ����Ч�㷨���ж��������Ƿ����ظ�ֵ��
 * ���뱣֤����ռ临�Ӷ�ΪO(1)��
 * @author Nicole
 * ������
 * 1.���û�пռ临�Ӷ����ƣ��ù�ϣ��ʵ�֣�ʱ�临�Ӷ�O(N)���ռ临�Ӷ�O(N)��
 * 2.������Ȼ���ж�
 * 3.ѡ�񡪡�������
 * ���ǲ��õݹ�ķ�ʽ�����ռ临�Ӷ�O(logN)��ʹ�õ��˺���ջ������ջ�Ĵ�С�ǶѵĲ�����
 * ʹ�ò��õݹ�Ķ�����
 */
public class Sort_3_2 {

	public static void main(String[] args) {
		int[] data= {1,2,3,4,5,5,6};
		int n = data.length;
		boolean isDuplicate = checkDuplicate(data, n);
		System.out.print(isDuplicate);
	}
	
	public static boolean checkDuplicate(int[] a, int n) {
		if(a == null || a.length == 0) {
			return false;
		}
		heapSort(a);//�Ƚ��ж�����
		for(int i = 1; i < n; i++) {
			if(a[i] == a[i - 1]) {
				return true;
			}
		}
		return false;
	}

	public static void heapSort(int[] a) {
		for(int i = 0; i != a.length; i++) {
			heapInsert(a, i);
		}
		for(int i = a.length - 1; i != 0; i--) {
			swap(0, i, a);
			heapify(a, 0, i);
		}
	}
	
	public static void heapInsert(int[] heap, int index) {
		while(index != 0) {
			int parent = (index -1) / 2;
			if(heap[parent] < heap[index]) {
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
			if(a[left] > a[index]) {
				tempIndex = left;
			}
			if(right < heapSize && a[right] > a[tempIndex]) {
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
