import java.util.Date;
import java.util.Scanner;

public class Main {

    static class RoomDetails {
        private String roomNumber;
        private boolean isAvailable = false;
        private double price;
        private String rentee;

        Scanner scanner = new Scanner(System.in);

        public void openRoom() {
            System.out.println("Enter Room Number: ");
            roomNumber =scanner.next();

            System.out.println("Enter Room Price: ");
            price = scanner.nextDouble();

            System.out.println("Enter Rentee Name: ");
            rentee = scanner.next();

            System.out.println("Room has been created.");
        }

        public void showRoom() {
            System.out.println("===========================");
            System.out.println("Room Number: " + roomNumber);
            System.out.println("Currently Rented By: " + rentee);
            System.out.println("It is rented for: " + price);
            System.out.println("===========================");
        }

        public void updateRoom(String roomNumber) {
            if (this.roomNumber.equals(roomNumber)){
                System.out.println("Enter a new room price: ");
                this.price = scanner.nextDouble();

                System.out.println("Enter new Rentee Name: ");
                this.rentee = scanner.nextLine();
                System.out.println("Room " + roomNumber + " has been updated successfully.");
                System.out.println("Here are the new updated details: ");

                this.showRoom();

            } else {
                System.out.println("Room with room number " + roomNumber + " does not exist.");
            }

        }

        public void closeRoom (String roomNumber) {

            if (this.roomNumber.equals(roomNumber)) {
                isAvailable = true;
                rentee = null;
                price = 0.0;
                System.out.println("Room " + roomNumber + " has been closed.");
            } else {
                System.out.println("Room with room number " + roomNumber + " does not exist.");
            }

        }

        public boolean searchRoomByRoomNumber(String roomNumber){
            if(this.roomNumber.equals(roomNumber)){
                System.out.println("Room has been found");
                this.showRoom();
                return true;
            }else{
                System.out.println("Room with room number " + roomNumber + " does not exist.");
                return false;

            }
        }

    }



    public static void main(String[] args) {

        /* In this project, we practice using Java to build a simple console-based Rental Room Management System

            The functionalities are as follows:
            1. Create Room
            2. Show Room
            3. Update Room
            4. Close Room
            6. Search Room
            5. Exit App

         */

        Scanner scanner = new Scanner(System.in);
        System.out.println("\n***Welcome to Rental Room Management System***");
        System.out.println("How many number of rooms do you want to open ?");
        int numberOfRooms = scanner.nextInt();

        RoomDetails[] Rooms = new RoomDetails[numberOfRooms];

        for (int i = 0; i < Rooms.length; i++) {
            Rooms[i] = new RoomDetails();
            Rooms[i].openRoom();
        }

        int character;

        do {
            System.out.println("*** What do you want to do next ? ***");
            System.out.println(" 1.Show room details \n 2.Search Room By Room Number \n 3.Update Room \n 4.Close Room ");
            System.out.println("Enter your choice: ");
            character = scanner.nextInt();

            switch(character){
                case 1:
                    for (RoomDetails room : Rooms) {
                        room.showRoom();
                    }
                    break;
                case 2:
                    System.out.println("Enter the room number you want to search: ");
                    String room_number = scanner.next();
                    for(RoomDetails room : Rooms) {
                        boolean found = room.searchRoomByRoomNumber(room_number);
                        if(!found){
                            break;
                        }
                    }
                case 3:
                    System.out.println("Enter the room number you want to update: ");
                    room_number = scanner.next();
                    for (RoomDetails room: Rooms){
                        room.updateRoom(room_number);
                    }
                    break;

                case 4:
                    System.out.println("Enter the room number you want to close: ");
                    room_number = scanner.next();
                    for (RoomDetails room: Rooms){
                        room.closeRoom(room_number);
                    }
                    break;

            }
        }while(character!=5);

    }

}