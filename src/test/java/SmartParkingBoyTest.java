import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

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
}
