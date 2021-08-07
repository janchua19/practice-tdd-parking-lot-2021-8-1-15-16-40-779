import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class StandardParkingBoyTest {

    @Test
    public void should_return_parking_ticket_when_park_a_parking_lot_and_a_standard_parking_boy_and_a_car (){
        //given
        ParkingLot parkingLot = new ParkingLot();
        StandardParkingBoy standardParkingBoy = new StandardParkingBoy(parkingLot);
        Car car = new Car();

        //when
        ParkingTicket parkingTicket = standardParkingBoy.park(car);

        //then
        assertNotNull(parkingTicket);
    }

    @Test
    public void should_return_parked_car_when_fetch_given_a_parking_lot_with_a_parked_car_a_standard_parking_boy_and_a_parking_ticket (){
        //given
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car();
        ParkingTicket parkingTicket = parkingLot.park(car);
        StandardParkingBoy standardParkingBoy = new StandardParkingBoy(parkingLot);

        //when
        Car actualCar = standardParkingBoy.fetch(parkingTicket);

        //then
        assertEquals(car, actualCar);
    }

    @Test
    public void should_return_right_car_with_each_ticket_when_fetch_given_a_parking_lot_with_two_parked_car_a_standard_parking_boy_and_two_parking_tickets (){
        //given
        ParkingLot parkingLot = new ParkingLot();
        StandardParkingBoy standardParkingBoy = new StandardParkingBoy(parkingLot);
        Car janCar = new Car();
        Car edwardCar = new Car();

        ParkingTicket janParkingTicket = standardParkingBoy.park(janCar);
        ParkingTicket edwardParkingTicket = standardParkingBoy.park(edwardCar);

        //when
        Car janActualCar = standardParkingBoy.fetch(janParkingTicket);
        Car edwardActualCar = standardParkingBoy.fetch(edwardParkingTicket);

        //then
        assertEquals(janCar, janActualCar);
        assertEquals(edwardCar, edwardActualCar);
    }

    @Test
    public void should_return_nothing_with_error_unrecognized_parking_ticket_when_fetch_given_a_parking_lot_a_standard_parking_boy_and_wrong_parking_ticket () {
        //given
        ParkingLot parkingLot = new ParkingLot();
        StandardParkingBoy standardParkingBoy = new StandardParkingBoy(parkingLot);
        ParkingTicket unrecognizedParkingTicket = new ParkingTicket();

        //when
        Exception exception = assertThrows(UnrecognizedParkingTicketException.class, () -> standardParkingBoy.fetch(unrecognizedParkingTicket));

        //then
        assertEquals("Unrecognized parking ticket.", exception.getMessage());
    }

    @Test
    public void should_return_nothing_with_error_unrecognized_parking_ticket_when_fetch_given_a_parking_lot_a_standard_parking_boy_and_a_used_parking_ticket ()
    {
        //given
        ParkingLot parkingLot = new ParkingLot();
        StandardParkingBoy standardParkingBoy = new StandardParkingBoy(parkingLot);
        ParkingTicket usedParkingTicket = new ParkingTicket();

        //when
        Exception exception = assertThrows(UnrecognizedParkingTicketException.class, () -> standardParkingBoy.fetch(usedParkingTicket));

        //then
        assertEquals("Unrecognized parking ticket.", exception.getMessage());
    }

    @Test
    public void should_return_nothing_with_error_no_available_position_when_park_given_a_parking_lot_and_no_available_position_a_standard_parking_boy_and_a_car ()
    {
        //given
        ParkingLot parkingLot = new ParkingLot(1);
        StandardParkingBoy standardParkingBoy = new StandardParkingBoy(parkingLot);
        Car car = new Car();
        parkingLot.park(new Car());

        //when
        Exception exception = assertThrows(NoAvailablePosition.class, () -> standardParkingBoy.park(car));

        //then
        assertEquals("No available position.", exception.getMessage());
    }
//CASE 1
    @Test
    public void should_return_the_car_be_parked_to_the_first_parking_lot_when_park_given_a_standard_parking_boy_who_manages_two_parking_lots_both_with_available_position_and_a_car ()
    {
        //given
        Car car = new Car();
        ParkingLot parkingLot1 = new ParkingLot();
        ParkingLot parkingLot2 = new ParkingLot();
        ArrayList<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(parkingLot1);
        parkingLots.add(parkingLot2);

        StandardParkingBoy standardParkingBoy = new StandardParkingBoy(parkingLots);

        //when
        ParkingTicket parkingTicket = standardParkingBoy.park(car);

        //then
        Car actualCar = parkingLot1.fetch(parkingTicket);
        assertEquals(car, actualCar);
    }
}
