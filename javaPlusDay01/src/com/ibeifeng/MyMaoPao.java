package com.ibeifeng;

import java.util.Arrays;

public class MyMaoPao {

	public static void main(String[] args) {
		new MyMaoPao().method3();
	}

	//冒泡排序
	public void method1(){
		int[] arr={1,23,45,21,34,67,98,32,324,4,9,14,54};
		for (int i = 0; i < arr.length-1; i++) {
			for (int j = 0; j < arr.length-i-1; j++) {
				if(arr[j]>arr[j+1]){
					int tmp;
					tmp=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=tmp;
				}
			}
		}
		System.out.println(Arrays.toString(arr));
	}
	/** 插入式排序 */
	public void method2(){
		int[] arr={1,23,45,21,34,67,98,32,324,4,9,14,54};
		int i,j,k;
		for(i=1; i<arr.length; i++){
			k = arr[i];//取出
			//查找位置
			for(j=i-1; j>=0 && k<arr[j]; j--){
				arr[j+1]=arr[j];//向后移动元素
			}
			arr[j+1]=k;//插入
		}
		System.out.println(Arrays.toString(arr));
	}

	/** 选择排序: 每轮选择一个最小的放到前面 */
	public void method3(){
		int[] arr={1,23,45,21,34,67,98,32,324,4,9,14,54};
		for(int i=0; i<arr.length-1; i++){
			for(int j=i+1; j<arr.length; j++){
				if(arr[i]>arr[j]){
					int t=arr[i];
					arr[i]=arr[j];
					arr[j]=t;
				}
			}
		}
		System.out.println(Arrays.toString(arr));
	}
}
