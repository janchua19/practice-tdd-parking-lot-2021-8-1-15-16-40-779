public class UnrecognizedParkingTicketException extends RuntimeException{
    @Override
    public String getMessage() {
        return "Unrecognize parking ticket";
    }
}
