package projectone;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class DataAnnalisisDemo2 {

    public static void main(String[] args) {

        System.out.println("After filtering nonnumerical data: "+ Data_NaN());
        System.out.println("Minimum value After filtering nonnumerical data: "+ data_min());
        




    }
    public static Set<String> Data_NaN(){
        Set<String> set = new HashSet<String>();
        // {3, 25, 33, 21, 55, 43, 78, 31, 33, 75, 43, 11, 36, 4, 10, 99, A, B, C}

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
        //System.out.println("Given data set: " + set);
        //System.out.println("Given data set size: " + set.size());
        Set<String> set2 = new HashSet<String>();
        for (String filter : set) {
            filter = filter.replaceAll(
                    //"[0-9]", "");
                    "[^0-9]", "");

            if(!(set.isEmpty())){
                set2.add(filter);
            }

        }
        //System.out.println("After filtering nonnumerical data: "+ set2);
       // System.out.println("size of set2 : "+set2.size());

    return set2;

    }
   public static String data_min(){
       String minValue = Collections.min(Data_NaN());
       return minValue;
   }
}

