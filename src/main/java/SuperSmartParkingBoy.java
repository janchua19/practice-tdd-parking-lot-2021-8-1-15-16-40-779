import java.util.List;

public class SuperSmartParkingBoy extends  StandardParkingBoy{

    public SuperSmartParkingBoy(List<ParkingLot> parkingLots) {
        super(parkingLots);
    }

    public ParkingTicket park(Car car){
        ParkingLot mostLargerRatioAvailableSlot = null;
        for (ParkingLot parkingLot : parkingLots) {
            if (parkingLot.getAvailable() > 0) {
                if (mostLargerRatioAvailableSlot == null || parkingLot.getLargerAvailablePercentage() >
                        mostLargerRatioAvailableSlot.getLargerAvailablePercentage()) {
                    mostLargerRatioAvailableSlot = parkingLot;
                }
            }
        }
        if(mostLargerRatioAvailableSlot == null){
            throw new NoAvailablePosition();
        }
        return mostLargerRatioAvailableSlot.park(car);
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
