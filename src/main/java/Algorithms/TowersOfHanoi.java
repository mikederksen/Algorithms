package Algorithms;

import CustomTypes.HANStack;

import java.util.Dictionary;
import java.util.Hashtable;

public class TowersOfHanoi {
    private final int amount;
    private final Dictionary<Character, HANStack<Integer>> towers;

    public TowersOfHanoi(int amount) {
        this.amount = amount;
        this.towers = new Hashtable<>();

        towers.put('A', new HANStack<>());
        towers.put('B', new HANStack<>());
        towers.put('C', new HANStack<>());

        for(int i = amount; i > 0; i--) {
            towers.get('A').push(i);
        }

        printTowers();
    }

    public void solve() {
        moveDisk(amount, 'A', 'B', 'C');
    }

    private void moveDisk(int topN, char from, char inter, char to) {
        if(topN == 1) {
            System.out.println(String.format("Disk 1 from %c to %c", from, to));
            towers.get(to).push(towers.get(from).pop());
            printTowers();
        } else {
            moveDisk(topN - 1, from, to, inter);

            System.out.println(String.format("Disk %d from %c to %c", topN, from, to));
            towers.get(to).push(towers.get(from).pop());
            printTowers();

            moveDisk(topN - 1, inter, from, to);
        }
    }

    private void printTowers() {
        System.out.println(String.format("A: %s", towers.get('A').toString()));
        System.out.println(String.format("B: %s", towers.get('B').toString()));
        System.out.println(String.format("C: %s", towers.get('C').toString()));
    }
}
