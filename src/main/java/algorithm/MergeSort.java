package algorithm;

public class MergeSort {

    public static void main(String[] args) {
        var solution = new MergeSort_Solution();
        int[] inputs = new int[]{10, 2, 4, 1, 6, 3, 7};
        solution.mergeSort(inputs, 0, inputs.length - 1);
        System.out.print("[");
        for (var input : inputs) {
            System.out.printf(" %d,", input);
        }
        System.out.print("]");
    }

}

class MergeSort_Solution {

    /**
     * @param A 정렬 대상이 되는 리스트
     * @param p list의 처음 index
     * @param r list의 마지막 index
     */
    public void mergeSort(int[] A, int p, int r) {
        if (p < r) {
            int q = (p + r) / 2;
            mergeSort(A, p, q);
            mergeSort(A, q + 1, r);
            merge(A, p, q, r);
        }
    }

    private void merge(int[] A, int p, int q, int r) {
        // 1. 병합할 두 배열의 크기 구하기
        int leftSize = q - p + 1; // 인덱스 p부터 q까지 크기
        int rightSize = r - q; // 인덱스 q+1 부터 r까지 크기

        // 2. 배열 복사
        int[] left = new int[leftSize + 1];
        int[] right = new int[rightSize + 1];

        for (int i = 0; i < leftSize; i++) {
            left[i] = A[p + i];
        }

        int rightStart = q + 1;
        for (int j = 0; j < rightSize; j++) {
            right[j] = A[(rightStart) + j];
        }
        left[leftSize] = right[rightSize] = Integer.MAX_VALUE;

        // 3. 병합하기
        // 각 배열의 포인터를 두어 작은 값부터 차례로 복사한다.
        int i = 0, j = 0;
        for (int k = p; k <= r; k++) {
            if (left[i] <= right[j]) {
                A[k] = left[i];
                i++;
                continue;
            }
            A[k] = right[j];
            j++;
        }
    }

}
