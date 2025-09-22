package paal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.SwingUtilities;

public class TestApp {

    public static void main(String[] args) {
        /*
         *  Setup: Daten werden aus der DB gelesen, um den User zu erstellen:
         */

        // Benutzer bestimmen:
        String usrID = "1"; // => Ev. abhängig von einer Eingabe machen

        // Verbindungsdaten zur DB (weiter unten gebraucht):
        String url = "jdbc:mysql://localhost:3306/paal";
        String username = ""; // eigenen username
        String password = ""; // eigenes PW ergänzen

        // Veriablen vorbereiten und Userdaten aus der DB laden:
        String lName = "";
        String fName = "";
        String bDate = "";
        int exP = 0;
        int level = 0;

        String sqlGetUsrData = "SELECT * FROM User WHERE usrID = ?";
        try (Connection connection = DriverManager.getConnection(url, username, password);
             PreparedStatement preparedStatement = connection.prepareStatement(sqlGetUsrData)) {

            preparedStatement.setString(1, usrID);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                lName = resultSet.getString("usrName");
                fName = resultSet.getString("usrFName");
                bDate = resultSet.getString("usrBDate");
                exP = resultSet.getInt("usrExP");
                level = resultSet.getInt("usrLevel");
            }
        }
        catch (SQLException e) {
            System.err.println("Fehler: " + e.getMessage());
        }

        // User anhand der Daten erstellen und dem UserManager zuweisen:
        User newUser = new User(lName, fName, bDate, exP, level);

        UserManager.setUser(newUser);
        User User = UserManager.getUser();

        // Test: User printen
        System.out.println(User);

        // Daten auslesen und SUnits erstellen und dem User hinzufügen:
        String sqlGetSuData = "SELECT * FROM StudyUnit WHERE usrID = ?";
        try (Connection connection = DriverManager.getConnection(url, username, password);
             PreparedStatement preparedStatement = connection.prepareStatement(sqlGetSuData)) {

            preparedStatement.setString(1, usrID);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int durH = resultSet.getInt("suHours");
                int durM = resultSet.getInt("suMin");
                String date = resultSet.getString("suDate");
                int dur = durH * 60 + durM;
                StudyUnit sU = new StudyUnit(dur, date, User);
                User.studyUnits.add(sU);
            }
        }
        catch (SQLException e) {
            System.err.println("Fehler: " + e.getMessage());
        }

        // Test: studyUnits printen
        User.printSUnits();

        // Daten auslesen, Cards erstellen und dem User hinzufügen:
        String sqlGetCrdData = "SELECT * FROM Card WHERE usrID = ?";
        try (Connection connection = DriverManager.getConnection(url, username, password);
             PreparedStatement preparedStatement = connection.prepareStatement(sqlGetCrdData)) {

            preparedStatement.setString(1, usrID);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String name = resultSet.getString("crdName");
                int quant = resultSet.getInt("crdQuant");
                if (name.equals("JGreed")) {
                    JGreed crd  = new JGreed(name, quant);
                    User.cards.add(crd);
                }
                else if (name.equals("JMercy")) {
                    JMercy crd = new JMercy(name, quant);
                    User.cards.add(crd);
                }
            }
        }
        catch (SQLException e) {
            System.err.println("Fehler: " + e.getMessage());
        }

        // Test: cards printen
        User.printCards();

        SwingUtilities.invokeLater(() -> {
            StudyTimer timerGUI = new StudyTimer(10, 0, User);
            timerGUI.setVisible(true);
        });
    }
}
