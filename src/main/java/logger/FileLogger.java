package logger;

import com.google.inject.Singleton;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import util.Application;

@Singleton
public class FileLogger implements LoggerClass{
    private final Logger fileLogger = LoggerFactory.getLogger(FileLogger.class);

    @Override
    public void log(String message, String format){
        fileLogger.info(String.format(++Application.count + ". " + format, message));
    }
}
