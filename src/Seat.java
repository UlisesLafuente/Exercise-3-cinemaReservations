public class Seat {

    private final int row;
    private final int seat;
    private String personName;

    //CONSTRUCTOR
    Seat(int row, int seat) {
        this.row = row;
        this.seat = seat;
    }

//    public int getRow() {
//        return row;
//    }

//    public int getSeat() {
//        return seat;
//    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    @Override
    public String toString() {
        return "Asiento: " + row + ", Número de asiento: " + seat + ", Nombre: " + personName;
    }
}
