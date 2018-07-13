package vn.its;

import java.util.*;
import java.util.stream.Collectors;

public class Java8_06_Streams {
    public static void main(String[] args) {
        System.out.println("Using Java 7: ");
        List<String> list = Arrays.asList("Hi", "", "Hello", "He", "", "Ha", "Ho", "Ha");
        System.out.println("List: " + list);

        // Count empty strings
        long count = getCountEmptyStringJava7(list);
        System.out.println("Empty Strings: " + count);

        count = getCountLength2Java7(list);
        System.out.println("Strings of length 2: " + count);

        //Eliminate empty string
        List<String> filtered = deleteEmptyStringJava7(list);
        System.out.println("Filtered List: " + filtered);

        //Eliminate empty string and join using comma.
        String mergedString = getMergedStringJava7(list, "2, ");
        System.out.println("Merged String: " + mergedString);

        List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);

        //get list of square of distinct numbers
        List<Integer> squaresList = getSquares(numbers);
        System.out.println("Squares List: " + squaresList);
        List<Integer> integers = Arrays.asList(1, 2, 13, 4, 15, 6, 17, 8, 19);

        System.out.println("List: " + integers);
        System.out.println("Highest number in List : " + getMax(integers));
        System.out.println("Lowest number in List : " + getMin(integers));
        System.out.println("Sum of all numbers : " + getSum(integers));
        System.out.println("Average of all numbers : " + getAverage(integers));
        System.out.println("Random Numbers: ");

        //print ten random numbers
        Random random = new Random();

        for (int i = 0; i < 10; i++) {
            System.out.println(random.nextInt());
        }

        System.out.println("Using Java 8: ");
        System.out.println("List: " + list);

        count = list.stream().filter(string -> string.isEmpty()).count();
        System.out.println("Empty Strings: " + count);

        count = list.stream().filter(string -> string.length() == 2).count();
        System.out.println("Strings of length 2: " + count);

        filtered = list.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());
        System.out.println("Filtered List: " + filtered);

        mergedString = list.stream().filter(string -> !string.isEmpty()).collect(Collectors.joining("2, "));
        System.out.println("Merged String: " + mergedString);

        squaresList = numbers.stream().map(i -> i * i).distinct().collect(Collectors.toList());
        System.out.println("Squares List: " + squaresList);
        System.out.println("List: " + integers);

        IntSummaryStatistics stats = integers.stream().mapToInt((x) -> x).summaryStatistics();

        System.out.println("Highest number in List : " + stats.getMax());
        System.out.println("Lowest number in List : " + stats.getMin());
        System.out.println("Sum of all numbers : " + stats.getSum());
        System.out.println("Average of all numbers : " + stats.getAverage());
        System.out.println("Random Numbers: ");

        random.ints().limit(10).sorted().forEach(System.out::println);

        //parallel processing
        count = list.parallelStream().filter(string -> string.isEmpty()).count();
        System.out.println("Empty Strings: " + count);
    }

    private static int getCountEmptyStringJava7(List<String> list) {
        int count = 0;
        for (String string : list) {
            if (string.isEmpty()) {
                count++;
            }
        }
        return count;
    }

    private static int getCountLength2Java7(List<String> list) {
        int count = 0;
        for (String string : list) {
            if (string.length() == 2) {
                count++;
            }
        }
        return count;
    }

    private static List<String> deleteEmptyStringJava7(List<String> list) {
        List<String> filteredList = new ArrayList<>();
        for (String string : list) {
            if (!string.isEmpty()) {
                filteredList.add(string);
            }
        }
        return filteredList;
    }

    private static String getMergedStringJava7(List<String> list, String separator) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String string : list) {
            if (!string.isEmpty()) {
                stringBuilder.append(string);
                stringBuilder.append(separator);
            }
        }
        String mergedString = stringBuilder.toString();
        return mergedString.substring(0, mergedString.length() - 2);
    }

    private static List<Integer> getSquares(List<Integer> numbers) {
        List<Integer> squaresList = new ArrayList<Integer>();
        for (Integer number : numbers) {
            Integer square = new Integer(number.intValue() * number.intValue());
            if (!squaresList.contains(square)) {
                squaresList.add(square);
            }
        }
        return squaresList;
    }

    private static int getMax(List<Integer> numbers) {
        int max = numbers.get(0);
        for (int i = 1; i < numbers.size(); i++) {
            Integer number = numbers.get(i);
            if (number.intValue() > max) {
                max = number.intValue();
            }
        }
        return max;
    }

    private static int getMin(List<Integer> numbers) {
        int min = numbers.get(0);
        for (int i = 1; i < numbers.size(); i++) {
            Integer number = numbers.get(i);
            if (number.intValue() < min) {
                min = number.intValue();
            }
        }
        return min;
    }

    private static int getSum(List numbers) {
        int sum = (int) (numbers.get(0));
        for (int i = 1; i < numbers.size(); i++) {
            sum += (int) numbers.get(i);
        }
        return sum;
    }

    private static int getAverage(List<Integer> numbers) {
        return getSum(numbers) / numbers.size();
    }

}
