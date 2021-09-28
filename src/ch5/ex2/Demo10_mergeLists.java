package ch5.ex2;

import java.util.ArrayList;
import java.util.Arrays;

public class Demo10_mergeLists {
    
    public static void main(String[] args) {
        Integer arr1[] = {2, 6, 9, 10, 14};
        Integer arr2[] = {3, 5, 7, 12, 13};
        ArrayList<Integer> list1 = new ArrayList<Integer>();
        ArrayList<Integer> list2 = new ArrayList<Integer>();
        list1.addAll(Arrays.asList(arr1));
        list2.addAll(Arrays.asList(arr2));
        
        ArrayList<Integer> list3 = mergeList(list1,list2);
        list3.forEach(n -> System.out.printf("%d ", n));
        System.out.println();
    }

    private static ArrayList<Integer> mergeList(ArrayList<Integer> list1, ArrayList<Integer> list2) {
        
        if(list1.isEmpty()) {
            return list2;
        }
        
        if(list2.isEmpty()) {
            return list1;
        }
        
        ArrayList<Integer> list = new ArrayList<>();
        if(list1.get(0) < list2.get(0)) {
            list.add(list1.remove(0));
        } else {
            list.add(list2.remove(0));
        }
        
        list.addAll(mergeList(list1, list2));
        
        return list;
    }
}
