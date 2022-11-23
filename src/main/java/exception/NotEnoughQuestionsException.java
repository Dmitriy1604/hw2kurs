package exception;

public class NotEnoughQuestionsException extends Throwable {
    public NotEnoughQuestionsException() {
    }

    public NotEnoughQuestionsException(String message) {
        super ( message );
    }

    public NotEnoughQuestionsException(String message , Throwable cause) {
        super ( message , cause );
    }

    public NotEnoughQuestionsException(Throwable cause) {
        super ( cause );
    }

    public NotEnoughQuestionsException(String message , Throwable cause , boolean enableSuppression , boolean writableStackTrace) {
        super ( message , cause , enableSuppression , writableStackTrace );
    }
}
