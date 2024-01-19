import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class General {
    private static final long serialVersionUID = 2846962135845015368L;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void divider() {
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------");
    }

    public static void spacing() { System.out.println("\n\n"); }

    public static int readOption(int start, int end) {
        int option;

        do {
            System.out.print("Resposta: ");
            option = Ler.umInt();
            System.out.println();
        } while (option < start && option > end);

        return option;
    }

    public static int readSelect(ArrayList<Integer> listOfIntegers, String message) {
        int option;

        do {
            option = Ler.umInt();
            System.out.println();

            if (!listOfIntegers.contains(option)) {
                System.out.println(message);
            }
        } while (!listOfIntegers.contains(option));

        return option;
    }

    public static int countDays(Date fromDate, Date toDate) {
        long dateBeforeInMs = fromDate.getTime();
        long dateAfterInMs = toDate.getTime();

        long timeDiff = Math.abs(dateAfterInMs - dateBeforeInMs);

        long daysDiff = TimeUnit.DAYS.convert(timeDiff, TimeUnit.MILLISECONDS);

        return (int)daysDiff;
    }

   
    
}
