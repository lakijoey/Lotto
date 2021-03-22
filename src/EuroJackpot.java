import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class EuroJackpot {

    public static ArrayList<Integer> getHetiSzamok() {
        ArrayList<Integer> heti = new ArrayList<>();
        do {
            int number = (int) ((Math.random() * 50) + 1);
            if (!heti.contains(number)) {
                heti.add(number);
            }
        } while (heti.size() != 5);
            heti.add((int) ((Math.random() * 10) + 1));
        do {
            int number = (int) ((Math.random() * 10) + 1);
            if (heti.get(5) != number){
                heti.add(number);
            }
        } while (heti.size() != 7);
        return heti;
    }

    public static void checkWinning() {

        ArrayList<Integer> weeklynumbers = getHetiSzamok();
        int counter = 0;
        int counterB = 0;
        for (int i = 0; i < 5; i++) {
            if (Player.player.aField.contains(weeklynumbers.get(i))) {
                counter++;
                System.out.print("\u001B[31m" + weeklynumbers.get(i) + " ");
            } else {
                System.out.print("\u001B[0m" + weeklynumbers.get(i) + " ");
            }
        }
        System.out.print("  -  ");
        for (int i = 5; i < 7; i++) {
            if (Player.player.bField.contains(weeklynumbers.get(i))) {
                counterB++;
                System.out.print("\u001B[31m" + weeklynumbers.get(i) + " ");
            } else {
                System.out.print("\u001B[0m" + weeklynumbers.get(i) + " ");
            }
        }
        System.out.println("\u001B[0m");
        UserInterface.euroResults.put(counter, counterB);
    }


    public static void runAGame() {
        int x = UserInterface.askHowManyRounds();
        UserInterface.getUserNumbers(8);
        for (int i = 0; i < x; i++) {
            getHetiSzamok();
            checkWinning();
        }
        UserInterface.statistics(0,0);
    }


}
