import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class SuperSmartParkingBoyTest{
    @Test
    public void should_return_the_car_be_parked_to_the_first_parking_lot_when_park_given_a_super_smart_parking_boy_who_manages_two_parking_lots_both_with_available_position_but_parking_lot_1_has_larger_ratio_of_available_slot_and_a_car ()
    {
        //given
        Car car = new Car();
        ParkingLot parkingLot1 = new ParkingLot(10);
        ParkingLot parkingLot2 = new ParkingLot(5);
        ArrayList<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(parkingLot1);
        parkingLots.add(parkingLot2);

        SuperSmartParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy(parkingLots);

        //when
        ParkingTicket parkingTicket = superSmartParkingBoy.park(car);

        //then
        Car actualCar = parkingLot1.fetch(parkingTicket);
        assertEquals(car, actualCar);
    }

    @Test
    public void should_return_the_car_will_be_parked_to_the_second_parking_lot_when_park_given_a_super_smart_parking_boy_who_manages_two_parking_lots_first_is_full_and_second_with_available_position_but_parking_lot_2_has_larger_ratio_of_available_slot_and_a_car ()
    {
        //given
        Car car = new Car();
        ParkingLot parkingLot1 = new ParkingLot(20);
        ParkingLot parkingLot2 = new ParkingLot(10);
        parkingLot1.park(new Car());
        ArrayList<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(parkingLot1);
        parkingLots.add(parkingLot2);
        SuperSmartParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy(parkingLots);

        //when
        ParkingTicket parkingTicket = superSmartParkingBoy.park(car);

        //then
        Car actualCar = parkingLot2.fetch(parkingTicket);
        assertEquals(car, actualCar);
    }
}
