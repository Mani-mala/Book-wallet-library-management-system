package com.BookWallet.features.users.search;

import java.util.List;
import java.util.stream.Collectors;

import com.BookWallet.features.base.BaseModel;
import com.BookWallet.features.users.search.SearchView;
import com.BookWallet.repository.db.BookWalletDb;
import com.BookWallet.repository.dto.User;

public class SearchModel extends BaseModel{
	private final SearchView view;
    public SearchModel(SearchView view) {
        this.view = view;
    }

    void searchByName(String name) {
        if (name == null || name.trim().isEmpty()) {
            view.showMessage("Please enter a valid name.");
            return;
        }

        List<User> users = BookWalletDb.getInstance().getAllUsers().stream()
                .filter(user -> user.getFirstName().toLowerCase().contains(name.toLowerCase()) ||
                        user.getLastName().toLowerCase().contains(name.toLowerCase()))
                .collect(Collectors.toList());

        view.displayUsers(users);
    }
    void searchByEmail(String email) {
        if (email == null || email.trim().isEmpty()) {
            view.showMessage("Please enter a valid email.");
            return;
        }

        List<User> users = BookWalletDb.getInstance().getAllUsers().stream()
                .filter(user -> user.getEmail().toLowerCase().contains(email.toLowerCase()))
                .collect(Collectors.toList());

        view.displayUsers(users);
    }
    void searchByMobile(String mobile) {
        if (mobile == null || mobile.trim().isEmpty()) {
            view.showMessage("Please enter a valid mobile number.");
            return;
        }

        List<User> users = BookWalletDb.getInstance().getAllUsers().stream()
                .filter(user -> user.getMobileNumber().contains(mobile))
                .collect(Collectors.toList());

        view.displayUsers(users);
    }
}
