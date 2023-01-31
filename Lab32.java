//CP1340 Lab 3 - Classes and Objects II
//Student: Cade Molloy - 20175269
//Due Date: November 1st, 2022
//Prof: Branko Cirovic

public class Lab32 {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Usage: <RULE> <SIZE>");
        } else {

            int size = Integer.parseInt(args[0]);
            int rule = Integer.parseInt(args[1]);
            CA ca = new CA(size, rule);

            while(true) {
                boolean[] cell = ca.getState();
                for (int j = 0; j < size; j++) {
                    if (cell[j]) {
                        System.out.print('X');
                    } else {
                        System.out.print(' ');
                    }
                }
                System.out.println();
            }
        }
    }
}

class CA {
    private int size;
    private int rule;
    private boolean[] cell;
    private boolean[] ttable;

    public CA(int size, int rule) {
        this.rule = rule;
        this.size = size;
        ttable = new boolean[8];
        for(int i = 0; i < ttable.length; i++) {
            ttable[i] = (rule & 0x1) == 1? true: false;
            rule >>= 1;
        }

        cell = new boolean[size];
        cell[size / 2] = true;
    }

    public boolean[] getState() {
        boolean[] newCell = new boolean[size];
        for(int i = 1; i < size - 1; i++) {
            int lef = cell[i-1]? 1 : 0;
            int cur = cell[i]  ? 1 : 0;
            int rig = cell[i+1]? 1 : 0;

            int ruleIdx = 4 * lef + 2 * cur + 1 * rig;
            newCell[i] = ttable[ruleIdx];
        }
        cell = newCell;
        return cell;
    }
}