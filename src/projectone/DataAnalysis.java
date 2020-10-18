package projectone;
import java.util.*;

public class DataAnalysis {



    public static void main(String args[]) {
// create empty set
        Set<String> set = new HashSet<String>();
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
// print input set
        System.out.println("Set: " + set);
// call funtion Data_NaN to filter out non-numerical data
        System.out.println("After filtering nonnumerical data- Set: " + Data_NaN(set));
// call funtion Data_Min to calculate min value
        System.out.println("Minimum number from set is= " + Data_Min(Data_NaN(set)));
        int max = Data_max(set);
        System.out.println("Maximum number from the set is: " + max);
        double average = Data_average(set);
        System.out.println("Average of numerical set is: " + average);
        double median = Data_media(set);
        System.out.println("Median of the set: " + median);
        Set<String> mode = Data_mode(set);
        System.out.println("Mode of the set is:" + mode);
        List<Integer> sorted = Data_SortedArray(set);
        System.out.println("Sorted set is: " + sorted);

    }
    public static Set<String> Data_NaN(Set<String> set) {
        Set<String> set2 = new HashSet<String>();
        for (String filter : set) {
            filter = filter.replaceAll("[^0-9]", "");

            if (!(set.isEmpty())) {
                set2.add(filter);
            }

        }
        return set2;

    }

   public static String Data_Min(Set<String> set) {
        // converting it to int to find min
        int min = Integer.MAX_VALUE;
        for (String element : set) {
            if (element.trim().length() != 0) {
                int i = Integer.parseInt(element);
                if (i < min)
                    min = i;
            }
        }
        return Integer.toString(min);
    }
   // Data_max: this method computes and returns the maximum of the numerical data;
    /*public static String Data_max(Set<String> set){
        int max = Integer.MIN_VALUE;
        for (String s : set) {
            if (s.trim().length() != 0) {
                int i = Integer.parseInt(s);
                if (i > max)
                    max = i;
            }
        }
        return Integer.toString(max);
    }*/
   public static int Data_max(Set<String> set) {
       int max = -999999999;
       int number;
       for (String element : set) {
           try {

               number = Integer.parseInt(element);
               if (number > max) {
                   max = number;
               }
           } catch (Exception e) {
           }
       }
       return max;
   }

   // Data_average: this method computes and returns the average of the numerical data;
   public static double Data_average(Set<String> set) {
       int sum = 0;
       int number, count = 0;
       for (String element : set) {
           try {

               number = Integer.parseInt(element);
               sum += number;
               count++;
           } catch (Exception e) {
           }
       }
       return sum / count;
   }

   // Data_media: this method computes and returns the median of the numerical data;
   public static double Data_media(Set<String> set) {
       Set<String> stringHashSetDataMedia = new HashSet<String>(set);
       //TAKE THE SORTED LIST AND ASSIGN IT AS SORTED
       List<Integer> sortedArayListDataMedia = Data_SortedArray(stringHashSetDataMedia);
       //IF THERE ARE EVEN NUMBER OF ELEMENTS
       if(sortedArayListDataMedia.size()%2==0)
       {
           //// RETURN THE MEAN OF THE NUMBERS
           return sortedArayListDataMedia.get(sortedArayListDataMedia.size()/2 -1) + sortedArayListDataMedia.get(sortedArayListDataMedia.size()/2 +1) / 2;
       }else
       {
           // ELSE RETURN THE ELEMENT IN THE MIDDLE
           return sortedArayListDataMedia.get(sortedArayListDataMedia.size()/2);
       }
   }
  //  Data_mode: this method computes and returns the mode of the numerical data;
  public static Set<String> Data_mode(Set<String> set) {
       //crease new object of set to sore set
      Set<String> stringSetDataMode = new HashSet<String>();
      //can not use string to get dataMode so we need to convert it to integer
      List<Integer> sortedIntArrayDataMove = Data_SortedArray(set);
      int maxCount = 0; // keep count on max value
      Integer maxValue = null; // store max value
      //this loop will find the max value and will keep counting
      for (int i = 0; i < sortedIntArrayDataMove.size(); ++i) {
          int count = 0;
          //this loop will count the frequency
          for (int j = 0; j < sortedIntArrayDataMove.size(); ++j) {
              // if the number is same than keep counting
              if (sortedIntArrayDataMove.get(j) == sortedIntArrayDataMove.get(i))
                  ++count;
          }
          //
          if (count > maxCount) {
              maxCount = count; //set max count
              maxValue = sortedIntArrayDataMove.get(i); //set max value
          }
      }
     //this loop will look for same frequency number and store in set
      for (int i = 0; i < sortedIntArrayDataMove.size(); ++i) {
          int count = 0;
          for (int j = 0; j < sortedIntArrayDataMove.size(); ++j) {
              if (sortedIntArrayDataMove.get(j) == sortedIntArrayDataMove.get(i))
                  ++count;
          }
          // IF FREQUENCY IS GREATER THAN 1 AND SAME
          if (count == maxCount && maxCount!=1) {
              stringSetDataMode.add(String.valueOf(maxValue));
              // ADD THE NUMBER INTO THE SET
              maxValue = sortedIntArrayDataMove.get(i);
          }
      }
      // CHANGE NUMBER TO STRING
      stringSetDataMode.add(String.valueOf(maxValue));
      return stringSetDataMode;
  }
  //  Data_SortedArray: this method rearranges and returns the data in the increasing order (i.e., smallest to largest).
  public static List<Integer> Data_SortedArray(Set<String> set) {
       //create new object of set to store set
      Set<String> stringHashSetSortedArray = new HashSet<String>();
      //ned to covert strng to int
      List<Integer> intArrayListSortedArray = new ArrayList<Integer>();
      for (String element : set) {
          if (!element.isEmpty())
              intArrayListSortedArray.add(Integer.parseInt(element));
      }
      Collections.sort(intArrayListSortedArray);
      return intArrayListSortedArray;
  }
}
