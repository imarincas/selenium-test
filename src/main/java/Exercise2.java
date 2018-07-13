

public class Exercise2 {

    public static int getFirstIndexOfSmallestDistance(int[] integerArray) {

        if (integerArray == null || integerArray.length < 2) {
            throw new NullPointerException("getFirstIndexOfSmallestDistance method can't be called with null array or array with 1 element.");
        }

        int indexOfFirstNumber = 0;
        int lengthOfArray = integerArray.length;

        int minValue = getDifferenceBetweenTwoNeighbours(integerArray[0], integerArray[1]);

        for (int i = 1; i < lengthOfArray - 1; i++) {
            int v = getDifferenceBetweenTwoNeighbours(integerArray[i], integerArray[i + 1]);
            if (v < minValue) {
                minValue = v;
                indexOfFirstNumber = i;
            }
        }

        return indexOfFirstNumber;
    }

    private static int getDifferenceBetweenTwoNeighbours(int val1, int val2) {
        if (val1 > val2) {
            return val1 - val2;
        } else {
            return val2 - val1;
        }
    }
}
