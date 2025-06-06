package com.BookWallet.features.base;
import com.BookWallet.features.registration.RegistrationView;
public class BaseView {
protected void logoutApp()
{
	System.out.println("!!!Logging out!!!");
	new RegistrationView().init();
}
protected void exitApp(){
    System.out.println("....Thank you for using BookWallet...come again :)");
    System.exit(0);
}
public void showMessage(String message) {
    System.out.println(message);
}
}
