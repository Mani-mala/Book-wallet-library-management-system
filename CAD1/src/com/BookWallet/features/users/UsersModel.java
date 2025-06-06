package com.BookWallet.features.users;

import java.util.List;

import com.BookWallet.features.base.BaseModel;
import com.BookWallet.features.users.UsersView;
import com.BookWallet.repository.db.BookWalletDb;
import com.BookWallet.repository.dto.User;

public class UsersModel extends BaseModel{
	

    private final UsersView view;

    public UsersModel(UsersView view) {
        this.view = view;
    }

    void listAllUsers() {
        List<User> users = BookWalletDb.getInstance().getAllUsers();
        view.displayUsers(users);
    }
}
