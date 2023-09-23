package org.example;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CommonSettings {
    static final String settingsFileName = "settings.ini";
    static final String logFileName = "file.log";
    static final String currentTime = CommonSettings.getDateAndTime();

    public static int getPortFromFile(String fileName) throws IOException {
        File file = new File(fileName);
        StringBuilder stringBuilder = new StringBuilder();
        try (FileReader fileReader = new FileReader(file)) {
            int c;
            while ((c = fileReader.read()) != -1) {
                stringBuilder.append((char) c);
            }
        }
        return Integer.parseInt(String.valueOf(stringBuilder));
    }

    public static String getDateAndTime() {
        String datePattern = "[dd-MMMM-yyyy]-[HH-mm-ss]";
        DateFormat d = new SimpleDateFormat(datePattern);
        Date today = Calendar.getInstance().getTime();
        String str = d.format(today);
        return str;
    }

    public static void log(String messageToLog) throws IOException {
        File file = new File(logFileName);
        FileWriter fileWriter = new FileWriter(file, true);
        fileWriter.write(messageToLog);
        fileWriter.close();
    }
}
