import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private Map<ParkingTicket, Car> parkedPosition = new HashMap<>();
    private Car car = new Car();
    private int capacity;

    private final int MAX_CAPACITY = 10;

    public ParkingLot()
    {
        this.capacity = MAX_CAPACITY;
    }

    public ParkingLot(int capacity){
        this.capacity = capacity;
    }


    public ParkingTicket park(Car car){
        ParkingTicket parkingTicket = new ParkingTicket();

        if(parkedPosition.size() == capacity) {
            throw new NoAvailablePosition();
        }
        else {
                parkedPosition.put(parkingTicket, car);
        }
        return parkingTicket;
    }

    public Car fetch(ParkingTicket parkingTicket){
        car = parkedPosition.get(parkingTicket);

        if(isUnrecognizedTicket(parkingTicket))
        {
            throw new UnrecognizedParkingTicketException();
        }
        final Car car = parkedPosition.get(parkingTicket);
        parkedPosition.remove(parkingTicket);
        return car;
    }

    public int getAvailable(){
        return this.capacity - parkedPosition.size();
    }

    public double getLargerAvailablePercentage()

    {
        System.out.println((double) getAvailable() / this.capacity + " ASDFASDFASDFASDFASD");
        return (double) getAvailable() / this.capacity;
    }

    public boolean isUnrecognizedTicket(ParkingTicket parkingTicket) {
        return !parkedPosition.containsKey(parkingTicket);
    }
}
