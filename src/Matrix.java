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

public class Matrix extends JFrame {

    private JTextArea textArea;
    private int row = 0;

    public Matrix() {
        setTitle("The Matrix");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setFont(new Font("Monospaced", Font.PLAIN, 15));
        textArea.setForeground(Color.GREEN);
        textArea.setBackground(Color.BLACK);

        add(textArea);
        setVisible(true);

        new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(150);
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < textArea.getWidth() / 6; i++) {
                        int x = (int) (Math.random() * 2);
                        if (x == 0) {
                            sb.append("0");
                        } else {
                            sb.append("1");
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
        new Matrix();
    }
}
