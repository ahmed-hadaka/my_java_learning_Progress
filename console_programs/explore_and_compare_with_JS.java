public class explore_and_compare_with_JS {
  public static void main(String[] args) {

    final int NUM_OF_COINS = 3; // number of coins that are flipped
    final int NUM_OF_REPS = 1000000; // total number of repetitions

    // The frequency array holds the number of times a particular number
    // of heads occurred.
    int[] frequency;
    int heads; // number of heads in the current group of flips
    float fractionOfReps; // Number of times a particular head count occurred
                          // divided by total number of repetitions.
    int numOfAsterisks; // Number of asterisks in histogram for a
                        // particular head count.

    frequency = new int[NUM_OF_COINS + 1];
    for (int rep = 0; rep < NUM_OF_REPS; rep++) {
      // perform a group of flips
      heads = 0;
      for (int i = 0; i < NUM_OF_COINS; i++) {
        heads += (int) (Math.random() * 2);
      }
      frequency[heads]++; // update appropriate bin
    } // end for

    System.out.println(
        "Number of times each head count occurred:");
    for (heads = 0; heads <= NUM_OF_COINS; heads++) {
      System.out.print(
          " " + heads + "  " + frequency[heads] + " ");
      fractionOfReps = (float) frequency[heads] / NUM_OF_REPS;
      numOfAsterisks = Math.round(fractionOfReps * 100);

      for (int i = 0; i < numOfAsterisks; i++) {
        System.out.print("*");
      }
      System.out.println();

      System.out.println(Math.random() * 2);
    } // end for
  } // end main
} // end class ArrayCopy

// double[] pricesJanuary =
// {1.29, 9.99, 22.50, 4.55, 7.35, 6.49};
// double[] pricesFebruary = new double[pricesJanuary.length];

// for (int i=0; i<pricesJanuary.length; i++)
// {
// pricesFebruary[i] = pricesJanuary[i];
// }
// pricesFebruary[1] = 10.99;

// System.out.printf("%7s%7s\n", "Jan", "Feb");
// for (int i=0; i<pricesJanuary.length; i++)
// {
// System.out.printf("%7.2f%7.2f\n",pricesJanuary[i], pricesFebruary[i]);
// }
