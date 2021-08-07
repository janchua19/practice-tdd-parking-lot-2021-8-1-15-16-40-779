import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ParkingLotTest {

    @Test
    public void should_return_parking_ticket_when_park_given_a_parking_lot_and_a_car (){
        //given
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car();

        //when
        ParkingTicket parkingTicket = parkingLot.park(car);

        //then
        assertNotNull(parkingTicket);
    }

    @Test
    public void should_return_parked_car_when_fetch_given_a_parking_lot_with_a_car_and_a_parking_ticket (){
        //given
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car();
        ParkingTicket parkingTicket = parkingLot.park(car);

        //when
        Car actualCar = parkingLot.fetch(parkingTicket);

        //then
        assertEquals(car, actualCar);
    }

    @Test
    public void should_return_right_car_when_fetch_given_a_parking_lot_with_two_car_and_two_parking_ticket (){
        //given
        ParkingLot parkingLot = new ParkingLot();
        Car janCar = new Car();
        Car edwardCar = new Car();

        ParkingTicket janParkingTicket = parkingLot.park(janCar);
        ParkingTicket edwardParkingTicket = parkingLot.park(edwardCar);

        //when
        Car janActualCar = parkingLot.fetch(janParkingTicket);
        Car edwardActualCar = parkingLot.fetch(edwardParkingTicket);

        //then
        assertEquals(janCar, janActualCar);
        assertEquals(edwardCar, edwardActualCar);
    }
//    THIS IS CONFLICT WITH EXCEPTION HANDLING FOR STORY 2 CASE 1 (IF YOU WISH TO RUN THIS PLS UNCOMMENT ALSO BLOCK OF CODES IN PARKING LOT UNDER FETCH())
//    @Test
//    public void should_return_no_car_when_fetch_given_a_parking_lot_and_wrong_parking_ticket () {
//        //given
//        ParkingLot parkingLot = new ParkingLot();
//        ParkingTicket wrongTicket = new ParkingTicket();
//        //when
//        Car actualCar1 = parkingLot.fetch(wrongTicket);
//
//        //then
//        assertNull(actualCar1);
//    }
//
//    @Test
//    public void should_return_no_car_when_fetch_given_a_parking_lot_and_used_parking_ticket () {
//        //given
//        ParkingLot parkingLot = new ParkingLot();
//        ParkingTicket parkingTicket = new ParkingTicket();
//        parkingLot.fetch(parkingTicket);
//
//
//        //when
//        Car fetchedCar = parkingLot.fetch(parkingTicket);
//
//        //then
//        assertNull(fetchedCar);
//    }

    @Test
    public void should_return_null_when_park_given_a_parking_lot_without_any_position_available () {
        //given
        ParkingLot parkingLot = new ParkingLot(1);
        Car car = new Car();
        parkingLot.park(new Car());


        //when
        ParkingTicket parkingTicket = parkingLot.park(car);

        //then
        assertNull(parkingTicket);
    }

    @Test
    public void should_return_no_car_with_error_unrecognized_parking_ticket_when_fetch_given_a_parking_lot_and_unrecognized_ticket () {
        //given
        ParkingLot parkingLot = new ParkingLot();
        ParkingTicket unrecognizedParkingTicket = new ParkingTicket();

        //when
        Exception exception = assertThrows(UnrecognizedParkingTicketException.class, () -> parkingLot.fetch(unrecognizedParkingTicket));

        //then
        assertEquals("Unrecognized parking ticket.", exception.getMessage());
    }

    @Test
    public void should_return_error_unrecognized_parking_ticket_when_fetch_given_a_parking_lot_and_a_used_ticket ()
    {
        //given
        ParkingLot parkingLot = new ParkingLot();
        ParkingTicket usedParkingTicket = new ParkingTicket();

        //when
        Exception exception = assertThrows(UnrecognizedParkingTicketException.class, () -> parkingLot.fetch(usedParkingTicket));

        //then
        assertEquals("Unrecognized parking ticket.", exception.getMessage());
    }

    @Test
    public void should_return_error_no_available_position_when_park_given_a_parking_lot_and_no_available_position_and_a_car ()
    {
        //given
        ParkingLot parkingLot = new ParkingLot(1);
        Car car = new Car();
        parkingLot.park(new Car());


        //when
        Exception exception = assertThrows(NoAvailablePosition.class, () -> parkingLot.park(car));

        //then
        assertEquals("No available position.", exception.getMessage());
    }
}
