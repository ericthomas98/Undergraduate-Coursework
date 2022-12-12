
public class RadioStationException extends Exception{
	
	//0-arg Constructor
	public RadioStationException (){
	}
	//2-arg Constructor
    public RadioStationException(String radioSignature, double frequency){
        super("Signature " + radioSignature + " & frequency " + frequency + " are invalid and will not be recorded...");
    }
    
	public RadioStationException (Throwable cause){
		super(cause);
	}
	
}
