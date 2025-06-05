package com.BookWallet.repository.db;

import java.util.ArrayList;
import java.util.List;

import com.BookWallet.repository.dto.Book;
import com.BookWallet.repository.dto.Library;
import com.BookWallet.repository.dto.RegistrationInfo;
import com.BookWallet.repository.dto.User;

public class BookWalletDb {
private static BookWalletDb sBookWalletDb;
private BookWalletDb()
{
	
}
public static BookWalletDb getInstance()
{
	if(sBookWalletDb==null)
	{
		sBookWalletDb=new BookWalletDb();
	}
	return sBookWalletDb;
}
private RegistrationInfo registrationInfo;
private Library library;
private List<Book> books=new ArrayList<>();
private List<User> users=new ArrayList<>();

public RegistrationInfo getRegistrationInfo() {
	return registrationInfo;
}
public void setRegistrationInfo(RegistrationInfo registrationInfo) {
	this.registrationInfo = registrationInfo;
}
public Library getLibrary() {
	return library;
}
public void setLibrary(Library library) {
	this.library = library;
}

public void addBook(Book book)
{
	books.add(book);
}
public List<Book> getAllBooks()
{
	return new ArrayList<>(books);
}
public void addUser(User user)
{
	users.add(user);
}
public List<User> getAllUsers()
{
	return new ArrayList<>(users);
}
public boolean validateLoginInfo(String userName, String password) {
    return registrationInfo.getUserName().equals(userName) && registrationInfo.getPassword().equals(password);
}
}
