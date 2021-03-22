import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class OtosLotto {
    public static ArrayList<Integer> getHetiSzamok() {
        ArrayList<Integer> heti = new ArrayList<>();
        do {
            int number = (int) ((Math.random() * 90) + 1);
            if (!heti.contains(number)) {
                heti.add(number);
            }
        } while (heti.size() != 5);
        return heti;
    }

    public static void checkWinning() {
        ArrayList<Integer> weeklynumbers = getHetiSzamok();
        int counter = 0;
        Collections.sort(weeklynumbers);
        for (int i = 0; i < weeklynumbers.size(); i++) {
            if (Player.player.aField.contains(weeklynumbers.get(i))) {
                counter++;
                System.out.print("\u001B[31m" + weeklynumbers.get(i) + " ");
            } else {
                System.out.print("\u001B[0m" + weeklynumbers.get(i) + " ");
            }
        }
        System.out.println();
        switch (counter) {
            case 2:
                UserInterface.results.add(2);
                break;
            case 3:
                UserInterface.results.add(3);
                break;
            case 4:
                UserInterface.results.add(4);
                break;
            case 5:
                UserInterface.results.add(5);
                break;
            default:
                UserInterface.results.add(0);
        }
    }


    public static void runAGame() {
        int x = UserInterface.askHowManyRounds();
        UserInterface.getUserNumbers(5);
        for (int i = 0; i < x; i++) {
            getHetiSzamok();
            checkWinning();
        }
        UserInterface.statistics(2,5);
    }


}
