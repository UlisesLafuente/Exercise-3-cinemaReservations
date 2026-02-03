public class ConsoleUI {

    private final ReservationService rs;

    ConsoleUI(ReservationService rs) {
        this.rs = rs;
        start();
    }

    public void start() {

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

