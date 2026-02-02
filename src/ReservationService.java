import java.util.List;

public class ReservationService {
    private int totalRows;
    private int seatsPerRow;
    private List seats;

    //CONSTRUCTOR
    ReservationService(int rows, int seatsPerRow){
        this.totalRows=rows;
        this.seatsPerRow=seatsPerRow;
    }

    //Validate the position with a private method validateSeatPosition(row, seat).
    //    If an error occurs (out-of-rank position, occupied armchair, etc.), throw away a custom exception (RuntimeException).

    public void reserveSeat(int row, int seat, String name){

    }
    public void cancelSeat(int row, int seat){

    }
    public void cancelAllByPerson(String name){

    }
    public List<Seat> getAllSeats(){
        return this.seats;
    }
    public List<Seat> getSeatsByPerson(String name){

    }
    private void validateSeatPosition(int row, int seat){

    }
}
