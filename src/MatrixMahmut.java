import java.awt.*;
import javax.swing.*;

/**
 * Purpose of this build is fun :)
 * @author mahmut Under
 * @Version 1.0
 * The Matrix
 *
 * @Date 2021
 */


public class MatrixMahmut extends JFrame {

    private JTextArea textArea;
    private int row = 0;

    public MatrixMahmut() {
        setTitle("Matrix Mahmut");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setFont(new Font("Monospaced", Font.PLAIN, 20));
        textArea.setForeground(Color.GREEN);
        textArea.setBackground(Color.BLACK);

        add(textArea);
        setVisible(true);

        new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(50);
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < textArea.getWidth() / 4; i++) {
                        int x = (int) (Math.random() * 10);
                        if (x == 0) {
                            sb.append("M");
                        } else if (x == 1) {
                            sb.append("a");
                        } else if (x == 2) {
                            sb.append("h");
                        } else if (x == 3) {
                            sb.append("m");
                        } else if (x == 4) {
                            sb.append("u");
                        } else if (x == 5) {
                            sb.append("t");
                        } else {
                            int y = (int) (Math.random() * 4);
                            if (y == 0) {
                                sb.append("0");
                            } else if(y==1) {
                                sb.append("1");
                            }else{
                                sb.append(" ");
                            }
                        }
                    }
                    textArea.append(sb + "\n");
                    row++;
                    if (row * 12 >= textArea.getHeight()) {
                        textArea.setText("");
                        row = 0;
                    }
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        }).start();
    }

    public static void main(String[] args) {
        new MatrixMahmut();
    }
}
