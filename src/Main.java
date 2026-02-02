
void main() {

    IO.println(String.format("Hello and welcome!"));

    //Contains the main()of the program.
    //        -Ask the user for the number of rows and seats per row.
    //        -Create an instance of ReservationService with this data.
    //        -Create the ConsoleUI and the service passes to him.
    //        -Call ui.start() to start the program.
    //        -It does not contain any validation or business logic.

    Scanner sc = new Scanner(System.in);
    System.out.print("Filas de asientos: ");
    int rows= sc.nextInt();
    System.out.print("Asientos por fila: ");
    int seatsPerRow= sc.nextInt();

    ReservationService rs = new ReservationService(rows, seatsPerRow);
    ConsoleUI Cui = new ConsoleUI(rs);

    }

