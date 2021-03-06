package com.genexus.webpanels;

import com.genexus.Application;
import com.genexus.ApplicationContext;
import com.genexus.ModelContext;
import com.genexus.internet.HttpContext;

public class WebApplicationStartup 
{
	static boolean initialized = false;

	public void init(Class baseClass, HttpContext httpContext)
	{
		if (!initialized)
		{
			initImpl(baseClass, httpContext);
		}
	}
	
	
	private synchronized void initImpl(Class baseClass, HttpContext httpContext)
	{
		if	(!initialized)
		{				
			ApplicationContext appContext = ApplicationContext.getInstance();

			appContext.setMsgsToUI(false);
			appContext.setServletEngine(true);
			appContext.setServletEngineDefaultPath(httpContext.getDefaultPath());

      		Application.init(baseClass, false);
			ModelContext.getModelContext(baseClass).setHttpContext(httpContext);
			initialized = true;
		}
	}	
}


