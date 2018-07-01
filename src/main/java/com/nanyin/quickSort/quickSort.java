package com.nanyin.quickSort;

import java.util.Arrays;

/**
 * 快速排序，从名字上来看就非常高端
 * 其实原理很多好理解，先选出一个基准数，根据这个基准数，分为两部分，左边小于这个基准数，右边大于基准数。
 * 然后递归的对左右两部分再次进行这样的排序。
 */
public class quickSort {

    public static void quick_sort(int array[],int l,int r){
        //i在左边j在右边
        //每次都取第一个数作为基准数
        int i = l;
        int j = r;
        int standNumber = array[l];
        if(i>j){
            return;
        }
        while(i<j){
            while(i<j && array[j]>standNumber){
                j--;
            }
            if(i<j){
                array[i++] = array[j];
            }
            while(i<j && array[i]<standNumber){
                i++;
            }
            if(i<j){
                array[j--] = array[i];
            }
        }

        array[i] = standNumber;
        quick_sort(array,l,i-1);
        if(i!=array.length-1){
            quick_sort(array,i+1,r);
        }

    }

    public static void  sort(int arr[]){
        quick_sort(arr,0,arr.length-1);
    }
    public static void main(String[] args) {
        int[] sortArray = new int[]{4,3,2,5,9,9,7,6,8,1};
        sort(sortArray);
        System.out.println(Arrays.toString(sortArray));
    }
}
