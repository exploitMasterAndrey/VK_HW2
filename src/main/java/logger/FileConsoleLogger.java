package logger;

import com.google.inject.Singleton;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.logging.Level;

@Singleton
public class FileConsoleLogger implements LoggerClass{
    private final Logger consoleFileLogger = LoggerFactory.getLogger(FileConsoleLogger.class);

    @Override
    public void log(String message){
        consoleFileLogger.info(message);
    }
}
