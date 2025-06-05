package com.BookWallet.features.librarysetup;

import java.util.Scanner;

import com.BookWallet.features.base.BaseView;
import com.BookWallet.features.librarysetup.LibrarySetupModel;
import com.BookWallet.features.librarysetup.details.LibraryDetailsView;
import com.BookWallet.repository.dto.Library;

public class LibrarySetupView extends BaseView{
	private final LibrarySetupModel model;
	private final Scanner sc=new Scanner(System.in);
	
	public LibrarySetupView() {
        model = new LibrarySetupModel(this);
    }
	public void init()
	{
		model.init();
	}
	public void proceedToSetupLibrary()
	{
		System.out.println("*****LIBRARY SETUP*****");
		Library library=new Library();
		library.setName(getLibraryName());
		library.setAddress(getAddress());
		library.setPhoneNo(getPhoneNumber());
		library.setEmailId(getEmail());
		library.setIncharge(getIncharge());
        library.setCapacity(getCapacity());
        library.setOpeningTime(getOpeningTime());
        library.setClosingTime(getClosingTime());
        library.setNoAvailableDays(getAvailableDays());
        model.setupLibrary(library);
	}
	private String getLibraryName()
	{
		String name="";
		System.out.println("Enter Library name : ");
		do {
			name=sc.nextLine();
			 if (name.length() <3 || name.length() > 50)
	                System.out.println("Library name should be between 3 and 50 characters\nEnter valid name:");
	            else break;
		}while(true);
		return name;
	}
	private String getAddress()
	{
		String address="";
		System.out.println("Enter Library Address : ");
		do {
			address=sc.nextLine();
			 if (address.length() <3 || address.length() > 50)
	                System.out.println("Library Address should be between 3 and 50 characters\nEnter valid name:");
	            else break;
		}while(true);
		return address;
	}
    private String getPhoneNumber() {
        String phone = "";
        System.out.println("Enter Phone Number:");
        do {
            phone = sc.nextLine();
            if (!phone.matches("\\d{10}"))
                System.out.println("Phone number should be 10 digits\nEnter valid phone number:");
            else break;
        } while (true);
        return phone;
    }
    private String getEmail() {
        String email = "";
        System.out.println("Enter Email Address:");
        do {
            email = sc.nextLine();
            if (!email.matches("^[A-Za-z0-9+_.-]+@(.+)$"))
                System.out.println("Invalid email format\nEnter valid email:");
            else break;
        } while (true);
        return email;
    }
    private String getIncharge() {
        String incharge = "";
        System.out.println("Enter Library Incharge Name:");
        do {
            incharge = sc.nextLine();
            if (incharge.length() < 3 || incharge.length() > 50)
                System.out.println("Name should be between 3 and 50 characters\nEnter valid name:");
            else break;
        } while (true);
        return incharge;
    }
    private Integer getCapacity() {
        Integer capacity = null;
        System.out.println("Enter Library Capacity:");
        do {
            try {
                capacity = Integer.parseInt(sc.nextLine());
                if (capacity <= 0)
                    System.out.println("Capacity should be greater than 0\nEnter valid capacity:");
                else break;
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number\nEnter valid capacity:");
            }
        } while (true);
        return capacity;
    }
    private Long getOpeningTime() {
        Long time = null;
        System.out.println("Enter Opening Time (in 24-hour format, e.g., 900 for 9:00 AM):");
        do {
            try {
                time = Long.parseLong(sc.nextLine());
                if (time < 0 || time > 2359)
                    System.out.println("Time should be between 0000 and 2359\nEnter valid time:");
                else break;
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid time\nEnter valid time:");
            }
        } while (true);
        return time;
    }
    private Long getClosingTime() {
        Long time = null;
        System.out.println("Enter Closing Time (in 24-hour format, e.g., 1800 for 6:00 PM):");
        do {
            try {
                time = Long.parseLong(sc.nextLine());
                if (time < 0 || time > 2359)
                    System.out.println("Time should be between 0000 and 2359\nEnter valid time:");
                else break;
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid time\nEnter valid time:");
            }
        } while (true);
        return time;
    }
    private Integer getAvailableDays() {
        Integer days = null;
        System.out.println("Enter Number of Available Days per Week (1-7):");
        do {
            try {
                days = Integer.parseInt(sc.nextLine());
                if (days < 1 || days > 7)
                    System.out.println("Days should be between 1 and 7\nEnter valid days:");
                else break;
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number\nEnter valid days:");
            }
        } while (true);
        return days;
    }
    public void onLibrarySetupCompleted() {
        System.out.println("\nLibrary setup completed successfully!");
        showMainMenu();
    }
    public void showMainMenu()
    {
    	while(true)
    	{
    		System.out.println("**** BOOKWALLET MAIN MENU ****");
    		System.out.println("1.Manage Books");
    		System.out.println("2.View Books");
    		System.out.println("3.Manage Users");
    		System.out.println("4.View Users");
    		System.out.println("5.View Library Details");
    		System.out.println("6.Logout");
    		System.out.println("7.Exit");
    		System.out.println("Enter your choices");
    		
    		try {
                int choice = Integer.parseInt(sc.nextLine());
                switch (choice) {
                    case 1:
                    	new com.BookWallet.features.books.manage.ManageView().init();
                    	break;
                    case 2:
                    	new com.BookWallet.features.books.BooksView().init();
                    	break;
                    case 3:
                    	new com.BookWallet.features.books.manage.ManageView().init();
                    	break;
                    case 4:
                    	new com.BookWallet.features.users.UsersView().init();
                    	break;
                    case 5:
                    	new LibraryDetailsView().init();
                    case 6:
                    	System.out.println("Logging out...!");
                    	new com.BookWallet.features.registration.RegistrationView().init();
                    	return;
                    case 7:
                    	exitApp();
                    default:
                    	 System.out.println("Invalid choice!!!.... Please try again...!");
    			}
    		}
    		catch(NumberFormatException e)
    		{
    			System.out.println("Please enter a valid number");
    		}
    	}
    }
    public void showErrorMessage(String message)
    {
    	System.out.println(message);
    	proceedToSetupLibrary();
    }
}
