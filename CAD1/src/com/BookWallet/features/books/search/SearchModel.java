package com.BookWallet.features.books.search;

import java.util.List;
import java.util.stream.Collectors;
import com.BookWallet.features.base.BaseView;
import com.BookWallet.features.books.search.SearchView;
import com.BookWallet.repository.db.BookWalletDb;
import com.BookWallet.repository.dto.Book;

public class SearchModel extends BaseView{
	private final SearchView view;
	public SearchModel(SearchView view) {
        this.view = view;
    }
    void init() {

    }
    void searchByName(String name) {
        if (name == null || name.trim().isEmpty()) {
            view.showMessage("Please enter a valid name.");
            return;
        }

        List<Book> books = BookWalletDb.getInstance().getAllBooks().stream()
                .filter(book -> book.getName().toLowerCase().contains(name.toLowerCase()))
                .collect(Collectors.toList());

        view.displayBooks(books);
    }
    void searchByAuthor(String author) {
        if (author == null || author.trim().isEmpty()) {
            view.showMessage("Please enter a valid author name.");
            return;
        }

        List<Book> books = BookWalletDb.getInstance().getAllBooks().stream()
                .filter(book -> book.getAuthor().toLowerCase().contains(author.toLowerCase()))
                .collect(Collectors.toList());

        view.displayBooks(books);
    }
    void searchByGenre(String genre) {
        if (genre == null || genre.trim().isEmpty()) {
            view.showMessage("Please enter a valid genre.");
            return;
        }

        List<Book> books = BookWalletDb.getInstance().getAllBooks().stream()
                .filter(book -> book.getGenre().toLowerCase().contains(genre.toLowerCase()))
                .collect(Collectors.toList());

        view.displayBooks(books);
    }
}
