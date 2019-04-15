package com.nicole.practice.sort;

/**
 * ��Ŀ��������������ֵ��ϰ��
 * ˵������һ����������A�������һ�����Ӷ�ΪO(n)���㷨������������������������ֵ��
 * ����һ��int����A��A�Ĵ�Сn���뷵�����Ĳ�ֵ��
 * ��֤����Ԫ�ض���1����
 * @author Nicole
 * ʱ�临�Ӷȣ�O(N)
 * ����ռ临�Ӷȣ�O(1)
 * ˼�룺Ͱ����
 * ���ͣ�n������0 - ��n-1����
 * ��һ�����������飬�ҵ������е���Сֵmin�����ֵmax
 * �ڶ������������鳤��n����[min,max)��Ϊn���������䣬ÿ�������Ӧһ��Ͱ��
 * ����������Ԫ����Ͱ���������ֵ����n+1��Ͱ�У�ͰֵΪmax��
 * ��Ϊ��һ��Ͱ�б�Ȼ��min����n+1��Ͱ����max���м��Ͱ��Ȼ���ڿ�Ͱ
 * ����Ϊͬһ��Ͱ�����Ĳ�ֵ����������䳤�ȣ����Բ��ÿ���ͬһ��Ͱ����������ֻ�ÿ���Ͱ���������
 * ���Ĳ�������Ͱ�е�ֵ��������������ֻ��Ҫ����ÿ��Ͱ����Сֵ����һ���ǿ�Ͱ�����ֵ�Ĳ�ֵk������¼����
 * ���岽�������ֵ����k���Ͳ��ϸ��£�ֱ�����һ��ֵ������
 */
public class Sort_4_4 {

	public static void main(String[] args) {
		int[] data = {1, 2, 5, 4, 6};
		int n = data.length;
		int gap = maxGap(data, n);
		System.out.println(gap);
		
		
	}
	
	public static int maxGap(int[] A, int n) {
		if (A == null || A.length < 2) {
			return 0;
		}
		
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		for(int i = 0; i < n; i++) {
			min = Math.min(min, A[i]);
			max = Math.max(max, A[i]);
		}
		if(min == max) {
			return 0;
		}
		
		boolean[] hasA = new boolean[n + 1];
		int[] maxs = new int[n + 1];
		int[] mins = new int[n + 1];
		int index = 0;
		for(int i = 0; i < n; i++) {
			index = bucket(A[i], n, min, max);
			mins[index] = hasA[index] ? Math.min(mins[index], A[i]) : A[i];
			maxs[index] = hasA[index] ? Math.max(maxs[index], A[i]) : A[i];
			hasA[index] = true;
		}
		
		int res = 0;
		int lastMax = 0;
		int i = 0;
		while(i <= n) {
			if(hasA[i++]) {
				// �ҵ���һ�����յ�Ͱ
				lastMax = maxs[i-1];
				break;
			}
		}
		for(; i <= n; i++) {
			if(hasA[i]) {
				res = Math.max(res, mins[i] - lastMax);
				lastMax = maxs[i];
			}
		}
		
		return res;
		
	}
	// ʹ��long������Ϊ�˷�ֹ���ʱ���
	public static int bucket(long nums, long n, long min, long max) {
		return (int) ((nums - min) * n / (max - min));
	}
	

}
