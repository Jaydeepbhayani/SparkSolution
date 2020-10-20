package anetos.software.lib;

import java.util.Arrays;

public class SumofNumber {

    public static String spark(int length) {
        if (length == 0)
            return "";

        String pre = "X";
        for (int i = 0; i < length; i++) {
            pre = pre.concat("~");
        }
        return pre;
    }

    public static String freeSegments(int length) {
        String suffix = "";
        if (length == 0) {
            return "";
        } else {
            for (int i = 0; i < length; i++) {
                suffix = suffix.concat("0");
            }
            return suffix;
        }
    }

    static int traversedPosition = 0;

    public static String recursive(int[] a, int position, int length) {
        String pre = "";
        String preTemp = "";
        while (position <= a.length - 1) {
            if (pre.length() < length) {
                preTemp = pre;
                pre = pre.concat(spark(a[position]));
                if (pre.length() > length) {
                    return preTemp;
                }
            } else {
                break;
            }
            position++;
            traversedPosition = position;
        }

        return pre;
    }

    public static void main(String[] args) {

        int[] array = {1, 2, 3, 4, 5};
        int temp = 0;
        int[] arrayTemp = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            temp += array[i];
            arrayTemp[i] = temp;
        }
        System.out.println(temp);
        System.out.println(Arrays.toString(arrayTemp));
    }
}