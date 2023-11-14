import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class ScoreTracker {
    JFrame f;
    JTable j;
    Container contentPane;
    JButton button;
    String[][] data;
    int index = 0;

    ScoreTracker() {
        f = new JFrame();
        f.setTitle("Score History");
        contentPane = f.getContentPane();

        button = new JButton();
        button.setBounds(100,100,50,20);
        button.setText("Back to Main Menu");
        button.setFocusable(true);
        button.setSize(10,10);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.dispose();
                Launch l = new Launch();
            }
        });

        data = new String[100][100];

        String file = "src/bloop/scoresheet.csv";
        String line = "";

        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            while ((line = br.readLine()) != null) {
                    String[] files = line.split(",");
                    data[index][0] = files[0];
                    data[index][1] = files[1];
                    index++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        String[] columnNames = {"", ""};

        j = new JTable(data, columnNames);
        j.setBounds(30, 40, 200, 300);

        contentPane.setLayout(new BorderLayout());
        contentPane.add(new JScrollPane(j), BorderLayout.CENTER);
        contentPane.add(button, BorderLayout.SOUTH);
        f.setSize(500, 200);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }

}
