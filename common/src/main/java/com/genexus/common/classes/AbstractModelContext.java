package com.genexus.common.classes;

import java.util.TimeZone;

import com.genexus.Globals;
import com.genexus.IHttpContext;
import com.genexus.common.interfaces.IClientPreferences;
import com.genexus.common.interfaces.IHttpContextNull;


public abstract class AbstractModelContext {
	private int afterConnectHandle = 0;

	public Globals globals = new Globals();

	public abstract TimeZone getClientTimeZone();

	public abstract IHttpContext getHttpContext();

	public abstract String cgiGet(String varName) ;

	public abstract String cgiGetFileName(String varName);

	public abstract String cgiGetFileType(String varName);

	public abstract String getSOAPErrMsg();
	
	public abstract void setSOAPErrMsg(String msg);

	public abstract IClientPreferences getClientPreferences();

	public abstract String getLanguage() ;

	public abstract String getLanguageProperty(String string);

	public abstract Object getThreadModelContext();

	public abstract void setThreadModelContext(Object ctx);

	public abstract String getServerKey();

    public boolean isNullHttpContext() {
    	 return getHttpContext() instanceof IHttpContextNull;
    }

	public int getAfterConnectHandle()
	{
		return afterConnectHandle;
	}

	public void setAfterConnectHandle(int handle){
		afterConnectHandle = handle;
	}

	private TimeZone _currentTimeZone;
	public TimeZone getCurrentTimeZone() {
		return _currentTimeZone;
	}
	public void setCurrentTimeZone(TimeZone tz) {
		_currentTimeZone = tz;
	}
}
