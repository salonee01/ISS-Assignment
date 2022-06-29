
public class SRVBank extends Bank{
	
	int rateOfInterest;
	
	SRVBank(int rate){
		rateOfInterest = rate;
	}

	@Override
	int getRateOfInterest() {
		return rateOfInterest;
	}
	
	public static void main(String args[]) {
		SRVBank bank = new SRVBank(6);
		System.out.println("The rate of interest is " + bank.getRateOfInterest());
	}

}
