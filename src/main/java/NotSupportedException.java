public class NotSupportedException extends  RuntimeException {
    String message;

    /**************** CONSTRUCTOR **********************************/
    public NotSupportedException(String message){
        this.message = message;
    }
}
