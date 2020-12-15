import java.util.*;

public class UrlCont
{
	private Hashtable<String, UrlInfo> unprocUrl = new Hashtable<>();
	private Hashtable<String, UrlInfo> visitUrl = new Hashtable<>();
	
	public UrlCont(String firstUrl)
	{
		UrlInfo urlInf = new UrlInfo(firstUrl, 0);
		String key = urlInf.getDomain() + urlInf.getPath() + urlInf.getParams();
		unprocUrl.put(key, urlInf);
	}
	
	public synchronized UrlInfo getRawUrl()
	{
		System.out.println(unprocUrl.size());
		while (unprocUrl.size() == 0)
		{
			try
			{
				wait();
			}
			catch (InterruptedException e)
			{
				Thread.currentThread().interrupt();
			}
		}
		
		String key = unprocUrl.keys().nextElement();
		UrlInfo urlInf = unprocUrl.get(key);
		unprocUrl.remove(key);
		
		return urlInf;
	}
	
	public synchronized void setRawUrl(UrlInfo urlInf)
	{
		String key = urlInf.getDomain() + urlInf.getPath() + urlInf.getParams();
		if (!visitUrl.containsKey(key) && !unprocUrl.containsKey(key))
		{
			unprocUrl.put(key, urlInf);
		}
		notify();
	}
	
	public Hashtable<String, UrlInfo> getVisitedUrl()
	{
		return visitUrl;
	}
	
	public synchronized void setVisitedUrl(UrlInfo urlInf)
	{
		String key = urlInf.getDomain() + urlInf.getPath() + urlInf.getParams();
		if (!visitUrl.containsKey(key))
		{
			visitUrl.put(key, urlInf);
		}
	}
}