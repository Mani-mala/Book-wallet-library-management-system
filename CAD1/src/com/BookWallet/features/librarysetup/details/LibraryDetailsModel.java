package com.BookWallet.features.librarysetup.details;

import com.BookWallet.features.base.BaseModel;
import com.BookWallet.repository.db.BookWalletDb;
import com.BookWallet.repository.dto.Library;

public class LibraryDetailsModel extends BaseModel{
	private final LibraryDetailsView view;
	public LibraryDetailsModel(LibraryDetailsView view)
	{
		this.view=view;
	}
	void getLibraryDetails()
	{
		Library library=BookWalletDb.getInstance().getLibrary();
		view.displayLibraryDetails(library);
	}
}
