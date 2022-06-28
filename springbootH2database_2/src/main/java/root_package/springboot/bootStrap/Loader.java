package root_package.springboot.bootStrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import root_package.springboot.entity.Customer;
import root_package.springboot.entity.StatusSubscription;
import root_package.springboot.repository.InCoustomerRepo;

@Component

public  class Loader implements CommandLineRunner {

	public final InCoustomerRepo inCoustomerRepo; 
	
	public Loader (InCoustomerRepo inCoustomerRepo)
	
	{ this.inCoustomerRepo = inCoustomerRepo; 
	}

	 @Override
	    public void run(String... args) throws Exception {
	        loadValues();
	    }

private void loadValues()
{
	if(inCoustomerRepo.count() == 0)
	{ 
		inCoustomerRepo.save( 
			Customer.builder()
			  .name("xyz")
			  .age("12")
			  .location("P_Pune")
			   .statusSubcribtion(StatusSubscription.SUBSCRIBED)
			   
			  .build()
			);
		
		

		
		inCoustomerRepo.save( 
				Customer.builder()
				  .name("Gaurav")
				  .age("25")
				  .location("Chittor")
				   .statusSubcribtion(StatusSubscription.SUBSCRIBED)
				  .build()
				);
		
		inCoustomerRepo.save( 
				Customer.builder()
				  .name("Kirtiraj")
				  .age("4")
				  .location("Pune")
				   .statusSubcribtion(StatusSubscription.UNSUBSCRIBED)
				  .build()
				);
		System.out.println("Sample input Created");
	}
}

}

