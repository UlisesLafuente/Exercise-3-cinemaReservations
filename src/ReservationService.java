import customExceptions.InvalidSeatException;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class ReservationService {
    private int totalRows;
    private int seatsPerRow;
    private ArrayList<Seat> seats=new ArrayList<Seat>();
    private boolean continua=true;

    //CONSTRUCTOR
    ReservationService(int rows, int seatsPerRow){
        this.totalRows=rows;
        this.seatsPerRow=seatsPerRow;
        createSeats(rows, seatsPerRow);
    }

    private void createSeats(int rows, int seatsPerRow) {
        for (int i=1 ; i<=rows; i++){
            for (int i2=1 ; i2<=seatsPerRow; i2++){
                Seat seat= new Seat(i,i2);
                this.seats.add(seat);
                System.out.println("añadido asiento" +i +" "+i2);
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

        while(true){
            System.out.print(message);
            try {
                input = sc.nextInt();
                break;
            } catch(Exception e) {
                System.err.println("Input no válido.");
            }
        }
        return input;
    }

    public void selectOption(){
        String i = getInput("Selecciona una opción: ");
        switch (i){
            case "1" -> {
                //1.- Mostrar todas las butacas reservadas.
                for (Seat s : this.seats){
                    if(s.getPersonName()!=null){
                        System.out.println(s);
                    }
                }
            }
            case "2" ->{
                //2.- Mostrar todas las butacas reservadas por persona.
                for (Seat s : getSeatsByPerson(getInput("Nombre de la persona: "))){
                    System.out.println(s);
                }
            }
            case "3" ->{
                //3.- Reservar una butaca.
                reserveSeat(
                        getInputInt("Fila: "),
                        getInputInt("Asiento: "),
                        getInput("Nombre : ")
                        );
            }
            case "4" ->{
                //4.- Anular la reserva de una butaca.
                cancelSeat(
                        getInputInt("Fila: "),
                        getInputInt("Asiento: ")
                        );
            }
            case "5" ->{
                //5.- Anular todas las reservas de una persona.
                cancelAllByPerson(getInput("Nombre de la persona: "));
            }
            case "0" ->{
                //0-quit
                System.out.print("Bye!");
                this.continua=false;
            }
            default -> System.out.print("Input inválido.");
        }
    }

    public void reserveSeat(int row, int seat, String name){
        Seat s = this.seats.get(row*seat);
        s.setPersonName(name);
        //AÑADIR EL CÓDIGO DE VALIDACIÓN
    }
    public void cancelSeat(int row, int seat){
        this.seats.get(((row+1)*seat)).setPersonName(null);
        //FALTA VALIDAR
    }

    public void cancelAllByPerson(String name){
        for (Seat s : this.seats){
            if (s.getPersonName().equals(name)){
                s.setPersonName(null);
            }
        }
        //QUEDA VALIDACIÓN
    }
    public ArrayList<Seat> getAllSeats(){
        return this.seats;
    }
    public ArrayList<Seat> getSeatsByPerson(String name){
        ArrayList<Seat> seatsByPerson = new ArrayList<>();
        for (Seat s : this.seats){
            if (s.getPersonName().equals(name)){
                seatsByPerson.add(s);
            }
        }
        return seatsByPerson;
        //Falta verificar la entrada?
    }

    private String validateSeatPosition(int row, int seat){
        try{
            if(!((row>=0) && (row<=this.totalRows))){
                throw new InvalidSeatException("out-of-rank position: El número de fila no es válido.");
            } else if (!((seat>=0) && (seat<=this.seatsPerRow))) {
                throw new InvalidSeatException("out-of-rank position: El número de asiento no es válido");
            } else {
                if((this.seats.get(((row+1)*seat))).getPersonName() ==null){
                    return "Vacío";
                }
                else {
                    return "Ocupado";
                }
            }
        } catch (InvalidSeatException e){
            e.getMessage();
            return null;
        }
    }

    public boolean isContinua() {
        return continua;
    }
}
