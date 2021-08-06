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

@Test
public void should_return_no_car_when_fetch_given_a_parking_lot_and_wrong_parking_ticket (){
    //given
    ParkingLot parkingLot = new ParkingLot();
    ParkingTicket wrongTicket = new ParkingTicket();

    //when
    Car actualCar1 = parkingLot.fetch(wrongTicket);

    //then
    assertNull(actualCar1);
}
}
