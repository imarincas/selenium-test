public class MainApplication {

    public static void main(String[] args) {

        System.out.println("Exercise 1 ---------------------------------------------------------------------------------------\n");
        String input1 = "Desperation";
        String input2 = "A Rope Ends it";

        if (Exercise1.isAnagram(input1, input2)) {
            System.out.println("Given words, \"" + input1 + "\" and  \"" + input2 + "\" ARE an anagrams.");
        } else {
            System.out.println("Given words are NOT an anagram.");
        }
        System.out.println("\nExercise 2 ---------------------------------------------------------------------------------------\n");


        int[] arrayOfIntegers = new int[]{4, 8, 6, 1, 2, 9, 4};
        System.out.println("First neighbour is: " + arrayOfIntegers[Exercise2.getFirstIndexOfSmallestDistance(arrayOfIntegers)]);
        System.out.println("Index of the first neighbour is: " + Exercise2.getFirstIndexOfSmallestDistance(arrayOfIntegers));

    }
}
