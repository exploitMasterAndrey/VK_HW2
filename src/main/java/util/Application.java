package util;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import logger.LoggerClass;
import module.Module;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class Application {
    @Inject
    private LoggerClass logger;

    public static int count = 0;

    public static void main(String[] args) {
        final Injector injector = Guice.createInjector(new Module(args));
        injector.getInstance(Application.class).waitForInput();
    }

    public void waitForInput() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Waiting for new lines. Key in Ctrl+D to exit.");
            while (true){
                logger.log(scanner.nextLine());
            }

        } catch (IllegalStateException | NoSuchElementException e) {
        }
    }
}
