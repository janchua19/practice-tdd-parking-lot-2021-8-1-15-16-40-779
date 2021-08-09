import java.util.List;

public class SmartParkingBoy extends StandardParkingBoy{

    public SmartParkingBoy(List<ParkingLot> parkingLots)
    {
        super(parkingLots);
    }

    public ParkingTicket park(Car car){
        ParkingLot mostAvailableSlots = null;
        for (ParkingLot parkingLot : parkingLots) {
            if (parkingLot.getAvailable() > 0) {
                if (mostAvailableSlots == null || parkingLot.getAvailable() > mostAvailableSlots.getAvailable()) {
                    mostAvailableSlots = parkingLot;
                }
            }
        }
        if(mostAvailableSlots == null){
            throw new NoAvailablePosition();
        }
        return mostAvailableSlots.park(car);
    }

    public Car fetch(ParkingTicket parkingTicket){
        for (ParkingLot parkingLot: parkingLots) {
            try{
                if(!parkingLot.isUnrecognizedTicket(parkingTicket)) {
                    return parkingLot.fetch(parkingTicket);
                }
            }catch (UnrecognizedParkingTicketException e){
            }
        }
        throw new UnrecognizedParkingTicketException();
    }

}
