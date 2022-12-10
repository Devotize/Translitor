import interactors.TextTranslator;
import interactors.TextTranslitor;

import java.util.Scanner;
import java.util.concurrent.atomic.AtomicReference;


public class Main {

    private static boolean isRunning = false;

    private static final Scanner scanner = new Scanner(System.in);

    private static final String EXIT_WORDKEY = "system_exit";

    private static boolean isLoading = false;

    private static final AtomicReference<String> lastPrintedMessage = new AtomicReference<>("");


    public static void main(String[] args) {
        isRunning = true;

        printInitialMassage();

        while (isRunning) {
            System.out.print("Enter your sentence -> ");
            String text = scanner.nextLine();
            if (text.equals(EXIT_WORDKEY)) {
                stop();
                return;
            }
            showLoading();
            String translatedText = TextTranslator.execute(text);
            hideLoading();
            System.out.println("Translated text: " + translatedText);
            String traslitedText = TextTranslitor.execute(translatedText);
            System.out.println("Translited text: " + traslitedText);
        }

    }

    public static void printInitialMassage() {
        String message = String.format("To stop program type \"%s\"", EXIT_WORDKEY);
        System.out.println(message);
    }

    public static void showLoading() {
        isLoading = true;
        final String message = "Transliting in process";
        new Thread(() -> {
            while (isLoading) {
                lastPrintedMessage.set(message + ".");
                System.out.print(lastPrintedMessage);
                delay(10L);
                clearLastRowFromConsole(lastPrintedMessage.toString());
                lastPrintedMessage.set(message + "..");
                System.out.print(lastPrintedMessage);
                delay(10L);
                clearLastRowFromConsole(lastPrintedMessage.toString());
                lastPrintedMessage.set(message + "...");
                System.out.print(lastPrintedMessage);
                delay(10L);
                clearLastRowFromConsole(lastPrintedMessage.toString());
            }
        }).start();
    }

    private static void clearLastRowFromConsole(String text) {
        StringBuilder sb = new StringBuilder();
        for (char symbol : text.toCharArray()) {
            sb.append("\b");
        }
        System.out.print(sb);
    }

    private static void delay(Long timeInMillis) {
        try {
            Thread.sleep(timeInMillis);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void hideLoading() {
        isLoading = false;
        clearLastRowFromConsole(lastPrintedMessage.toString());
    }

    private static void stop() {
        isRunning = false;
    }

}