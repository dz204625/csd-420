package module3;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

public class NewList {
    public static <E> ArrayList<E> removeDuplicates(ArrayList<E> list){
        return new ArrayList<>(new HashSet<>(list));
    }
    public static void main(String[] args) {
        Random random = new Random();
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0; i<50; i++) {
            list.add(random.nextInt(20) + 1);
        }
        ArrayList<Integer> newList = removeDuplicates(list);
        System.out.println(newList);
    }
}
