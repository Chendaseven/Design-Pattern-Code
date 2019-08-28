package CollectionTest.sortcompare;

public class SelectionSort implements Sort {
	int numbers[];
    SelectionSort(int [] numbers){
        this.numbers = numbers;
    }
     
    @Override
    public void sort() {
        for (int j = 0; j < numbers.length-1; j++) {
            for (int i = j+1; i < numbers.length; i++) {
                if(numbers[i]<numbers[j]){  
                    int temp = numbers[j];
                    numbers[j] = numbers[i];
                    numbers[i] = temp;
                }
            }
        }
    }

    @Override
    public int[] values() {
        // TODO Auto-generated method stub
        return numbers;
    }

}
