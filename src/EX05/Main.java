package EX05;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class Main extends JFrame {
    private int count = 0;
    private JLabel countLabel;
    private Random rng = new Random();

    public Main() {
        setTitle("EX05");
        setSize(300, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        Box box = Box.createVerticalBox();
        add(box, BorderLayout.CENTER);

        // COUNT

        JPanel countPanel = new JPanel();
        countPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        JButton countDecrementButton = new JButton("--");
        countDecrementButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                decrementCount();
            }
        });
        
        JButton countIncrementButton = new JButton("++");
        countIncrementButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                incrementCount();
            }
        });

        countLabel = new JLabel(" " + count + " ");
        countLabel.setFont(countLabel.getFont().deriveFont(Font.BOLD, 64f));

        countPanel.add(countDecrementButton);
        countPanel.add(countLabel);
        countPanel.add(countIncrementButton);

        // WINDOW

        box.add(Box.createVerticalGlue());
        box.add(countPanel);
        box.add(Box.createVerticalGlue());

        setVisible(true);
    }

    private synchronized void decrementCount() {
        try {
            // Sleep para teste
            Thread.sleep(0);
            count -= rng.nextInt(9) + 1;
            // System.out.println(count);
            countUpdateLabel();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    private synchronized void incrementCount() {
        try {
            // Sleep para teste
            Thread.sleep(0);
            count += rng.nextInt(9) + 1;
            // System.out.println(count);
            countUpdateLabel();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    private void countUpdateLabel() {
        countLabel.setText(" " + count + " ");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Main();
            }
        });
    }
}