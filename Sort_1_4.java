package com.nicole.practice.sort;

/**
 * ��Ŀ���鲢����
 * @author Nicole
 * 
 * ʱ�临�Ӷȣ�O(N*logN)
 * �ռ临�Ӷȣ�O(N)
 * �ȶ��ԣ��ȶ�
 * ���ͣ�n��������0 - ��n-1����
 * ��һ�����������е�ÿһ����������󳤶�Ϊ1���������䣬
 * Ȼ�������Ϊ1������������кϲ�������ϲ������õ���󳤶�Ϊ2���������䣻
 * �ڶ�����������Ϊ2������������кϲ�������ϲ������õ���󳤶�Ϊ4���������䣻
 * ����
 * ֱ�������������е����ϲ���һ������
 */
public class Sort_1_4 {

	public static void main(String[] args) {
		
		int[] data= {1,2,3,5,2,3};
		int n = data.length;
		int[] result = mergeSort(data, n);
		for(int i = 0; i < n; i++)
			System.out.print(result[i]);
	}
	
	public static int[] mergeSort(int[] A, int n) {
		if (A == null || A.length < 2) {
			return A;
		}
		//mergeSortUp2Down(A, 0, n-1);
		mergeSortDown2Up(A, n);
		return A;
    }

	/**
	 * �鲢���򣨴������£�
	 * @param a�������������
	 * @param left���������ʼ��ַ
	 * @param right������Ľ�����ַ
	 */
	public static void mergeSortUp2Down(int[] a, int left, int right) {
		if(left < right) {
			int mid = (left + right) / 2;
			//�ָ����
			mergeSortUp2Down(a, left, mid);
			//�ָ��ұ�
			mergeSortUp2Down(a, mid+1, right);
			//��������ķָÿ������ռһ������
			System.out.printf("%d-%d-%d",left,mid,right);
			System.out.println();
			merge(a, left, mid, right);
		}
	}

	public static void mergeSortDown2Up(int[] a,int n) {
		for(int gap = 1; gap < n; gap *=2) {
			mergeGroups(a, n, gap);
		}
	}
	
	/**
	 * ������a�����ɴκϲ���
	 * ����a���ܳ���Ϊlen��������Ϊ���ɸ�����Ϊgap�������飻
     * ��"ÿ2�����ڵ�������" ���кϲ�����
	 * @param a
	 * @param len
	 * @param gap
	 */
	public static void mergeGroups(int[] a, int len, int gap) {
		int i;
		int twolen = 2 * gap; // �������ڵ�������ĳ���
		
		// ��"ÿ2�����ڵ�������" ���кϲ�����
		for(i = 0; i + twolen - 1 < len; i += twolen) {
			System.out.printf("%d-%d-%d", i, i+gap-1, i+ twolen -1);
			System.out.println();
			merge(a, i, i+gap-1, i+ twolen -1);
		}
		
		if(i+gap-1 < len-1) {
			System.out.printf("%d-%d-%d", i, i+gap-1, len -1);
			System.out.println();
			merge(a, i, i+gap-1, len-1);
		}
	}
	/**
	 * ��һ�������е�����������������ϲ���һ��
	 * 
	 * @param a������2���������������
	 * @param left����1�������������ʼ��ַ
	 * @param mid����1����������Ľ�����ַ 
	 * @param right����2����������Ľ�����ַ
	 */
	public static void merge(int[] a, int left, int mid, int right) {
		int[] temp = new int[right-left+1];		//temp�ǻ���2������������ʱ����
		int leftIndext = left;				//��1���������������
		int rightIndex = mid+1;				//��2���������������
		int tempIndex = 0;					//��ʱ���������
		while(leftIndext <= mid && rightIndex <= right) {
			if(a[leftIndext] < a[rightIndex]) {
				temp[tempIndex++] = a[leftIndext++];
			}else {
				temp[tempIndex++] = a[rightIndex++];
			}
		}
		
		while(leftIndext <= mid) {
			temp[tempIndex++] = a[leftIndext++];
		}
		
		while(rightIndex <= right) {
			temp[tempIndex++] = a[rightIndex++];
		}
		//��������Ԫ�أ�ȫ�������ϵ�����a��
		for(int i = 0; i < temp.length; i++) {
			a[left + i] = temp[i];
		}
	}

}
