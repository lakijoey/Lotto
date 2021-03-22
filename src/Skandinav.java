import java.util.ArrayList;
import java.util.Collections;

public class Skandinav {
    public static ArrayList<Integer> getHetiSzamok() {
        ArrayList<Integer> heti = new ArrayList<>();
        do {
            int number = (int) ((Math.random() * 35) + 1);
            if (!heti.contains(number)) {
                heti.add(number);
            }
        } while (heti.size() != 7);
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
            case 6:
                UserInterface.results.add(6);
                break;
            case 7:
                UserInterface.results.add(7);
                break;
            default:
                UserInterface.results.add(0);
        }
    }


    public static void runAGame() {
        int x = UserInterface.askHowManyRounds();
        UserInterface.getUserNumbers(7);
        for (int i = 0; i < x; i++) {
            getHetiSzamok();
            checkWinning();
        }
        UserInterface.statistics(4, 7);
    }
}
