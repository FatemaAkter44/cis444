package projectone;
import java.util.*;

public class DEMODataAnalisis {

   public static Set<String> dataSet(Set<String> set){
        // create empty set
        set = new HashSet<String>();
        // {3, 25, 33, 21, 55, 43, 78, 31, 33, 75, 43, 11, 36, 4, 10, 99, A, B, C}
        // add values one by one in set
        set.add("3");
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
        set.add("4");
        set.add("10");
        set.add("99");
        set.add("A");
        set.add("B");
        set.add("C");
        // print input set
        //System.out.println("Set: " + set);

       if(set == null) throw new IllegalArgumentException("array is null");
        return set;
    }

    public static void main(String[] args)
    {
        // call funtion Data_NaN to filter out non-numerical data
        Set<String> set = null;
        System.out.println("After filtering nonnumerical data- Set: "+Data_NaN(set));
        // call funtion Data_Min to calculate min value
        System.out.println("Minimum number from set is= "+ Data_min(set));            //Data_Min(dataSet(set)));
        // call funtion Data_Min to calculate min value
        System.out.println("Maximum number from set is= "+Data_Max(dataSet(set)));

    }
    public static Set<String> Data_NaN(Set<String> set){
        Set<String> set2 = new HashSet<String>();
        for (String temp : dataSet(set)) {
            temp = temp.replaceAll(
                    "[^0-9]", "");

            if(!(dataSet(set).isEmpty())){
                set2.add(temp);
            }

        }
        return set2;

    }


    public static String Data_min(Set<String> set2) {
        String obj = Collections.min(set2);
        return obj;
    }

    static String Data_Max(Set<String> set) {
        String obj = Collections.max(Data_NaN(set));
        return obj;
    }


}
