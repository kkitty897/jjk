import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Card extends JFrame {
    public Card() {
        setTitle("🎉 Birthday Surprise 🎉");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JLabel label = new JLabel("🎂 Happy Birthday! 🎂", SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 20));
        add(label, BorderLayout.CENTER);

        JButton button = new JButton("Click for a Surprise!");
        button.setFont(new Font("Arial", Font.BOLD, 16));
        add(button, BorderLayout.SOUTH);

        // Button opens the Catch the Ball game
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose(); // Close the card
                SwingUtilities.invokeLater(() -> new CatchTheBallGame()); // Start the game
            }
        });

        setLocationRelativeTo(null); // Center window
        setVisible(true);
    }

    public static void main(String[] args) {
        new Card(); // Start the card program
    }
}
