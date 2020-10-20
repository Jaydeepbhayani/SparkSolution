package anetos.software.lib;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class SparkSegmentCollection {

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

    public static String recursive(ArrayList<Integer> a, int position, int length) {
        String pre = "";
        String preTemp = "";
        while (position <= a.size() - 1) {
            if (pre.length() < length) {
                preTemp = pre;
                pre = pre.concat(spark(a.get(position)));
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

    static ArrayList<Integer> array= new ArrayList<>();
    static int width = 10;

    public static void main(String[] args) {
        for (int value : array) {
            if (value + 1 > width) {
                System.out.println("\uD83D\uDE14   Element you've added is out of range.");
                System.exit(0);
            } else {
                array.add(9);
                array.add(6);
            }
        }

        for (int i = 0; i < array.size(); i++) {
            int first = array.get(i) + 1;
            if (first == width) {
                System.out.println(spark(array.get(i)));
            } else {
                String output = recursive(array, i, width);
                if (output.length() < width) {
                    System.out.println(output.concat(freeSegments(width - output.length())));
                } else {
                    System.out.println(output);
                }
                i = traversedPosition - 1;
            }
        }
    }
}