package CollectionTest.sortcompare;

import java.util.List;

import CollectionTest.Node;

public class TreeSort implements Sort {

	int numbers[];
    Node n;
     
    TreeSort(int [] numbers){
        n =new Node();
        this.numbers = numbers;
    }
    @Override
    public void sort() {
     
        for (int i : numbers) {
            n.add(i);
        }
    }
    @Override
    public int[] values() {
        List<Object> list = n.values();
        int sortedNumbers[] = new int[list.size()];
        for (int i = 0; i < sortedNumbers.length; i++) {
            sortedNumbers[i] = Integer.parseInt(list.get(i).toString());
        }
        return sortedNumbers;
    }
}
