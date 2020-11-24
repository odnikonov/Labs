import java.util.*;
import java.net.*;
import java.io.*;
import mypack.Random;
import mypack.kvadratch;
import mypack.cobnechet;
public class Main
	{
	
	public static void main(String[] args) throws IOException
{
	Random random = new Random();
	kvadratch sqr = new kvadratch();
	cobnechet cub = new cobnechet(); 
	random.start();
	sqr.start();
	cub.start();
	int d = 0;
	for (int i = 0; ; i++)
	{
		d = Random.randomget(d);
		try
		{
			random.sleep(1000);
			if (d % 2 == 0)
				sqr.square(d);
			else
				cub.cube(d);
		}
		catch(InterruptedException e){}
	}
}

}	