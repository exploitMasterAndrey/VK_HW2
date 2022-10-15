package module;

import com.google.inject.AbstractModule;
import logger.ConsoleLogger;
import logger.FileConsoleLogger;
import logger.FileLogger;
import logger.LoggerClass;
import org.slf4j.Logger;

public class Module extends AbstractModule {
    private String[] params;

    public Module(String[] params){
        super();
        this.params = params;
    }

    @Override
    protected void configure() {
        switch (params[0]){
            case ("-c"):
                bind(LoggerClass.class).toInstance(new ConsoleLogger(""));
                break;
            case ("-f"):
                if (params.length != 2) throw new IllegalArgumentException("There is no additional argument :(");
                bind(LoggerClass.class).toInstance(new FileLogger(params[1]));
                break;
            case ("-cf"):
                if (params.length != 2) throw new IllegalArgumentException("There is no additional argument :(");
                bind(LoggerClass.class).toInstance(new FileConsoleLogger(params[1]));
                break;
            default:
                throw new IllegalArgumentException("No available args provided :(");
        }
    }
}
