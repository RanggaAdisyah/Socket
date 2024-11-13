package Inet;
import java.io.*;
import java.net.*;
import java.util.*;
public class AdressEqual {
		public static void main(String[] args)
			throws UnknownHostException
		{

			InetAddress address1
				= InetAddress.getByName("www.google.com");
			InetAddress address2
				= InetAddress.getByName("www.itats.ac.id");
			InetAddress address3
				= InetAddress.getByName("www.google.com");

			System.out.println(
				"Is Address-1 equals to Address-2? : "
				+ address1.equals(address2));
			System.out.println(
				"Is Address-1 equals to Address-3? : "
				+ address1.equals(address3));

			System.out.println("IP Address : "
							+ address1.getHostAddress());
			System.out.println(
				"Host Name for this IP Address : "
				+ address1.getHostName());

			System.out.println("IP Address in bytes : "
							+ address1.getAddress());

			System.out.println("Is this Address Multicast? : "
							+ address1.isMulticastAddress());

			System.out.println("Address in string form : "
							+ address1.toString());

			System.out.println(
				"Fully qualified domain name for this IP address : "
				+ address1.getCanonicalHostName());

			System.out.println("Hashcode for this IP address : "
							+ address1.hashCode());

			System.out.println(
				"Is the InetAddress an unpredictable address? : "
				+ address1.isAnyLocalAddress());
		}

}
