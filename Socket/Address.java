package Inet;
import java.io.*;
import java.net.*;
import java.util.*;
public class Address {
	public static void main(String[] args)
	        throws UnknownHostException
	    {
	        InetAddress address1 = InetAddress.getLocalHost();
	        System.out.println("InetAddress of Local Host : "
	                           + address1);
	 
	        InetAddress address2
	            = InetAddress.getByName("www.google.com");
	        System.out.println("InetAddress of Named Host : "
	                           + address2);
	 
	        InetAddress address3[]
	            = InetAddress.getAllByName("www.itats.ac.id");
	        for (int i = 0; i < address3.length; i++) {
	            System.out.println(
	                "ALL InetAddresses of Named Host : "
	                + address3[i]);
	        }
	 
	        byte IPAddress[] = { (byte)142, (byte)250, 12,105 };
	        InetAddress address4
	            = InetAddress.getByAddress(IPAddress);
	        System.out.println(
	            "InetAddresses of Host with specified IP Address : "
	            + address4);
	 
	        byte[] IPAddress2
	            = { (byte)142, (byte)251, 12,105 };
	        InetAddress address5 = InetAddress.getByAddress(
	            "www.google.com", IPAddress2);
	        System.out.println(
	            "InetAddresses of Host with specified IP Address and hostname : "
	            + address5);
	    }
}
