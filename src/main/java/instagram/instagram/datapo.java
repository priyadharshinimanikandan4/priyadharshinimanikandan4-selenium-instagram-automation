package instagram.instagram;

import org.testng.annotations.DataProvider;

public class datapo {
	
 @DataProvider(name = "login")
	public Object[][] getData()
	{
		return App.readd("tcc001");
	}
}
