package Algorithms;

public class TowersOfHanoi {
    public static void main(String[] args) {
        int nDisks = 3;
        moveDisk(nDisks, 'A', 'B', 'C');
    }

    private static void moveDisk(int topN, char from, char inter, char to) {
        if(topN == 1) {
            System.out.println(String.format("Disk 1 from %c to %c", from, to));
        } else {
            moveDisk(topN - 1, from, to, inter);
            System.out.println(String.format("Disk %d from %c to %c", topN, from, to));
            moveDisk(topN - 1, inter, from, to);
        }
    }
}
