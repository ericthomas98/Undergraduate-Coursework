public class RadioStation{
	
	String callSign;
	double radioFrequency;
	
	//2-arg Radio Station Exception constructor
	public RadioStation(String radioSignature, double frequency) throws RadioStationException{
		 
		/*Validate input and throw exception for invalid input
		 *Callsign must be 4 letters and be a letter
		 *Frequency must be numbers and within a specific range (88-108 inclusive*/
		if(radioSignature.length() != 4 || (!radioSignature.matches("[A-Za-z]{4}")) || frequency < 88 ||  frequency > 108) {
			
            throw new RadioStationException(radioSignature, frequency);
		}
		
		else {
		
			callSign = radioSignature;
			radioFrequency = frequency;
	
		}
	}
}
