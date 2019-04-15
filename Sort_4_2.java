package com.nicole.practice.sort;

/**
 * ��Ŀ��������������ϰ��
 * ˵����������һ���к��ж��ź���ľ��������һ����Ч�㷨�����ٲ��Ҿ������Ƿ���ֵx��
 * ����һ��int����mat��ͬʱ���������Сnxm�������ҵ���x��
 * �뷵��һ��boolֵ������������Ƿ����x��
 * ���о��������ּ�x��Ϊint��Χ��������
 * ��֤n��m��С�ڵ���1000��
 * @author Nicole
 * 
 * ʱ�临�Ӷȣ�O(m+n)�������
 * �ռ临�Ӷȣ�O(1)
 * ���磺Ҫ���ҵ���Ϊ3
 * 0 1 2 5    
 * 1 2 4 7
 * 4 4 4 8 
 * 5 7 7 9
 * ˼·���ӵ�һ�����һ�е�ֵa[0][m-1]��ʼ�����x<a[0][m-1],�������ƶ���ֵa[0][m-2]��
 * ���x>a[0][m-2]���������ƶ���a[1][m-2]
 * ���x<a[1][m-2]���������ƶ���a[1][m-3]
 * ����ҵ��ͷ���true
 * ȫ�����꣬��û���ҵ����ͷ���false
 */
public class Sort_4_2 {

	public static void main(String[] args) {
		
		int[][] data = {{1,2,3},{4,5,6},{7,8,9}};
		int n = data.length;
		int m = data[0].length;
		int x = 2;
		boolean isContain = findX(data, n, m, x);
		System.out.print(isContain);
	}
	
	public static boolean findX(int[][] mat, int n, int m, int x) {
		int row = 0;
		int column = m-1;
		while(row < n && column >= 0) {
			if(mat[row][column] == x) {
				return true;
			}
			if(mat[row][column] > x) {
				column --;
				if(column < 0) {
					break;
				}
			}
			if(mat[row][column] < x) {
				row ++;
			}
		}
		return false;
	}

}
