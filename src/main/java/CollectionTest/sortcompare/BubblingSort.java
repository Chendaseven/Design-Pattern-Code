package CollectionTest.sortcompare;

public class BubblingSort implements Sort {

	 int numbers[];
     BubblingSort(int [] numbers){
         this.numbers = numbers;
     }
     @Override
     public void sort() {
         for (int j = 0; j < numbers.length; j++) {
             for (int i = 0; i < numbers.length-j-1; i++) {
                 if(numbers[i]>numbers[i+1]){  
                     int temp = numbers[i];
                     numbers[i] = numbers[i+1];
                     numbers[i+1] = temp;
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
