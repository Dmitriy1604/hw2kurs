package exception;

public class QuestionAlreadyExistException extends Throwable {
    public QuestionAlreadyExistException() {
    }

    public QuestionAlreadyExistException(String message) {
        super ( message );
    }

    public QuestionAlreadyExistException(String message , Throwable cause) {
        super ( message , cause );
    }

    public QuestionAlreadyExistException(Throwable cause) {
        super ( cause );
    }

    public QuestionAlreadyExistException(String message , Throwable cause , boolean enableSuppression , boolean writableStackTrace) {
        super ( message , cause , enableSuppression , writableStackTrace );
    }
}
