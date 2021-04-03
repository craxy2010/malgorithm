import java.util.Scanner;

class Solution {
    static Scanner sc;

    static final int MAX_SIZE = 10000;
    static int heap[] = new int[MAX_SIZE];
    static int heapCnt = 0;

    static void heapPush(int value) {
        if (heapCnt + 1 > MAX_SIZE) return;

        heap[heapCnt] = value;
        int current = heapCnt;
        int parent;
        while (current > 0) {
            parent = (current - 1) / 2;
            if(comparePrior(current, parent)) break;
            swapNode(current, parent);
            current = parent;
        }
        heapCnt++;
    }

    static int heapPop() {
        if (heapCnt <= 0) return -1;
        heapCnt--;

        int value = heap[0];
        heap[0] = heap[heapCnt];
        int current = 0;
        int child = 0;
        while (current * 2 + 1 < heapCnt) {
            child = (current * 2 + 2 < heapCnt && comparePrior(current * 2 + 2, current * 2 + 1) ? current * 2 + 2 : current * 2 + 1;
            if (comparePrior(current, child)) break;
            swapNode(current, child);
            current = child;
        }
        return value;
    }
    
    static boolean comparePrior(int source, int target){
        if (heap[source] < heap[target]) return true;
        else return false;
    }

    static void swapNode(int source, int target){
        int temp = heap[source];
        heap[source] = heap[target];
        heap[target] = temp;
    }

    public static void main(String arg[]) throws Exception {
        sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            int N = sc.nextInt();

            for (int i = 0; i < N; i++) {
                int value = sc.nextInt();
                heapPush(value);
            }

            System.out.print("#" + test_case + " ");
            for (int i = 0; i < N; i++) {
                System.out.print(heapPop() + " ");
            }
            System.out.println();
        }
        sc.close();
    }
}
