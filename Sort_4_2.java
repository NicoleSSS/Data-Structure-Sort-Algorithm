package com.nicole.practice.sort;

/**
 * 题目：有序矩阵查找练习题
 * 说明：现在有一个行和列都排好序的矩阵，请设计一个高效算法，快速查找矩阵中是否含有值x。
 * 给定一个int矩阵mat，同时给定矩阵大小nxm及待查找的数x，
 * 请返回一个bool值，代表矩阵中是否存在x。
 * 所有矩阵中数字及x均为int范围内整数。
 * 保证n和m均小于等于1000。
 * @author Nicole
 * 
 * 时间复杂度：O(m+n)——最好
 * 空间复杂度：O(1)
 * 例如：要查找的数为3
 * 0 1 2 5    
 * 1 2 4 7
 * 4 4 4 8 
 * 5 7 7 9
 * 思路：从第一行最后一列的值a[0][m-1]开始，如果x<a[0][m-1],则向左移动到值a[0][m-2]，
 * 如果x>a[0][m-2]，则向下移动到a[1][m-2]
 * 如果x<a[1][m-2]，则向左移动到a[1][m-3]
 * 如果找到就返回true
 * 全部找完，都没有找到，就返回false
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
