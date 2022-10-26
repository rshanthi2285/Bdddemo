package com.facebook.utilities;

import org.testng.annotations.DataProvider;

public class DataProviders {
	  @DataProvider(name="dp")
	  public static Object[][] dataprovidermethod()
	  {
//		Object[][] data=new Object[0][0];
//		data[0][0]="shanthi.suba@gmail.com";
//		data[0][1]="bservati123";
//		return data;
		  
		  return new Object[][]
				  {
			  {"shanthi.suba@gmail.com","bservati@123"}
			  
			  
				  };
	  }
}
