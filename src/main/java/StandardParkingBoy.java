public class StandardParkingBoy {
    private ParkingLot parkingLot;

    public StandardParkingBoy (ParkingLot parkingLot){
        this.parkingLot = parkingLot;
    }

    public ParkingTicket park(Car car){
        return  null;
    }

    public Car fetch(ParkingTicket parkingTicket){
        return parkingLot.fetch(parkingTicket);
    }
}
