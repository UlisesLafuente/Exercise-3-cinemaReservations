void main() {

    IO.println("Hello and welcome!");

    Scanner sc = new Scanner(System.in);
    System.out.print("Filas de asientos: ");
    int rows = sc.nextInt();
    System.out.print("Asientos por fila: ");
    int seatsPerRow = sc.nextInt();

    ReservationService rs = new ReservationService(rows, seatsPerRow);
    new ConsoleUI(rs);

}

