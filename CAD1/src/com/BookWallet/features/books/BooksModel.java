package com.BookWallet.features.books;

import java.util.List;

import com.BookWallet.features.base.BaseModel;
import com.BookWallet.repository.db.BookWalletDb;
import com.BookWallet.repository.dto.Book;

public class BooksModel extends BaseModel{
	private final BooksView view;
	public BooksModel(BooksView view)
	{
		this.view=view;
	}
	void viewAllBooks()
	{
		List<Book> books=BookWalletDb.getInstance().getAllBooks();
		view.displayBooks(books);
	}
}
