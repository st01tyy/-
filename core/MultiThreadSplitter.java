package core;

public class MultiThreadSplitter implements Runnable
{
	/*
	 * ���̷ִ߳���
	 */
	private Splitter[] splitter;
	
	public MultiThreadSplitter(String[] arr, Dictionary dic)
	{
		splitter=new Splitter[arr.length];
		for(int a=0;a<arr.length;a++)
		{
			if(arr[a]==null)
				break;
			splitter[a]=new Splitter(arr[a], dic);
		}
	}

	@Override
	public void run() 
	{
		for(int a=0;a<splitter.length;a++)
		{
			if(splitter[a]==null)
				break;
			splitter[a].run();
		}
	}
	public String[] getResult()
	{
		String[] res=new String[splitter.length];
		for(int a=0;a<res.length;a++)
		{
			if(splitter[a]==null)
				break;
			res[a]=splitter[a].getResult();
		}
		return res;
	}
}
