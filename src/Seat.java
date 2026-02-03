import java.util.List;

public class Seat {
    //It represents a reservation of an armchair.
    //    Attributes:
    //        int row
    //        int seat
    //        String personName
    //    Two seats are the same if they have the same row and seat ( equals()and hashCode()).
    //    The method toString()shows the armchair and the name of the person in a readable manner.

    private int row;
    private int seat;
    private String personName;

    //CONSTRUCTOR
    Seat(int row, int seat){
        this.row=row;
        this.seat=seat;
    }

    public int getRow() {
        return row;
    }

    public int getSeat() {
        return seat;
    }

    public String getPersonName() {
        return personName;
    }

    @Override
    public String toString(){

        return null;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }
}
