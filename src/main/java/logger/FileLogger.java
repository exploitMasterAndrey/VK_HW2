package logger;

import com.google.inject.Singleton;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import util.Application;

@Singleton
public class FileLogger implements LoggerClass{
    private final Logger fileLogger = LoggerFactory.getLogger(FileLogger.class);
    private final String format;

    public FileLogger(String format) {
        this.format = "<" + format + ">" + "%s" + "</" + format + ">";
    }

    @Override
    public void log(String message){
        fileLogger.info(String.format(++Application.count + ". " + this.format, message));
    }
}
