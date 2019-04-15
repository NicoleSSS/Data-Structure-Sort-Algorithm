package com.nicole.practice.sort;

/**
 * 题目：小范围排序练习题
 * 说明：已知一个几乎有序的数组，几乎有序是指，如果把数组排好顺序的话，
 * 每个元素移动的距离可以不超过k，并且k相对于数组来说比较小。
 * 请选择一个合适的排序算法针对这个数据进行排序。
 * @author Nicole
 * 分析：
 * 1.时间复杂度为O(N)的算法：计数排序、基数排序
 * ——不急于比较的排序算法的限制：不适用所有的情况
 * ——在这里并不知道数组的范围，排除
 * 2.时间复杂度为O(N^2)的算法；冒泡排序、选择排序
 * ——这两个排序算法与数组原始序列无关，排除
 * 3.时间复杂度为O(N^2)的算法：插入排序
 * ——插入排序的过程与原始顺序有关，每个元素移动距离不超过k
 * ——这道题时间复杂度为O(N*k)
 * 4.时间复杂度为O(N*logN)的算法：快速排序、归并排序
 * ——与数组原始顺序无关，排除
 * 5.答案：改进后的堆排序
 * ——每得到一个数O(logk)
 * 第一步：整个数组的最小值应该在a[0]-a[k-1]上，首先a[0]-a[k-1]的k个数组成一个小根堆，堆顶是最小值；
 * 第二步：将堆顶数弹出，放在原数组的位置0上；
 * 第三步：将a[k]放在小根堆的堆顶，调整小根堆，堆顶是第二小值；
 * 第四步：将堆顶数弹出，放在原数组的位置1上；
 * ……
 * 最后一个数弹出，排序结束。
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
