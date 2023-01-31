//CP1340 Lab 5 GUI and Swing
//Student: Cade Molloy - 20175269
//Due Date: November 29th, 2022
//Prof: Branko Cirovic

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
 
class Javapad extends JFrame {
    private JMenuBar menuBar;
    private JMenu fileMenu;
    private JMenuItem n, open, save, exit;

    public Javapad() {
        super("Javapad");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(640, 480));
        buildGUI();
        pack();
        setVisible(true);
    }

    class MenuListener implements ActionListener {
        private JFileChooser fc;
        private JTextArea area;

        public MenuListener(JTextArea area) {
            fc = new JFileChooser();
            this.area = area;
        }

        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == n) {
                area.setText("");

            } else if(e.getSource() == open) {
                int returnVal = fc.showOpenDialog(Javapad.this);
                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    File fi = new File(fc.getSelectedFile().getAbsolutePath());
                    try {
                        String s1 = "", sl = "";
                        FileReader fr = new FileReader(fi);
                        BufferedReader br = new BufferedReader(fr);
                        sl = br.readLine();
                        while ((s1 = br.readLine()) != null) {
                            sl = sl + "\n" + s1;
                        }
                        area.setText(sl);
                    }
                    catch (IOException evt) {
                        JOptionPane.showMessageDialog(fc, evt.getMessage());
                    }
                }

            } else if(e.getSource() == save) {
                int returnVal = fc.showSaveDialog(Javapad.this);
                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    File fi = new File(fc.getSelectedFile().getAbsolutePath());
                    try {
                        FileWriter wr = new FileWriter(fi, false);
                        BufferedWriter w = new BufferedWriter(wr);
                        w.write(area.getText());
                        w.flush();
                        w.close();
                    }
                    catch (IOException evt) {
                        JOptionPane.showMessageDialog(fc, evt.getMessage());
                    }
                }

            } else if(e.getSource() == exit) {
                System.exit(0);
            }
        }
    }

    private void buildGUI() {
        Container container = this.getContentPane();

        menuBar = new JMenuBar();
        container.add(menuBar, BorderLayout.NORTH);   

        fileMenu = new JMenu("File");
        menuBar.add(fileMenu);

        n = new JMenuItem("New");
        fileMenu.add(n);
        fileMenu.addSeparator();

        open = new JMenuItem("Open");
        fileMenu.add(open);
        fileMenu.addSeparator();

        save = new JMenuItem("Save");
        fileMenu.add(save);
        fileMenu.addSeparator();

        exit = new JMenuItem("Exit");
        fileMenu.add(exit);

        JTextArea edit = new JTextArea(30,20);
        edit.setFont(new Font("Menlo", Font.PLAIN, 14));

        JScrollPane sp = new JScrollPane(edit);
        sp.setPreferredSize(new Dimension(450, 100));
        container.add(sp, BorderLayout.CENTER);

        MenuListener ml = new MenuListener(edit);
        n.addActionListener(ml);
        open.addActionListener(ml);
        save.addActionListener(ml);
        exit.addActionListener(ml);
    }

    public class Lab52 {}
    public static void main(String[] args) {
        Javapad jp = new Javapad();
    }
}