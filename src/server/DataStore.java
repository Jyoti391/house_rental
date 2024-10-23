package server;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DataStore {

    private static final String DATA_FILE = "user_data.txt";

    // Method to save user data to a file
    public void saveUserData(String name, String email, String phone, String address, String password) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(DATA_FILE, true))) {
            writer.write(name + "," + email + "," + phone + "," + address + "," + password);
            writer.newLine();
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Method to read user data from the file
    public List<String[]> readUserData() {
        List<String[]> userDataList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(DATA_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] userData = line.split(",");
                userDataList.add(userData);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return userDataList;
    }
}
