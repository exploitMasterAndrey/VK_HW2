package util;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import logger.FileLogger;
import logger.LoggerClass;
import module.Module;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class Application {
    @Inject
    private LoggerClass logger;

    public static int count = 0;

    public static void main(String[] args) {
        final Injector injector = Guice.createInjector(new Module(args[0]));
        injector.getInstance(Application.class).waitForInput(args);
    }

    public void waitForInput(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Waiting for new lines. Key in Ctrl+D to exit.");
            if (args[0].equals("-c")){
                while (true) {
                    logger.log(scanner.nextLine(), "");
                }
            }
            else if(args[0].equals("-f") || args[0].equals("-cf")){
                if (args.length != 2) throw new IllegalArgumentException("No format argument detected :(");
                while (true) {
                    logger.log(scanner.nextLine(), "<" + args[1] + ">%s" + "</" + args[1] + ">");
                }
            }
            else throw new IllegalArgumentException("No such allowed argument :(");

        } catch (IllegalStateException | NoSuchElementException e) {
        }
    }
}
