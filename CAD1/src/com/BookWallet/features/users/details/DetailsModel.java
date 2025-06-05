package com.BookWallet.features.users.details;
import java.util.Optional;
import com.BookWallet.features.users.details.DetailsView;
import com.BookWallet.repository.db.BookWalletDb;
import com.BookWallet.repository.dto.User;

public class DetailsModel {
	private final DetailsView view;
    public DetailsModel(DetailsView view) {
        this.view = view;
    }
    void getUserDetails(String userId) {
        if (userId == null || userId.trim().isEmpty()) {
            view.showMessage("Please enter a valid User ID.");
            return;
        }

        Optional<User> user = BookWalletDb.getInstance().getAllUsers().stream()
                .filter(u -> u.getUserId().equals(userId))
                .findFirst();

        view.displayUserDetails(user.orElse(null));
    }
}
