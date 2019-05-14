package main;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class IO 
{
	public static ObjectInputStream getObjectInputStream()
	{
		ObjectInputStream obj;
		try
		{
			obj=new ObjectInputStream(new BufferedInputStream(new FileInputStream("./dictionary.ruben")));
			return obj;
		}
		catch(Exception e)
		{
			System.out.println("�Ҳ����ʵ��ļ����ļ����𻵡�ȷ��dictionary.ruben�ļ���ִ���ļ���Ŀ¼�¡�");
			System.out.println("The dictionary file could not be found or the file is corrupt. Make sure that the 'dictionary.ruben' file is in the root directory of the execution file.");
			return null;
		}
	}
	public static BufferedReader getReader(String source)
	{
		BufferedReader in;
		try
		{
			in=new BufferedReader(new InputStreamReader(new FileInputStream(source), "UTF-8"));
			return in;
		}
		catch(Exception e)
		{
			System.out.println("��ȡ���ִ�����ʱ��������ȷ���ļ�·���Ƿ���ȷ��");
			System.out.println("An error occurred while reading the word stock to be divided. Make sure the file path is correct.");
			return null;
		}
	}
	public static PrintWriter getWriter(String destination)
	{
		PrintWriter out;
		try
		{
			SimpleDateFormat df=new SimpleDateFormat();
			Date date=new Date();
			df.applyPattern("yy-MM-dd-HH-mm-ss");
			out=new PrintWriter(new File(destination+"\\"+df.format(date)+".txt"));
			return out;
		}
		catch(Exception e)
		{
			System.out.println("�ִʽ���ļ������·������򲻴��ڡ�");
			System.out.println("The output path of the participle result file is incorrect or does not exist.");
			return null;
		}
	}
}
