//CP1340 Lab 6 Graphics and Animation
//Student: Cade Molloy - 20175269
//Due Date: December 13th, 2022
//Prof: Branko Cirovic
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JPanel;


class UI extends JFrame {

    private static Image caImage;

    public UI(int width, int height, SwingCA ca) {
        setTitle("SwingCA");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        JPanel panel = new JPanel() {
            @Override
            public void paint(Graphics g) {
                if (caImage == null) {
                    caImage = createImage(width, height);
                    Graphics imgGraphics = caImage.getGraphics();
                    boolean[] cells = ca.getState();
                    for (int y = 0; y < height; y++) {
                        for (int x = 0; x < width; x++) {
                            if (cells[x]) {
                                imgGraphics.setColor(Color.BLACK);
                                imgGraphics.fillRect(x, y, 1, 1);
                            } else {
                                imgGraphics.setColor(Color.WHITE);
                                imgGraphics.fillRect(x, y, 1, 1);
                            }
                        }
                        cells = ca.getState();
                    }
                }
                g.drawImage(caImage, 0, 0, null);
            }
        };
        panel.setPreferredSize(new Dimension(width, height));
        add(panel);
        pack();
        setVisible(true);
    }
}

class SwingCA {
    private boolean[] ttable;
    private int size;
    private boolean[] cells;
    
    public SwingCA(int rule, int size) {
        this.ttable = new boolean[8];
        for (int i = 0; i < ttable.length; i++) {
            ttable[i] = (rule & 0x1) == 1? true : false;
            rule >>= 1;
        }

        this.size = size;
        this.cells = new boolean[size];
        this.cells[this.size / 2] = true;
    }

    public boolean[] getState() {
        boolean[] newCells = new boolean[size];
        for (int i = 1; i < size - 1; i++) {
            int left  = cells[i - 1]? 1 : 0;
            int curr  = cells[i]    ? 1 : 0;
            int right = cells[i + 1]? 1 : 0;
            int ruleIdx = (4 * left) + (2 * curr) + right;
            newCells[i] = ttable[ruleIdx];
        }
        this.cells = newCells;
        return this.cells;
    }
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.print("Usage: SwingCA <Rule>");
        } else {
            try {
                int size = 400;
                int generations = 600;
                int rule = Integer.parseInt(args[0]);
                SwingCA ca = new SwingCA(rule, size);
                new UI(size, generations, ca);
            } catch (NumberFormatException ex) {
                System.out.println("Rule must be an Integer!");
            }
        }
    }
}