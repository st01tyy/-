package main;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import core.Dictionary;
import core.Splitter;

public class Main 
{
	public static void main(String[] args) throws ClassNotFoundException, IOException 
	{
		BufferedReader in = null;
		PrintWriter out = null;
		ObjectInputStream obj = null;
		Dictionary dictionary=null;
		try
		{
			obj=new ObjectInputStream(new BufferedInputStream(new FileInputStream("./dictionary.ruben")));
			dictionary=(Dictionary)obj.readObject();
		}
		catch(Exception e)
		{
			System.out.println("�Ҳ����ʵ��ļ����ļ����𻵡�ȷ��dictionary.ruben�ļ���ִ���ļ���Ŀ¼�¡�");
			System.out.println("The dictionary file could not be found or the file is corrupt. Make sure that the 'dictionary.ruben' file is in the root directory of the execution file.");
			return;
		}
		Scanner s=new Scanner(System.in);
		System.out.println("������ִ������ļ��ľ���·�����ļ�ӦΪUTF-8���룩��");
		String source=s.next();
		System.out.println("����ִʽ���ļ������·����");
		String destination=s.next();
		try
		{
			in=new BufferedReader(new InputStreamReader(new FileInputStream(source), "UTF-8"));
		}
		catch(Exception e)
		{
			System.out.println("��ȡ���ִ�����ʱ��������ȷ���ļ�·���Ƿ���ȷ��");
			System.out.println("An error occurred while reading the word stock to be divided. Make sure the file path is correct.");
			obj.close();
			s.close();
			return;
		}
		SimpleDateFormat df=new SimpleDateFormat();
		Date date=new Date();
		df.applyPattern("yy-MM-dd-HH-mm-ss");
		try
		{
			out=new PrintWriter(new File(destination+"\\"+df.format(date)+".txt"));
		}
		catch(Exception e)
		{
			System.out.println("�ִʽ���ļ������·������򲻴��ڡ�");
			System.out.println("The output path of the participle result file is incorrect or does not exist.");
			in.close();
			obj.close();
			s.close();
			return;
		}
		long time1=System.currentTimeMillis();
		in.read();
		String input=in.readLine();
		while(input!=null)
		{
			Splitter splitter=new Splitter(input, dictionary);
			splitter.run();
			out.write(splitter.getResult()+"\r\n");
			input=in.readLine();
		}
		long time2=System.currentTimeMillis();
		System.out.println("����ʱ�䣺"+(time2-time1)+"ms");
		in.close();
		out.close();
		obj.close();
		s.close();
	}
}
