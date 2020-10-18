package projectone;
import java.util.*;
public class WithDubloicateValue {
    static ArrayList<String> Data_NaN(ArrayList<String> set) {
        ArrayList<String> set2 = new ArrayList<String>();
        for (String temp : set) {
            temp = temp.replaceAll("[^0-9]", "");

            if (!(set.isEmpty()) && !temp.isEmpty()) {
                set2.add(temp);
            }

        }
        return set2;

    }

    public static void main(String args[]) {
// create empty set
        ArrayList<String> set = new ArrayList<String>();
// {3, 25, 33, 21, 55, 43, 78, 31, 33, 75, 43, 11, 36, 4, 10, 99, A, B, C}
// add values one by one in set
        set.add("03");
        set.add("25");
        set.add("25");
        set.add("33");
        set.add("21");
        set.add("55");
        set.add("43");
        set.add("78");
        set.add("31");
        set.add("33");
        set.add("75");
        set.add("43");
        set.add("11");
        set.add("36");
        set.add("04");
        set.add("10");
        set.add("99");
        set.add("A");
        set.add("B");
// print input set

        System.out.println("Set: " + set);
        set = Data_NaN(set);
        System.out.println();

        System.out.println("using Data_Nan method: " + set);
        double median = Data_media(set);
        System.out.println();

        System.out.println("Median of the set: " + median);
        List<Integer> sorted = Data_SortedArray(set);
        System.out.println();

        System.out.println("Sorted set is: " + sorted);
        Set<String> mode = Data_mode(set);
        System.out.println();

        System.out.println("Mode of the set is:" + mode);

    }

    private static List<Integer> Data_SortedArray(ArrayList<String> set) {
        ArrayList<String> y = new ArrayList<String>();
        List<Integer> x = new ArrayList<Integer>();
        for (String s : set) {
            if (!s.isEmpty())
                x.add(Integer.parseInt(s));
        }
        Collections.sort(x);
        return x;
    }

    private static Set<String> Data_mode(ArrayList<String> set) {
        Set<String> y = new HashSet<String>();
        List<Integer> x = Data_SortedArray(set);
        int maxCount = 0;
        Integer maxValue = null;
        for (int i = 0; i < x.size(); ++i) {
            int cnt = 0;
            for (int j = 0; j < x.size(); ++j) {
                if (x.get(j) == x.get(i))
                    ++cnt;
            }

            if (cnt > maxCount) {
                maxCount = cnt;
                maxValue = x.get(i);
            }
        }

        for (int i = 0; i < x.size(); ++i) {
            int cnt = 0;
            for (int j = 0; j < x.size(); ++j) {
                if (x.get(j) == x.get(i))
                    ++cnt;
            }

            // System.out.println("c :"+cnt+" max:"+maxCount+" : "+maxValue);
            if (cnt == maxCount && maxCount!=1) {
                y.add(String.valueOf(maxValue));
                maxValue = x.get(i);
            }
        }
        y.add(String.valueOf(maxValue));
        return y;
    }

    private static double Data_media(ArrayList<String> set) {
        List<Integer> sorted = Data_SortedArray(set);
        if (sorted.size() % 2 == 0) {
            return sorted.get(sorted.size() / 2 - 1) + sorted.get(sorted.size() / 2 + 1) / 2;
        } else {
            return sorted.get(sorted.size() / 2);
        }
    }
}

