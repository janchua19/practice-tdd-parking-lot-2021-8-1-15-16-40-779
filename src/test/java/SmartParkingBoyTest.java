import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SmartParkingBoyTest {
    @Test
    public void should_return_parking_ticket_when_park_a_parking_lot_and_a_smart_parking_boy_and_a_car (){
        //given
        ParkingLot parkingLot = new ParkingLot();
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLot);
        Car car = new Car();

        //when
        ParkingTicket parkingTicket = smartParkingBoy.park(car);

        //then
        assertNotNull(parkingTicket);
    }

    @Test
    public void should_return_parked_car_when_fetch_given_a_parking_lot_with_a_parked_car_a_smart_parking_boy_and_a_parking_ticket (){
        //given
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car();
        ParkingTicket parkingTicket = parkingLot.park(car);
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLot);

        //when
        Car actualCar = smartParkingBoy.fetch(parkingTicket);

        //then
        assertEquals(car, actualCar);
    }

    @Test
    public void should_return_right_car_with_each_ticket_when_fetch_given_a_parking_lot_with_two_parked_car_a_smart_parking_boy_and_two_parking_tickets (){
        //given
        ParkingLot parkingLot = new ParkingLot();
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLot);
        Car janCar = new Car();
        Car edwardCar = new Car();

        ParkingTicket janParkingTicket = smartParkingBoy.park(janCar);
        ParkingTicket edwardParkingTicket = smartParkingBoy.park(edwardCar);

        //when
        Car janActualCar = smartParkingBoy.fetch(janParkingTicket);
        Car edwardActualCar = smartParkingBoy.fetch(edwardParkingTicket);

        //then
        assertEquals(janCar, janActualCar);
        assertEquals(edwardCar, edwardActualCar);
    }

    @Test
    public void should_return_nothing_with_error_unrecognized_parking_ticket_when_fetch_given_a_parking_lot_a_smart_parking_boy_and_wrong_parking_ticket () {
        //given
        ParkingLot parkingLot = new ParkingLot();
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLot);
        ParkingTicket unrecognizedParkingTicket = new ParkingTicket();

        //when
        Exception exception = assertThrows(UnrecognizedParkingTicketException.class, () -> smartParkingBoy.fetch(unrecognizedParkingTicket));

        //then
        assertEquals("Unrecognized parking ticket.", exception.getMessage());
    }

    @Test
    public void should_return_nothing_with_error_unrecognized_parking_ticket_when_fetch_given_a_parking_lot_a_smart_parking_boy_and_a_used_parking_ticket ()
    {
        //given
        ParkingLot parkingLot = new ParkingLot();
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLot);
        ParkingTicket usedParkingTicket = new ParkingTicket();

        //when
        Exception exception = assertThrows(UnrecognizedParkingTicketException.class, () -> smartParkingBoy.fetch(usedParkingTicket));

        //then
        assertEquals("Unrecognized parking ticket.", exception.getMessage());
    }

    @Test
    public void should_return_nothing_with_error_no_available_position_when_park_given_a_parking_lot_and_no_available_position_a_smart_parking_boy_and_a_car ()
    {
        //given
        ParkingLot parkingLot = new ParkingLot(1);
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLot);
        Car car = new Car();
        parkingLot.park(new Car());

        //when
        Exception exception = assertThrows(NoAvailablePosition.class, () -> smartParkingBoy.park(car));

        //then
        assertEquals("No available position.", exception.getMessage());
    }
}
