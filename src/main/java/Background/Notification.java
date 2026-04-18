package Background;
import javax.swing.JOptionPane;

public class Notification {

    public static void showNotification(String message) {
        JOptionPane.showMessageDialog(
                null,
                message,
                "Reminder: (...)",
                JOptionPane.INFORMATION_MESSAGE
        );
    }
}
