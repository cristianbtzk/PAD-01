package EX04;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main extends JFrame {
    private int countA, countB = 0;
    private JLabel countALabel, countBLabel;
    private Thread threadA, threadB;
    private boolean runningA = false, runningB = false;

    public Main() {
        setTitle("EX04");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        Box box = Box.createVerticalBox();
        add(box, BorderLayout.CENTER);

        // COUNT A

        threadA = new Thread(new CountRunnable('A'));
        threadA.start();

        JPanel countAPanel = new JPanel();
        countAPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        JButton countAStartButton = new JButton("Start A");
        JButton countAPauseButton = new JButton("Pause A");
        JButton countAStopButton = new JButton("Stop A");

        countAStartButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                runningA = true;
                countAStartButton.setEnabled(false);
                countAPauseButton.setEnabled(true);
                countAStopButton.setEnabled(true);
            }
        });

        countAPauseButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                runningA = false;
                countAPauseButton.setEnabled(false);
                countAStartButton.setEnabled(true);
            }
        });
        countAPauseButton.setEnabled(false);

        countAStopButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                runningA = false;
                countAPauseButton.setEnabled(false);
                countAStopButton.setEnabled(false);
                countAStartButton.setEnabled(true);
                countA = 0;
                countAUpdateLabel();
            }
        });
        countAStopButton.setEnabled(false);

        countALabel = new JLabel(" " + countA + " ");
        countALabel.setFont(countALabel.getFont().deriveFont(Font.BOLD, 64f));

        countAPanel.add(countAStartButton);
        countAPanel.add(countAPauseButton);
        countAPanel.add(countAStopButton);
        countAPanel.add(countALabel);

        // COUNT B

        threadB = new Thread(new CountRunnable('B'));
        threadB.start();

        JPanel countBPanel = new JPanel();
        countBPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        JButton countBStartButton = new JButton("Start B");
        JButton countBPauseButton = new JButton("Pause B");
        JButton countBStopButton = new JButton("Stop B");

        countBStartButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                runningB = true;
                countBStartButton.setEnabled(false);
                countBPauseButton.setEnabled(true);
                countBStopButton.setEnabled(true);
                
            }
        });

        countBPauseButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                runningB = false;
                countBPauseButton.setEnabled(false);
                countBStartButton.setEnabled(true);
            }
        });
        countBPauseButton.setEnabled(false);

        countBStopButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                runningB = false;
                countBPauseButton.setEnabled(false);
                countBStopButton.setEnabled(false);
                countBStartButton.setEnabled(true);
                countB = 0;
                countBUpdateLabel();
            }
        });
        countBStopButton.setEnabled(false);

        countBLabel = new JLabel(" " + countB + " ");
        countBLabel.setFont(countBLabel.getFont().deriveFont(Font.BOLD, 64f));

        countBPanel.add(countBStartButton);
        countBPanel.add(countBPauseButton);
        countBPanel.add(countBStopButton);
        countBPanel.add(countBLabel);

        // WINDOW

        box.add(Box.createVerticalGlue());
        box.add(countAPanel);
        box.add(Box.createVerticalGlue());
        box.add(countBPanel);
        box.add(Box.createVerticalGlue());

        setVisible(true);
    }

    private void countAUpdateLabel() {
        countALabel.setText(" " + countA + " ");
    }

    private void countBUpdateLabel() {
        countBLabel.setText(" " + countB + " ");
    }

    class CountRunnable implements Runnable {
        private char counterId;

        public CountRunnable(char counterId) {
            this.counterId = counterId;
        }

        public void run() {
            try {
                while (true) {
                    if (counterId == 'A' && runningA) {
                        countA++;
                        countAUpdateLabel();
                    } else if (counterId == 'B' && runningB) {
                        countB++;
                        countBUpdateLabel();
                    }
                    Thread.sleep(1000);
                }
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Main();
            }
        });
    }
}
