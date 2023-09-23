package org.example;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.ServerSocket;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class CommonSettingsTest {
    private static final String file = "settings.ini";

    @Test
    void testGetPortFromFile() throws IOException {
        new ClientHandler(CommonSettings.getPortFromFile(file));
    }

    @Test
    void testGetDateAndTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = sdf.format(new Date());
    }

    @Test
    void testLog() {
        Path file = Path.of("file.log");
        boolean isRegularExecutableFile = Files.isRegularFile(file) &
                Files.isReadable(file) & Files.isExecutable(file);
    }
}