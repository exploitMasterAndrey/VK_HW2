package util;

import com.google.inject.Guice;
import com.google.inject.Injector;
import logger.LoggerClass;
import module.Module;

public class Main {
    public static void main(String[] args){
        final Injector injector = Guice.createInjector(new Module(args[0]));
        injector.getInstance(LoggerClass.class).waitForInput();
    }
}
