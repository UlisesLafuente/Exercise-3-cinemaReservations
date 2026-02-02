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
    Seat(){

    }

    public void reserveSeat(int row, int seat, String name){

    }
    public void cancelSeat(int row, int seat){

    }
    public void cancelAllByPerson(String name){

    }
    public List<Seat> getAllSeats(){

    }
    public List<Seat> getSeatsByPerson(String name){

    }

    @Override
    public String toString(){

        return null;
    }
}
