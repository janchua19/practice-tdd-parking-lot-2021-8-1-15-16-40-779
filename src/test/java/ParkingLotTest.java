import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

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

//    Given a parking lot with a parked car and a parking ticket
//    When fetch the car
//    Then return a parked car
    @Test
    public void should_return_parked_car_when_fetch_given_a_parking_lot_with_a_car_and_a_parking_ticket (){
        //given
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car();
        ParkingTicket parkingTicket = new ParkingTicket();

        //when
        Car actualCar = parkingLot.fetch();

        //then
        assertEquals(car, actualCar);
    }
}
