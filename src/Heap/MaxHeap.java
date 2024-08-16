package Heap;

public class MaxHeap {

    public static void heapify(int[] array)
    {
        for(int i = 0; i < array.length; i++){
            heapify(array, i);
        }
    }

    private static void heapify(int[] array, int index)
    {
        var largerIndex = index;

        var leftChildIndex = index * 2 + 1;
        if(leftChildIndex < array.length && array[leftChildIndex] > largerIndex){
            largerIndex = leftChildIndex;
        }

        var rightChildIndex = index * 2 + 2;
        if(rightChildIndex < array.length && array[rightChildIndex] > largerIndex){
            largerIndex = rightChildIndex;
        }

        if(index == largerIndex){
            return;
        }

        swap(array, index, largerIndex);
        heapify(array, largerIndex);
    }

    public static void swap(int[] array, int first, int second) {
        var temp = array[first];
        array[first] = array[second];
        array[second] = temp;
    }
}
