package module8;

import java.util.Random;

public class DanThreeThreads {
        public static void main(String[] args) {
            Thread lettersThread = new Thread(new LettersRunnable());
            Thread numbersThread = new Thread(new NumbersRunnable());
            Thread symbolsThread = new Thread(new SymbolsRunnable());

            lettersThread.start();
            numbersThread.start();
            symbolsThread.start();

            try {
                lettersThread.join();
                numbersThread.join();
                symbolsThread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    // Runnable for generating random letters
    class LettersRunnable implements Runnable {
        public void run() {
            Random random = new Random();
            StringBuilder builder = new StringBuilder();

            for (int i = 0; i < 10000; i++) {
                char letter = (char) (random.nextInt(26) + 'a'); // a-z
                builder.append(letter);
            }

            System.out.println("Letter:" + builder.toString());
        }
    }

    // Runnable for generating random numbers
    class NumbersRunnable implements Runnable {
        public void run() {
            Random random = new Random();
            StringBuilder builder = new StringBuilder();

            for (int i = 0; i < 10000; i++) {
                char number = (char) (random.nextInt(10) + '0'); // 0-9
                builder.append(number);
            }

            System.out.println("Number:" + builder.toString());
        }
    }

    // Runnable for generating random symbols
    class SymbolsRunnable implements Runnable {
        public void run() {
            Random random = new Random();
            char[] symbols = {'!', '@', '#', '$', '%', '&', '*'};
            StringBuilder builder = new StringBuilder();

            for (int i = 0; i < 10000; i++) {
                char symbol = symbols[random.nextInt(symbols.length)];
                builder.append(symbol);
            }

            System.out.println("Symbols:" + builder.toString());
        }
    }


