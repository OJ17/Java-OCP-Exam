package ch6ExceptionsAndAssertions;

// an example of a custom exception
class CustomException extends Exception {

    public CustomException() {
        super();
    }

    public CustomException(Exception e) {
        super(e);
    }

    public CustomException(String message) {
        super(message);
    }

}
