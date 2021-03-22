import java.util.*;

public class UserInterface {

    public static ArrayList<Integer> results = new ArrayList<>();
    public static HashMap<Integer, Integer> euroResults = new HashMap<>();

    public static int askHowManyRounds() {
        System.out.println("Hany kört nezzünk? ");
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }

    public static int askWhatGame() {
        Scanner sc = new Scanner(System.in);
        System.out.println("""
                Milyen játékot szeretnél játszani?\r
                5 - Otos Lotto\r
                6 - Hatos Lotto\r
                7 - Skandinav\r
                8 - EutoJackpot\r
                10 - Kilepes""");
        return sc.nextInt();
    }

    public static void getUserNumbers(int x) {
        int z = 0;
        if (x == 8) {
            x = 5;
            z = 2;
        }
        ArrayList<Integer> usernumbersB = new ArrayList<>();
        ArrayList<Integer> usernumbersA = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int y = 0;
        System.out.println("Kérek " + x + " különböző számot: ");
        do {
            y = sc.nextInt();
            if (!usernumbersA.contains(y)) {
                usernumbersA.add(y);
            } else {
                System.out.println("Elmondtam bazdmeg, hogy különböző legyen...");
            }
        } while (usernumbersA.size() != x);
        if (z == 2) {
            System.out.println("Kérek a 'B' mezőbe 2 különböző számot 1-10ig: ");
            do {
                y = sc.nextInt();
                if (!usernumbersB.contains(y) && y > 0 && y < 11) {
                    usernumbersB.add(y);
                } else {
                    System.out.println("Elmondtam bazdmeg, hogy különböző legyen...");
                }
            } while (usernumbersB.size() != 2);
        }
        System.out.println("Szamaid: ");
        System.out.print(usernumbersA + "    ");
        Player.player.setaField(usernumbersA);

        if (!usernumbersB.isEmpty()) {
            Player.player.setbField(usernumbersB);
            System.out.println(usernumbersB + "\r\n");
        } else {
            System.out.println("\r\n");
        }
    }


    public static void statistics(int min, int max) {
        System.out.println();
        ArrayList<Integer> ejResults = new ArrayList<>();
        System.out.println("Statisztika: ");
        if (max == 0) {
            for(Map.Entry ej : euroResults.entrySet()){
                if (ej.getKey().equals(2) && ej.getValue().equals(1)) {
                    ejResults.add(1);
                } else if (ej.getKey().equals(1) && ej.getValue().equals(2)){
                    ejResults.add(2);
                } else if (ej.getKey().equals(3) && ej.getValue().equals(0)){
                    ejResults.add(3);
                } else if (ej.getKey().equals(3) && ej.getValue().equals(1)){
                    ejResults.add(4);
                } else if (ej.getKey().equals(2) && ej.getValue().equals(2)){
                    ejResults.add(5);
                } else if (ej.getKey().equals(3) && ej.getValue().equals(2)){
                    ejResults.add(6);
                } else if (ej.getKey().equals(4) && ej.getValue().equals(0)){
                    ejResults.add(7);
                } else if (ej.getKey().equals(4) && ej.getValue().equals(1)){
                    ejResults.add(8);
                } else if (ej.getKey().equals(4) && ej.getValue().equals(2)){
                    ejResults.add(9);
                } else if (ej.getKey().equals(5) && ej.getValue().equals(0)){
                    ejResults.add(10);
                } else if (ej.getKey().equals(5) && ej.getValue().equals(1)){
                    ejResults.add(11);
                } else if (ej.getKey().equals(5) && ej.getValue().equals(2)){
                    ejResults.add(12);
                }
            }
            System.out.println("2+1: " + Collections.frequency(ejResults,1));
            System.out.println("1+2: " + Collections.frequency(ejResults,2));
            System.out.println("3+0: " + Collections.frequency(ejResults,3));
            System.out.println("3+1: " + Collections.frequency(ejResults,4));
            System.out.println("2+2: " + Collections.frequency(ejResults,5));
            System.out.println("3+2: " + Collections.frequency(ejResults,6));
            System.out.println("4+0: " + Collections.frequency(ejResults,7));
            System.out.println("4+1: " + Collections.frequency(ejResults,8));
            System.out.println("4+2: " + Collections.frequency(ejResults,9));
            System.out.println("5+0: " + Collections.frequency(ejResults,10));
            System.out.println("5+1: " + Collections.frequency(ejResults,11));
            System.out.println("5+2: " + Collections.frequency(ejResults,12));
        } else {
            for (int i = min; i < max; i++) {
                System.out.println(i + " talalat: " + Collections.frequency(results, i));
            }
        }
    }


    public static void gameLauncher(int x) {
        switch (x) {
            case 5:
                OtosLotto.runAGame();
                break;
            case 6:
                HatosLotto.runAGame();
                break;
            case 7:
                Skandinav.runAGame();
                break;
            case 8:
                EuroJackpot.runAGame();
                break;
            case 10:
                System.exit(0);
                break;
        }
    }
}
