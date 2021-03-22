import java.util.ArrayList;

public class Player {
    ArrayList<Integer> aField = new ArrayList<>();
    ArrayList<Integer> bField = new ArrayList<>();

    public ArrayList<Integer> getbField() {
        return bField;
    }

    public void setbField(ArrayList<Integer> bField) {
        this.bField = bField;
    }

    public ArrayList<Integer> getaField() {
        return aField;
    }

    public void setaField(ArrayList<Integer> aField) {
        this.aField = aField;
    }
    public static Player player = new Player();
}
