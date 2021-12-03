package vsu.shirnin.test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Object> arrayList= new ArrayList<Object>();
        List<Object> linkedList= new LinkedList<Object>();

        SpeedTestList.compare(arrayList, linkedList);
    }
}
