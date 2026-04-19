package Background;

import DB.DBConnection;
import java.sql.*;
import java.time.LocalTime;

import Controllers.Controllers;

public class Background extends Thread {

    @Override
    public void run() {

        while (true) {
            try (Connection conn = DBConnection.connect()) {

                String currentTime = LocalTime.now()
                        .withSecond(0)
                        .withNano(0)
                        .toString();

                String sql = """
                    SELECT m.med_name
                    FROM Medication_Schedule s
                    JOIN Medication_Info m ON s.medication_id = m.id
                    WHERE s.time = ? AND s.status = 'Active'
                """;

                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setString(1, currentTime);

                ResultSet rs = stmt.executeQuery();

                while (rs.next()) {
                    String medName = rs.getString("med_name");

                    
                    DefaultController.showDefaultView();

                    
                    Notification.show("Time to take: " + medName);
                }

                Thread.sleep(60000); 

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}