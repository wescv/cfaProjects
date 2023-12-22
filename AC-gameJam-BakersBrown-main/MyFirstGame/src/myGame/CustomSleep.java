package myGame;

public class CustomSleep {
        public static void customSleep(long milliseconds) {
            try {
                Thread.sleep(milliseconds);
            } catch (InterruptedException e) {
                // Ignore the exception without any handling
            }
        }
    }
