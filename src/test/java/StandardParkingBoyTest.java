import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

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
}
