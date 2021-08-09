import java.util.ArrayList;
import java.util.List;

public class StandardParkingBoy {
    private ParkingLot parkingLot;
    protected List<ParkingLot> parkingLots;

    public StandardParkingBoy (ParkingLot parkingLot){
        this(new ArrayList<ParkingLot>(){{
            add(parkingLot);
        }});
    }

    public StandardParkingBoy (List<ParkingLot> parkingLots){
        this.parkingLots = parkingLots;
    }

    public ParkingTicket park(Car car){
        for (ParkingLot parkingLot: parkingLots) {
            try{
                return parkingLot.park(car);
            }catch (NoAvailablePosition e){
            }
        }
        throw new NoAvailablePosition();
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
