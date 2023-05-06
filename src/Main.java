public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        int [] matrix = {1,1,4,6,1,5,5};
        int value = 5;

        for(int valor : main.solution(value, matrix)) {
            System.out.println(valor);
        }
    }

    public int[] solution(int N, int[] A) {
        int[] counters = new int[N];
        int maxCounter = 0;
        int currentMax = 0;

        for (int i = 0; i < A.length; i++) {
            int X = A[i];
            if (X >= 1 && X <= N) {
                counters[X-1] = increaseCounter(counters[X-1], currentMax);
                maxCounter = Math.max(maxCounter, counters[X-1]);
            } else if (X == N + 1) {
                currentMax = maxCounter;
            }
        }
        for (int i = 0; i < counters.length; i++) {
            counters[i] = setCounterToMax(counters[i], currentMax);
        }
        return counters;
    }
    private int increaseCounter(int counter, int currentMax) {
        return Math.max(counter, currentMax) + 1;
    }

    private int setCounterToMax(int counter, int max) {
        return Math.max(counter, max);
    }
}