import java.util.ArrayList;
import java.util.List;

public class SmartParkingBoy extends StandardParkingBoy{
    private ParkingLot parkingLot;
    //private List<ParkingLot> parkingLots = new ArrayList<>();

    public SmartParkingBoy(ParkingLot parkingLot) {
        super(parkingLot);
    }

    public SmartParkingBoy(List<ParkingLot> parkingLots){
        super(parkingLots);
    }

}
