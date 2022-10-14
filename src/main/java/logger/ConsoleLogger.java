package logger;

import com.google.inject.Singleton;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.logging.Level;

@Singleton
public class ConsoleLogger implements LoggerClass{
    private final Logger consoleLogger = LoggerFactory.getLogger(ConsoleLogger.class);

    @Override
    public void waitForInput() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Waiting for new lines. Key in Ctrl+D to exit.");
            while (true) {
                String line = scanner.nextLine();
                consoleLogger.info(line);
            }
        } catch (IllegalStateException | NoSuchElementException e) {
        }
    }
}
