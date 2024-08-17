package Heap;

public class MaxHeap {

    public static void heapify(int[] array)
    {
        var lastParentIndex = array.length / 2 - 1;
        for(int i = lastParentIndex; i>= 0; i--){
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

    public static int getKthLargest(int[] array, int k)
    {
        if(k < 1 || k > array.length){
            throw new IllegalArgumentException();
        }

        var heap = new Heap();

        for(var number : array){
            heap.insert(number);
        }

        for(int i =0; i < k -1; i++){
            heap.remove();
        }

        return heap.max();
    }
}
