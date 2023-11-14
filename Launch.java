import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Launch {
    JPanel panel;
    JFrame frame = new JFrame();
    private JButton newQuiz;
    private JButton scoreTracker;

    Launch() {
        frame.add(panel);
        frame.setContentPane(this.panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300,100);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        newQuiz.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                Quiz a = new Quiz();
            }
        });
        scoreTracker.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                ScoreTracker b = new ScoreTracker();
            }
        });
    }
}
