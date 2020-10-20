package anetos.software.lib;

public class SparkSegment {

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

        int[] array = {0, 9, 9, 8, 3, 5, 6, 3, 2, 2, 2, 5};
        int width = 10;

        for (int value : array) {
            if (value + 1 > width) {
                System.out.println("\uD83D\uDE14   Element you've added is out of range.");
                System.exit(0);
            }
        }

        for (int i = 0; i < array.length; i++) {
            int first = array[i] + 1;
            if (first == width) {
                System.out.println(spark(array[i]));
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