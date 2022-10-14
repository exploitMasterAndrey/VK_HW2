package logger;

import com.google.inject.Singleton;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.logging.Level;

@Singleton
public class FileLogger implements LoggerClass{
    private final Logger fileLogger = LoggerFactory.getLogger(FileLogger.class);
    @Override
    public void waitForInput() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Waiting for new lines. Key in Ctrl+D to exit.");
            while (true) {
                fileLogger.info(scanner.nextLine());
            }
        } catch (IllegalStateException | NoSuchElementException e) {
        }
    }
}
