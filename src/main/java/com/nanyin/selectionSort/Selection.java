package com.nanyin.selectionSort;

/**
 * 今天就来看看选择排序是如何实现的
 * 选择排序原理就是从第一个位置上选择一个最小的数字，第二个位置上选择剩下的数中最小的数字，以此类推排序就完成了
 */
public class Selection {
    public static void main(String[] args) {
        Integer[] sortArray = new Integer[]{1,3,2,5,4,9,7,6,8};
        for (int i = 0 ; i < sortArray.length ; i++){
            int min = i;
            for(int j = i+1 ; j < sortArray.length ;j++){
                if(sortArray[min]>sortArray[j]){
                   min = j ;
                }
                if(min != i){
                    int x =  sortArray[min] ;
                    sortArray[min] = sortArray[i];
                    sortArray[i] = x;
                }
            }
        }
        for(int i:sortArray){
            System.out.println(i);
        }
    }
}

