package vsu.shirnin.test;

import java.util.List;

/**
 * Comparison of the speed of ArrayList and LinkedList
 */
public class SpeedTestList {
    /**
     * Number of list items to check
     */
    private static final int count = 50000;

    /**
     * The main method of the class, compares the speed for all actions
     * @param firstList first kind of list
     * @param secondList second kind of list
     */
    public static void compare(List<Object> firstList, List<Object> secondList) {
        StringBuilder firstWin = new StringBuilder();
        StringBuilder secondWin = new StringBuilder();
        long firstTime;
        long secondTime;

        System.out.println("+++++++++++++++++Comparison results++++++++++++++++++++");
        System.out.println("// for" + count + " elements");
        System.out.println();
        System.out.println("==================Adding to the end:===================");
        System.out.println("Adding to the end:");
        firstTime = addToTheEnd(firstList);
        secondTime = addToTheEnd(secondList);
        whoWin(firstTime, secondTime, firstWin, secondWin);
        System.out.println(firstList.getClass().getSimpleName() + ": " + firstTime + "ms" + firstWin);
        System.out.println(secondList.getClass().getSimpleName() + ": " + secondTime + "ms" + secondWin);
        System.out.println();

        System.out.println("=================Adding to the start:==================");
        firstTime = addToTheStart(firstList);
        secondTime = addToTheStart(secondList);
        whoWin(firstTime, secondTime, firstWin, secondWin);
        System.out.println(firstList.getClass().getSimpleName() + ": " + firstTime + "ms" + firstWin);
        System.out.println(secondList.getClass().getSimpleName() + ": " + secondTime + "ms" + secondWin);
        System.out.println();

        System.out.println("================Insert to the middle:==================");
        firstTime = insertToTheMiddle(firstList);
        secondTime = insertToTheMiddle(secondList);
        whoWin(firstTime, secondTime, firstWin, secondWin);
        System.out.println(firstList.getClass().getSimpleName() + ": " + firstTime + "ms" + firstWin);
        System.out.println(secondList.getClass().getSimpleName() + ": " + secondTime + "ms" + secondWin);
        System.out.println();

        System.out.println("==========Removing items from the beginning============");
        firstTime = removeElementsFromTheStart(firstList);
        secondTime = removeElementsFromTheStart(secondList);
        whoWin(firstTime, secondTime, firstWin, secondWin);
        System.out.println(firstList.getClass().getSimpleName() + ": " + firstTime + "ms" + firstWin);
        System.out.println(secondList.getClass().getSimpleName() + ": " + secondTime + "ms" + secondWin);
        System.out.println();

        System.out.println("===========Removing items from the middle==============");
        firstTime = removeElementsFromTheMiddle(firstList);
        secondTime = removeElementsFromTheMiddle(secondList);
        whoWin(firstTime, secondTime, firstWin, secondWin);
        System.out.println(firstList.getClass().getSimpleName() + ": " + firstTime + "ms" + firstWin);
        System.out.println(secondList.getClass().getSimpleName() + ": " + secondTime + "ms" + secondWin);
        System.out.println();

        System.out.println("=============Removing items from the end===============");
        firstTime = removeElementsFromTheEnd(firstList);
        secondTime = removeElementsFromTheEnd(secondList);
        whoWin(firstTime, secondTime, firstWin, secondWin);
        System.out.println(firstList.getClass().getSimpleName() + ": " + firstTime + "ms" + firstWin);
        System.out.println(secondList.getClass().getSimpleName() + ": " + secondTime + "ms" + secondWin);
        System.out.println();

        System.out.println("====================Get elements:======================");
        firstTime = getElements(firstList);
        secondTime = getElements(secondList);
        whoWin(firstTime, secondTime, firstWin, secondWin);
        System.out.println(firstList.getClass().getSimpleName() + ": " + firstTime + "ms" + firstWin);
        System.out.println(secondList.getClass().getSimpleName() + ": " + secondTime + "ms" + secondWin);
        System.out.println();

        System.out.println("================Replacing elements:====================");
        firstTime = replacingElements(firstList);
        secondTime = replacingElements(secondList);
        whoWin(firstTime, secondTime, firstWin, secondWin);
        System.out.println(firstList.getClass().getSimpleName() + ": " + firstTime + "ms" + firstWin);
        System.out.println(secondList.getClass().getSimpleName() + ": " + secondTime + "ms" + secondWin);
        System.out.println();
    }

    /**
     * Calculates the time to add to the end of the list
     * @param list list of specific interface implementation
     * @return execution time in ms
     */
    public static long addToTheEnd(List<Object> list) {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < count; i++) {
            list.add(new Object());
        }
        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }

    /**
     * Calculates the time to add to the beginning of the list
     * @param list list of specific interface implementation
     * @return execution time in ms
     */
    public static long addToTheStart(List<Object> list) {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < count; i++) {
            list.add(0, new Object());
        }
        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }

    /**
     * Calculates the time to insert to the middle of the list
     * @param list list of specific interface implementation
     * @return execution time in ms
     */
    public static long insertToTheMiddle(List<Object> list) {
        long startTime = System.currentTimeMillis();
        list.add( new Object());
        for (int i = 1; i < count; i++) {
            list.add(list.size() / 2, new Object());
        }
        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }

    /**
     * Calculates the time to remove from the beginning
     * @param list list of specific interface implementation
     * @return execution time in ms
     */
    public static long removeElementsFromTheStart(List<Object> list) {
        for (int i = 0; i < count; i++) {
            list.add(new Object());
        }
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < count; i++) {
            list.remove(0);
        }
        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }

    /**
     * Calculates the time to remove from the middle
     * @param list list of specific interface implementation
     * @return execution time in ms
     */
    public static long removeElementsFromTheMiddle(List<Object> list) {
        for (int i = 0; i < count; i++) {
            list.add(new Object());
        }
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < count - 1; i++) {
            list.remove(list.size() / 2);
        }
        list.remove(0);
        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }

    /**
     * Calculates the time to remove from the end
     * @param list list of specific interface implementation
     * @return execution time in ms
     */
    public static long removeElementsFromTheEnd(List<Object> list) {
        for (int i = 0; i < count; i++) {
            list.add(new Object());
        }
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < count; i++) {
            list.remove(list.size() - 1);
        }
        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }

    /**
     * Calculates the time to retrieve items
     * @param list list of specific interface implementation
     * @return execution time in ms
     */
    public static long getElements(List<Object> list) {
        for (int i = 0; i < count; i++) {
            list.add(new Object());
        }
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < count; i++) {
            list.get(i);
        }
        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }

    /**
     * Calculates the time to replace elements
     * @param list list of specific interface implementation
     * @return execution time in ms
     */
    public static long replacingElements(List<Object> list) {
        for (int i = 0; i < count; i++) {
            list.add(new Object());
        }
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < count; i++) {
            list.set(i, new Object());
        }
        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }

    /**
     * Assigns a string with less time
     * @param firstTime run time of the first list
     * @param secondTime run time of the second list
     * @param firstWin first list winner string
     * @param secondWin second list winner string
     */
    private static void whoWin(long firstTime, long secondTime, StringBuilder firstWin, StringBuilder secondWin) {
        String winLine = "  <---  * win * ";
        firstWin.delete(0, firstWin.length());
        secondWin.delete(0, secondWin.length());
        if (firstTime > secondTime) {
            secondWin.append(winLine);
        } else if (firstTime < secondTime) {
            firstWin.append(winLine);
        }
    }
}
