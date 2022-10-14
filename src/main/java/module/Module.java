package module;

import com.google.inject.AbstractModule;
import logger.ConsoleLogger;
import logger.FileConsoleLogger;
import logger.FileLogger;
import logger.LoggerClass;

public class Module extends AbstractModule {
    private String param;

    public Module(String param){
        super();
        this.param = param;
    }

    @Override
    protected void configure() {
        switch (param){
            case ("-c"):
                bind(LoggerClass.class).to(ConsoleLogger.class);
                break;
            case ("-f"):
                bind(LoggerClass.class).to(FileLogger.class);
                break;
            case ("-cf"):
                bind(LoggerClass.class).to(FileConsoleLogger.class);
                break;
        }
    }
}
