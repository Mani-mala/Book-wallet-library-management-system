package com.BookWallet.features.books.manage;

import java.util.List;
import java.util.UUID;

import com.BookWallet.features.base.BaseModel;
import com.BookWallet.repository.db.BookWalletDb;
import com.BookWallet.repository.dto.Book;

public class ManageModel extends BaseModel{
	private final ManageView view;
	public ManageModel(ManageView view)
	{
		this.view=view;
	}
	void addBook(Book book)
	{
		if(validateBook(book))
		{
			book.setId(generateBookId());
			BookWalletDb.getInstance().addBook(book);
			view.showSuccessMessage("Book added Successfully!!");
		}else
		{
			view.showErrorMessage("Invalid book information...");
		}
	}
	void viewAllBooks()
	{
		List<Book> books=BookWalletDb.getInstance().getAllBooks();
		view.displayBooks(books);
	}
	  private boolean validateBook(Book book) {
	        return book != null &&
	               book.getName() != null && !book.getName().trim().isEmpty() &&
	               book.getAuthor() != null && !book.getAuthor().trim().isEmpty() &&
	               book.getGenre() != null && !book.getGenre().trim().isEmpty() &&
	               book.getVolume() > 0 &&
	               book.getPublishedYear() != null && book.getPublishedYear() >= 1800 && book.getPublishedYear() <= 2024 &&
	               book.getNoOfCopy() > 0 &&
	               book.getAvailableCount() >= 0 && book.getAvailableCount() <= book.getNoOfCopy();
	    }

	    private String generateBookId() {
	        return "MA" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
	    }

}
