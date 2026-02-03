import customExceptions.InvalidPersonNameException;
import customExceptions.InvalidSeatException;
import customExceptions.SeatAlreadyEmptyException;
import customExceptions.SeatAlreadyTakenException;

import java.util.ArrayList;
import java.util.Scanner;

public class ReservationService {
    private final int totalRows;
    private final int seatsPerRow;
    private final ArrayList<Seat> seats = new ArrayList<>();
    private boolean continua = true;

    //CONSTRUCTOR
    ReservationService(int rows, int seatsPerRow) {
        this.totalRows = rows;
        this.seatsPerRow = seatsPerRow;
        createSeats(rows, seatsPerRow);
    }
    //UTILITY///////////////////////////////////////////////////////////////////////
    private void createSeats(int rows, int seatsPerRow) {
        for (int i = 1; i <= rows; i++) {
            for (int i2 = 1; i2 <= seatsPerRow; i2++) {
                Seat seat = new Seat(i, i2);
                this.seats.add(seat);
                System.out.println("añadido asiento" + i + " " + i2);
            }
        }
    }

    private String getInput(String message) {
        Scanner sc = new Scanner(System.in);
        System.out.print(message);
        return sc.nextLine();
    }

    private int getInputInt(String message) {
        int input;
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print(message);
            try {
                input = sc.nextInt();
                break;
            } catch (Exception e) {
                System.err.println("Input no válido.");
            }
        }
        return input;
    }

    //MENU OPTIONS SWITCH/////////////////////////////////////////////////////////////////
    public void selectOption() {
        String i = getInput("Selecciona una opción: ");
        switch (i) {
            case "1" -> {
                //1.- Mostrar todas las butacas reservadas.
                showAllReservedSeats();
            }
            case "2" -> {
                //2.- Mostrar todas las butacas reservadas por persona.
                String x = getInput("Nombre de la persona: ");
                if (!(getSeatsByPerson(x) == null)) {
                    for (Seat s : getSeatsByPerson(x)) {
                        System.out.println(s);
                    }
                }
            }
            case "3" -> {
                //3.- Reservar una butaca.
                reserveSeat(
                        getInputInt("Fila: "),
                        getInputInt("Asiento: "),
                        getInput("Nombre : ")
                );
            }
            case "4" -> {
                //4.- Anular la reserva de una butaca.
                cancelSeat(
                        getInputInt("Fila: "),
                        getInputInt("Asiento: ")
                );
            }
            case "5" -> {
                //5.- Anular todas las reservas de una persona.
                cancelAllByPerson(getInput("Nombre de la persona: "));
            }
            case "0" -> {
                //0-quit
                System.out.print("Bye!");
                this.continua = false;
            }
            default -> System.out.print("Input no válido.");
        }
    }

    //MENU LOGIC////////////////////////////////////////////////////////////////////
    private void showAllReservedSeats() {
        ArrayList<Seat> reservedSeats = new ArrayList<>();
        for (Seat s : this.seats) {
            if (s.getPersonName() != null) {
                reservedSeats.add(s);
            }
        }
        if (reservedSeats.isEmpty()) {
            System.out.println("\nNo hay asientos reservados\n");
        } else {
            for (Seat s : reservedSeats) {
                System.out.println(s);
            }
        }
    }

    public void reserveSeat(int row, int seat, String name) {
        try{
            String status = validateSeatPosition(row, seat);
        if (status.equals("Vacío")) {
            Seat s = this.seats.get((row * seat) - 1);
            s.setPersonName(name);
        } else if (status.equals("Ocupado")) {
            throw new SeatAlreadyTakenException(
                    "El asiento está ya ocupado, no se ha reservado nuevamente."
            );
        }
        } catch (Exception e){
            System.err.println(e.getMessage());
        }
    }

    public void cancelSeat(int row, int seat) {
        try{
            String status = validateSeatPosition(row, seat);
            if(status.equals("Ocupado")){
                throw new SeatAlreadyEmptyException(
                        "El asiento ya está vacío, no se ha anulado ninguna reserva."
                );
            }
            else if (status.equals("Vacio")){
                this.seats.get((row * seat) - 1).setPersonName(null);
            }
            else {
                System.err.println("Estado del asiento inesperado: " + status);
            }
        } catch (Exception e){
            System.err.println(e.getMessage());
        }
    }

    public void cancelAllByPerson(String name) {
        ArrayList<Seat> cancelableSeats = getSeatsByPerson(name);
        for (Seat s : cancelableSeats) {
            s.setPersonName(null);
        }
    }

    public ArrayList<Seat> getAllSeats() {
        return this.seats;
    }

    public ArrayList<Seat> getSeatsByPerson(String name) {
        ArrayList<Seat> seatsByPerson = new ArrayList<>();

        for (Seat s : this.seats) {
            if (s.getPersonName() != null) {
                if (s.getPersonName().equalsIgnoreCase(name)) {
                    seatsByPerson.add(s);
                }
            }
        }
        try {
            if (!seatsByPerson.isEmpty()) {
                return seatsByPerson;
            } else {
                throw new InvalidPersonNameException("InvalidPersonNameException: Invalid name.");
            }
        } catch (InvalidPersonNameException e) {
            System.err.println(e.getMessage());
        }
        return null;
    }

    private String validateSeatPosition(int row, int seat) {
        try {
            if (!((row >= 0) && (row <= this.totalRows))) {
                throw new InvalidSeatException(
                        "out-of-rank position: El número de fila no es válido."
                );
            } else if (!((seat >= 0) && (seat <= this.seatsPerRow))) {
                throw new InvalidSeatException(
                        "out-of-rank position: El número de asiento no es válido"
                );
            } else {
                if ((this.seats.get((row*seat)-1).getPersonName() == null)) {
                    return "Vacío";
                } else {
                    return "Ocupado";
                }
            }
        } catch (InvalidSeatException e) {
            System.err.println(e.getMessage());
            return "";
        }
    }

    public boolean isContinua() {
        return continua;
    }
}
