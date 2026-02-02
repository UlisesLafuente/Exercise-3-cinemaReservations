Level 3
Exercise 1 — Reservations in the cinema
Objectives

With this exercise you will learn to:

    Design an application based on multiple classes that collaborate with each other.
    Working with dynamic collections such as ArrayList.
    Create and manage custom exceptions in Java (not checked).
    Apply good user entry validation practices.
    Apply methods such as equals()and toString()to work with objects.
    Interact with the user through a console in a robust way.

Enunciated

A cinema company asks you to develop an application to manage the reservation of seats in its rooms. This application will be used by sellers when selling tickets.

When the application is executed, it will first ask for how many rows and how many seats per row the room has. Once initialized, the following menu will be displayed:

        1.- Mostrar todas las butácas reservadas.
        2.- Mostrar todas las butácas reservadas por persona.
        3.- Reservar una butaca.
        4.- Anular la reserva de una butaca.
        5.- Anular todas las reservas de una persona.
        0.- Salir.


Class structure
» Main

    Contains the main()of the program.
        -Ask the user for the number of rows and seats per row.
        -Create an instance of ReservationServicewith this data.
        -Create the ConsoleUIand the service passes to him.
        -Call ui.start()to start the program.
        -It does not contain any validation or business logic.

» ConsoleUI

    Show the menu and read the user’s options.
    Ask for data such as name, row and seat, and call the service methods.
    Only manage input and output by console.
    It contains no business rules or logical validation.

» Reservation Service

    It contains the main logic of the program.
    Attributes:

    private int totalRows;
    private int seatsPerRow;
    private List seats;

    Main functions:
        reserveSeat(int row, int seat, String name)
        cancelSeat(int row, int seat)
        cancelAllByPerson(String name)
        List<Seat> getAllSeats()
        List<Seat> getSeatsByPerson(String name)
    Validate the position with a private method validateSeatPosition(row, seat).
    If an error occurs (out-of-rank position, occupied armchair, etc.), throw away a custom exception (RuntimeException).

» Seat

    It represents a reservation of an armchair.
    Attributes:
        int row
        int seat
        String personName
    Two seats are the same if they have the same row and seat ( equals()and hashCode()).
    The method toString()shows the armchair and the name of the person in a readable manner.

Personalized exceptions


class SeatAlreadyTakenException extends RuntimeException { }
class SeatAlreadyEmptyException extends RuntimeException { }
class InvalidSeatException extends RuntimeException { }
class InvalidPersonNameException extends RuntimeException { }


Important

Validation recommendations

    All tickets must be validated (with try-catch) to avoid mistakes such as InputMismatchException
    The name cannot contain numbers
    The same armchair cannot be reserved twice
    You cannot remove an armchair that is not reserved
    The system must be resilient: it should never be broken if the user enters incorrect data
