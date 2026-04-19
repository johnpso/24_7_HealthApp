package Background;

import javax.swing.JOptionPane;
import javax.sound.sampled.*;
import java.io.File;


public class Notification {
    
        JOptionPane.showMessageDialog(
                null,
                message,
                "24/7 Health Reminder",
                JOptionPane.INFORMATION_MESSAGE
        );

        
        playAlarm();
    }

    private static void playAlarm() {
        try {
            File soundFile = new File("resources/Alarm/alarm.wav");
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(soundFile);
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start();

        } catch (Exception e) {
            System.out.println("Could not play sound.");
            e.printStackTrace();

    
    }
}
