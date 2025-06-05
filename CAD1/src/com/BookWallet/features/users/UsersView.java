package com.BookWallet.features.users;

import java.util.Scanner;

import com.BookWallet.features.base.BaseView;
import com.BookWallet.features.users.details.DetailsView;
import com.BookWallet.features.books.manage.ManageView;
import com.BookWallet.features.books.search.SearchView;
import com.BookWallet.features.librarysetup.LibrarySetupView;

public class UsersView extends BaseView{
	private final UsersModel model;
	private final Scanner sc=new Scanner(System.in);
	
	public UsersView()
	{
		model=new UsersModel(this);
	}
	public void init()
	{
		showMenu();
	}
	private void showMenu()
	{
		while(true) {
			System.out.println("\n=== User Management ===");
            System.out.println("1. Add/Manage Users");
            System.out.println("2. List All Users");
            System.out.println("3. Search Users");
            System.out.println("4. View User Details");
            System.out.println("5. Back to Main Menu");
            System.out.println("6. Logout");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            
            try {
            	int choice=Integer.parseInt(sc.nextLine());
            	switch(choice)
            	{
            	case 1:
            		new ManageView().init();
            		break;
            	case 2:
            		model.listAllUsers();
            		break;
            	case 3:
            		new SearchView().init();
            		break;
            	case 4:
            		new DetailsView().init();
            		break;
            	case 5:
            		new LibrarySetupView().showMainMenu();
            		return;
            	case 6:
            		logoutApp();
            		return;
            	case 7:
            		exitApp();
            	default:
            		System.out.println("Invalid choice!....Try again..!");
            	}
            }
            	catch (NumberFormatException e) {
                    System.out.println("Please enter a valid number.");
		}
	}
	}
	public void displayUsers(java.util.List<com.BookWallet.repository.dto.User> users)
	{
		if (users.isEmpty()) {
            System.out.println("\nNo users found.");
            return;
        }

        System.out.println("\n=== User List ===");
        System.out.printf("%-15s %-20s %-20s %-15s %-15s%n",
                "User ID", "First Name", "Last Name", "Email", "Mobile");
        System.out.println("--------------------------------------------------------------------------------");
        
        for(com.BookWallet.repository.dto.User user:users)
        {
        	 System.out.printf("%-15s %-20s %-20s %-15s %-15s%n",
                     user.getUserId(),
                     user.getFirstName(),
                     user.getLastName(),
                     user.getEmail(),
                     user.getMobileNumber());
        }
	}
	public void showMessage(String message)
	{
		System.out.println(message);
	}
	}
