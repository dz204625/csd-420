package module4;

import java.util.Calendar;
import java.util.LinkedList;

public class IterateLinkedList {
    public static long getTime(int listSize) {
        LinkedList<Integer> list = new LinkedList<>();
        long startTime;
        long endTime;
        startTime = Calendar.getInstance().getTimeInMillis();
        for(int i=0; i<listSize; i++){
            list.add(i);
        }
        endTime = Calendar.getInstance().getTimeInMillis();
        long time = endTime - startTime;
        System.out.println(time + " ms");
        return time;
    }
    public static void main(String[] args) {
        long list1Time;
        long list2Time;
    list1Time = getTime(50000);
    list2Time = getTime(500000);
    System.out.println("Iterate 50000 item takes " + list1Time + " ms");
    System.out.println("Iterate 500000 item takes " + list2Time + " ms");
    }
}
