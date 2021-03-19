package hu.nive.ujratervezes.zarovizsga.workhours;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;


public class WorkHours {

    public String minWork(String file) {
        try (BufferedReader reader = Files.newBufferedReader(Path.of(file))) {
            return getResult(reader);
        } catch (
                IOException ioe) {
            throw new IllegalStateException("Can not read file", ioe);
        }
    }

    private String getResult(BufferedReader reader) throws IOException {
        String line;
        int minHours = 25;
        Workday wd = null;
        while ((line = reader.readLine()) != null) {
            int actHours = Integer.parseInt(line.split(",")[1]);
            if (minHours > actHours) {
                minHours = actHours;
                wd = new Workday(line.split(",")[0], actHours, line.split(",")[2]);
            }
        }
        return wd.toString();
    }
}
