package com.BookWallet.features.users.manage;

import java.util.List;
import java.util.UUID;

import com.BookWallet.features.base.BaseModel;
import com.BookWallet.features.users.manage.ManageView;
import com.BookWallet.repository.db.BookWalletDb;
import com.BookWallet.repository.dto.User;

public class ManageModel extends BaseModel{
	  private final ManageView view;

	    public ManageModel(ManageView view) {
	        this.view = view;
	    }

	    void addUser(User user) {
	        if (validateUser(user)) {
	            user.setUserId(generateUserId());
	            BookWalletDb.getInstance().addUser(user);
	            view.showSuccessMessage("User added successfully!");
	        } else {
	            view.showErrorMessage("Invalid user information. Please try again.");
	        }
	    }
	    void viewAllUsers() {
	        List<User> users = BookWalletDb.getInstance().getAllUsers();
	        view.displayUsers(users);
	    }
	    private boolean validateUser(User user) {
	        return user != null &&
	               user.getFirstName() != null && !user.getFirstName().trim().isEmpty() &&
	               user.getLastName() != null && !user.getLastName().trim().isEmpty() &&
	               user.getEmail() != null && user.getEmail().matches("^[A-Za-z0-9+_.-]+@(.+)$") &&
	               user.getMobileNumber() != null && user.getMobileNumber().matches("\\d{10}") &&
	               user.getAddress() != null && !user.getAddress().trim().isEmpty() &&
	               user.getDob() != null && user.getDob().matches("\\d{2}/\\d{2}/\\d{4}");
	    }

	    private String generateUserId() {
	        return "USR" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
	    }
}
