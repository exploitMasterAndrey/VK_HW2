package logger;

import com.google.inject.Singleton;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import util.Application;

@Singleton
public class FileConsoleLogger implements LoggerClass{
    private final Logger consoleLogger = LoggerFactory.getLogger(ConsoleLogger.class);
    private final Logger fileLogger = LoggerFactory.getLogger(FileLogger.class);

    @Override
    public void log(String message, String format){
        consoleLogger.info(++Application.count + ". " + message);
        fileLogger.info(String.format(++Application.count + ". " + format, message));
    }
}
