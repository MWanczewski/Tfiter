package errors;

public class ValidationError {
    private String header;
    private String message;

    public ValidationError(String header, String message) {
        this.header = header;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
