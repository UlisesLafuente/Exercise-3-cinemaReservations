public class ConsoleUI {

    private final ReservationService rs;

    ConsoleUI(ReservationService rs) {
        this.rs = rs;
        start();
    }

    public void start() {
        //aquí iría el código con el menu
        //Show the menu and read the user’s options.
        //    -Ask for data such as name, row and seat,
        //        -and call the service methods.
        //    (Only manage input and output by console.)
        //    (It contains no business rules or logical validation.)
        //      It does not contain any validation or business logic.

        do {

            System.out.printf(
                    "1.- Mostrar todas las butacas reservadas.%n" +
                            "2.- Mostrar todas las butacas reservadas por persona.%n" +
                            "3.- Reservar una butaca.%n" +
                            "4.- Anular la reserva de una butaca.%n" +
                            "5.- Anular todas las reservas de una persona.%n" +
                            "0.- Salir.%n");

            this.rs.selectOption();
        } while (rs.isContinua());
    }
}

