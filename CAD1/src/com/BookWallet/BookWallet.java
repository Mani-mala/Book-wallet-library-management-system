package com.BookWallet;
import com.BookWallet.features.registration.RegistrationView;
public class BookWallet {
	public static final String appVersion="1.0";
	public static final String appName="BookWallet";
	public static void main(String[] args)
	{
		System.out.println("Welcome to " + appName + " - Version: " + appVersion);
		new RegistrationView().init();
	}
}
