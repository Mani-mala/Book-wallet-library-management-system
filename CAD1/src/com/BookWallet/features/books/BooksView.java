package com.BookWallet.features.books;

import java.util.Scanner;

import com.BookWallet.features.base.BaseView;
import com.BookWallet.features.books.details.DetailsView;
import com.BookWallet.features.books.manage.ManageView;
import com.BookWallet.features.books.search.SearchView;
import com.BookWallet.features.librarysetup.LibrarySetupView;
import com.BookWallet.repository.dto.Book;

public class BooksView extends BaseView{
	private final BooksModel model;
	private final Scanner sc=new Scanner(System.in);
	public BooksView()
	{
		model=new BooksModel(this);
	}
	public void init()
	{
		showMenu();
	}
	private void showMenu()
	{
		while(true)
		{
			System.out.println("**** Books ****");
            System.out.println("1. View All Books");
            System.out.println("2. Search Books");
            System.out.println("3. Manage Books");
            System.out.println("4. View Book Details");
            System.out.println("5. Back to Main Menu");
            System.out.println("6. Logout");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
           try
           {
        	   int choice=Integer.parseInt(sc.nextLine());
        	   switch(choice) {
        	   case 1:
        		   model.viewAllBooks();
        		   break;
        	   case 2:
        		   new SearchView().init();
        		   break;
        	   case 3:
        		   new ManageView().init();
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
        		System.out.println("Invalid choice!....try again!....");
        			  
        	   }
           }
           catch (NumberFormatException e) {
               System.out.println("Please enter a valid number.");
           }
		}
	}
	public void displayBooks(java.util.List<Book> books) {
        if (books.isEmpty()) {
            System.out.println("\nNo books found.");
            return;
        }

        System.out.println("**** Book List ****");
        System.out.printf("%-10s %-30s %-20s %-15s %-10s %-10s %-10s%n",
                "ID", "Name", "Author", "Genre", "Volume", "Year", "Available");
        System.out.println("--------------------------------------------------------------------------------");
        
        for (Book book : books) {
            System.out.printf("%-10s %-30s %-20s %-15s %-10d %-10d %-10d%n",
                    book.getId(),
                    book.getName(),
                    book.getAuthor(),
                    book.getGenre(),
                    book.getVolume(),
                    book.getPublishedYear(),
                    book.getAvailableCount());
        }
    }
}
