import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import javax.sound.sampled.*;

public class Quiz {
    private JButton checkButton;
    private JButton replayAudioButton;
    private JTextField answerField;
    private JButton endButton;
    private JButton nextButton;
    private JLabel displayScore;
    JFrame frame = new JFrame();
    JPanel panel;
    private JLabel questionGenerator;
    private JButton submitQuestions;
    public JTextField questionInput;

    private JLabel char2;
    private JLabel char3;
    private JLabel char4;
    private JLabel char5;
    private JLabel char6;
    private JLabel char7;
    private JLabel char13;
    private JLabel char8;
    private JLabel char12;
    private JLabel char11;
    private JLabel char10;
    private JLabel char9;
    private JLabel char14;
    private JLabel char15;
    private JLabel char16;
    private JLabel char1;
    private JLabel char17;
    private JButton finishButton;

    int numOfQuestion;
    int correctAnswers = 0;
    //int[] ints;
    JLabel[] label = {char1,char2,char3,char4,char5,char6,char7,char8,char9,char10,
            char11,char12,char13,char14,char15,char16,char17};
    ArrayList<String> questionNumbers = new ArrayList<String>();
    ArrayList<Character> red = new ArrayList<Character>();
    ArrayList<Character> green = new ArrayList<Character>();
    String currentSentence;
    String currentAudio;
    String[][] list = {{"1","彼は医者になりました","src/bloop/1.wav"},{"2","彼女は三人の子供の母親だ","src/bloop/2.wav"},{"3","野球は九人で１チームです","src/bloop/3.wav"},
            {"4","ソフトクリームを二つください","src/bloop/4.wav"},{"5","その子は指で十数えました","src/bloop/5.wav"},{"6","千円貸してください","src/bloop/6.wav"},{"7","この靴は一万円です","src/bloop/7.wav"},{"8","そこに大きな円を描いて","src/bloop/8.wav"},{"9","カレーライスは700円です","src/bloop/9.wav"},{"10","友達と一緒に宿題をした","src/bloop/10.wav"},
            {"11","手紙が届くのに三日かかりました","src/bloop/11.wav"},{"12","彼は荷物を網棚に上げた","src/bloop/12.wav"},{"13","今週は日本語のテストがあります","src/bloop/13.wav"},{"14","猫が屋根に上っている","src/bloop/14.wav"},{"15","財布は机の下にあった","src/bloop/15.wav"},{"16","彼は会社の近くに住んでいる","src/bloop/16.wav"},
            {"17","彼はクラスで一番背が高い","src/bloop/17.wav"},{"18","この紙を半分に切ってください","src/bloop/18.wav"},{"19","駅からはタクシーに乗ってください","src/bloop/19.wav"},{"20","姉は銀行で働いています","src/bloop/20.wav"},{"21","新しいテーブルを買いました","src/bloop/21.wav"},{"22","お母さんによろしくお伝えください","src/bloop/22.wav"}
            ,{"23","お腹が空きました","src/bloop/23.wav"},{"24","兄は水泳が得意です","src/bloop/24.wav"},{"25","ご主人はお元気ですか","src/bloop/25.wav"},{"26","別の本も見せてください","src/bloop/26.wav"},{"27","電気をつけてください","src/bloop/27.wav"},{"28","冷たい飲み物をください","src/bloop/28.wav"},{"29","僕は学生です","src/bloop/29.wav"}
            ,{"30","柿の木に実がたくさんなっています","src/bloop/30.wav"},{"31","これからより一層努力します","src/bloop/31.wav"},{"32","私は九月に行く予定です","src/bloop/32.wav"},{"33","世界人口は65億人だ","src/bloop/33.wav"},{"34","柿の木に実がたくさんなっています","src/bloop/34.wav"},{"35","先月、友達の結婚式があった","src/bloop/35.wav"}
            ,{"36","彼はロボットの研究をしています","src/bloop/36.wav"},{"37","彼はパソコンを2台持っています","src/bloop/37.wav"},{"38","受付でプログラムを受け取った","src/bloop/38.wav"},{"39","少し音量を下げてください","src/bloop/39.wav"},{"40","小さな船が川を下っています","src/bloop/40.wav"},{"41","ここは一方通行です","src/bloop/41.wav"},{"42","棚からその箱を下ろしてください","src/bloop/42.wav"}
            ,{"43","今日は妻と二人で食事をします","src/bloop/43.wav"},{"44","あの村の人々はとても親切です","src/bloop/44.wav"},{"45","休日は家でよくテレビを見ます","src/bloop/45.wav"},{"46","このプロジェクトにはみんなの協力が必要です","src/bloop/46.wav"},{"47","私は歌が下手だ","src/bloop/47.wav"},{"48","このバンドはとても人気があるよ","src/bloop/48.wav"},{"49","お菓子を友達に半分あげた","src/bloop/49.wav"},{"50","親子の会話は大切です","src/bloop/50.wav"}
    };

    Quiz() {
        for (JLabel x : label) {
            x.setVisible(false);
        }
        questionGenerator.setText("Please enter the number of questions: ");
        questionGenerator.setSize(100,20);
        displayScore.setVisible(false);
        finishButton.setVisible(false);
        //answerField.setFont(new Font("Serif", Font.PLAIN,20));
        displayScore.setFont(new Font("Serif", Font.PLAIN,20));
        frame.add(panel);
        frame.setContentPane(this.panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1500,200);
        //frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        replayAudioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playSound();
            }
        });
        endButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                Launch l = new Launch();
            }
        });
        finishButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });
        checkButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                check();

                if (questionNumbers.size() == 0) {
                    saveScore(getDate(), correctAnswers, numOfQuestion, "src/bloop/scoresheet.csv");
                    displayScore.setText("Score: " + correctAnswers + "/" + numOfQuestion);
                    displayScore.setVisible(true);
                }
            }
        });
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playQuestion();
                clear();

                if (questionNumbers.size() == 0) {
                    clear();
                    nextButton.setEnabled(false);
                    finishButton.setVisible(true);
                }
            }
        });

        submitQuestions.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                submitQuestions.setEnabled(false);
                questionInput.setEnabled(false);
                numOfQuestion = Integer.parseInt(questionInput.getText());
                int[] ints = new Random().ints(1, 49).distinct().limit(numOfQuestion).toArray();
                for (int i = 0; i < ints.length; i++) {
                    questionNumbers.add(String.valueOf(ints[i]));
                }
                playQuestion();

                System.out.println(Arrays.toString(ints));
                System.out.println(questionNumbers);
            }
        });
    }

    public void playSound() {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(currentAudio));
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        }
        catch(Exception e)  {
            e.printStackTrace();
        }
    }

    public void playQuestion() {
        for (int i=0; i < list.length-1; i++) {
            if (list[i][0].equals(questionNumbers.get(0))) {
                currentSentence = list[i][1];
                currentAudio = list[i][2];
                System.out.println(currentSentence);
            }
        }
        playSound();
        questionNumbers.remove(0);
        System.out.println(questionNumbers);
    }

    public void saveScore(String date, int score, int total, String filepath) {
        try {
            FileWriter fw = new FileWriter(filepath, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);

            pw.println(date + "," + score + "/" + total);
            pw.flush();
            pw.close();
        } catch(Exception e) {
            System.out.println("Score not saved.");
        }
    }

    public void check() {
        String input = answerField.getText();
        char[] charAnswer = currentSentence.toCharArray();
        char[] charInput = input.toCharArray();
        if (charAnswer.length == charInput.length) {
            for (int i = 0; i < charInput.length; i++) {
                if (charAnswer[i] == charInput[i]) {
                    green.add(charAnswer[i]);
                } else {
                    red.add(charAnswer[i]);
                }
            }
        } else if (charInput.length > charAnswer.length) {
            for (int i = 0; i < charAnswer.length; i++) {
                if (charAnswer[i] == charInput[i]) {
                    green.add(charAnswer[i]);
                } else {
                    red.add(charAnswer[i]);
                }
            }
        } else if (charInput.length < charAnswer.length) {
            System.out.println(charAnswer.length);
            System.out.println(charInput.length);
            int leftover = charAnswer.length - charInput.length;
            for (int i = 0; i < charInput.length; i++) {
                if (charAnswer[i] == charInput[i]) {
                    green.add(charAnswer[i]);
                } else {
                    red.add(charAnswer[i]);
                }
            }
            for (int j = charAnswer.length-leftover; j < charAnswer.length; j++) {
                red.add(charAnswer[j]);
            }
        }

        if (red.isEmpty()) {
            correctAnswers += 1;
        }
        for (int i = 0; i < currentSentence.length(); i++) {
            if (red.contains(charAnswer[i])) {
                label[i].setText(String.valueOf(charAnswer[i]));
                label[i].setForeground(new Color(255, 0, 0));
            } else {
                label[i].setText(String.valueOf(charAnswer[i]));
                label[i].setForeground(new Color(102, 204, 0));
            }
        }

        for (JLabel x : label) {
            if (!x.getText().equals("Label")) {
                x.setFont(new Font("Serif", Font.PLAIN, 20));
                x.setVisible(true);
            }
        }
    }


    public String getDate() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDateTime now = LocalDateTime.now();
        return dtf.format(now);
    }

    public void clear() {
        answerField.setText("");
        for (int i = 0; i < label.length; i++) {
            label[i].setText("");
        }
    }
}

//PROGRESS: testing score tracker, is it going on the csv file ???
