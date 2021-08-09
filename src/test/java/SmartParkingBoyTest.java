import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class SmartParkingBoyTest {
    @Test
    public void should_return_the_car_be_parked_to_the_first_parking_lot_when_park_given_a_smart_parking_boy_who_manages_two_parking_lots_both_with_available_position_and_a_car ()
    {
        //given
        Car car = new Car();
        ParkingLot parkingLot1 = new ParkingLot();
        ParkingLot parkingLot2 = new ParkingLot();
        ArrayList<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(parkingLot1);
        parkingLots.add(parkingLot2);

        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLots);

        //when
        ParkingTicket parkingTicket = smartParkingBoy.park(car);

        //then
        Car actualCar = parkingLot1.fetch(parkingTicket);
        assertEquals(car, actualCar);
    }

    @Test
    public void should_return_the_car_will_be_parked_to_the_second_parking_lot_when_park_given_a_smart_parking_boy_who_manages_two_parking_lots_first_is_full_and_second_with_available_position_and_a_car ()
    {
        //given
        Car car = new Car();
        ParkingLot parkingLot1 = new ParkingLot(1);
        parkingLot1.park(new Car());
        ParkingLot parkingLot2 = new ParkingLot();
        ArrayList<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(parkingLot1);
        parkingLots.add(parkingLot2);

        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLots);

        //when
        ParkingTicket parkingTicket = smartParkingBoy.park(car);


        //then
        Car actualCar = parkingLot2.fetch(parkingTicket);
        assertEquals(car, actualCar);
    }
}
