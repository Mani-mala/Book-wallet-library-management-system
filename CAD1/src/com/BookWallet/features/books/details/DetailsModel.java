package com.BookWallet.features.books.details;

import java.util.Optional;

import com.BookWallet.features.base.BaseModel;
import com.BookWallet.features.books.details.DetailsView;
import com.BookWallet.repository.db.BookWalletDb;
import com.BookWallet.repository.dto.Book;

public class DetailsModel extends BaseModel{
	private final DetailsView view;

    public DetailsModel(DetailsView view) {
        this.view = view;
    }

    void getBookDetails(String bookId) {
        if (bookId == null || bookId.trim().isEmpty()) {
            view.showMessage("Please enter a valid Book ID.");
            return;
        }

        Optional<Book> book = BookWalletDb.getInstance().getAllBooks().stream()
                .filter(b -> b.getId().equals(bookId))
                .findFirst();

        view.displayBookDetails(book.orElse(null));
    }
}
