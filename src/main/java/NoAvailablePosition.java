public class NoAvailablePosition extends RuntimeException {
    @Override
    public String getMessage() {
        return "No available position.";
    }
}
