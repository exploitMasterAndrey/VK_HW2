package logger;

import com.google.inject.Singleton;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import util.Application;

@Singleton
public class ConsoleLogger implements LoggerClass{
    private final Logger consoleLogger = LoggerFactory.getLogger(ConsoleLogger.class);
    private final String format;

    public ConsoleLogger(String format) {
        this.format = "<" + format + ">" + "%s" + "</" + format + ">";
    }

    @Override
    public void log(String message){
        consoleLogger.info(++Application.count + ". " + message);
    }
}
