import java.util.Scanner;

public class ConsoleUI {

    private ReservationService rs;

    ConsoleUI(ReservationService rs){
        this.rs=rs;
    }

    public void start(){
        //aquí iría el código con el menu
        //Show the menu and read the user’s options.
        //    -Ask for data such as name, row and seat,
        //        -and call the service methods.
        //    (Only manage input and output by console.)
        //    (It contains no business rules or logical validation.)
        //      It does not contain any validation or business logic.


        System.out.println(String.format(
            "1.- Mostrar todas las butacas reservadas.%n" +
            "2.- Mostrar todas las butacas reservadas por persona.%n" +
            "3.- Reservar una butaca.%n" +
            "4.- Anular la reserva de una butaca.%n" +
            "5.- Anular todas las reservas de una persona.%n" +
            "0.- Salir."));

        selec getInput("Selecciona una opción: ");

    }

    private String getInput(String message) {
        Scanner sc = new Scanner(System.in);
        System.out.print(message);
        return sc.nextLine();
    }

    private void selectOption(int i){
        switch (i){
            case 1 -> {
                //1.- Mostrar todas las butacas reservadas.
                this.rs.getAllSeats();
            }
            case 2 ->{
                //2.- Mostrar todas las butacas reservadas por persona.


            }
            case 3 ->{
                //3.- Reservar una butaca.

            }
            case 4 ->{
                //4.- Anular la reserva de una butaca.

            }
            case 5 ->{
                //5.- Anular todas las reservas de una persona.
                this.rs.cancelAllByPerson(
                        getInput("Nombre de la persona: ");
                );

            }
            case 0 ->{
                System.out.print("Bye!");
                break;
            }
            default -> System.out.print("Input inválido.");
        }
    }
}
