package com.BookWallet.features.registration;

import com.BookWallet.features.base.BaseModel;
import com.BookWallet.repository.db.BookWalletDb;
import com.BookWallet.repository.dto.RegistrationInfo;

class RegistrationModel{
private final RegistrationView view;
 
public RegistrationModel(RegistrationView registrationView)
{
	view=registrationView;
}
void init()
{
	if(BookWalletDb.getInstance().getRegistrationInfo()!=null)
	{
		view.proceedLogin();
	}else
	{
		view.proceedRegistration();
	}
}
void registerUser(RegistrationInfo info)
{
	if(ifAlreadyExist(info.getUserName()))
	{
		 view.showErrorMessage("Username already Exist");
	}
	else if(isWeekPassWord())
	{
		view.showErrorMessage("Please enter Strong password!..");
	}
	else
	{
		BookWalletDb.getInstance().setRegistrationInfo(info);
		view.onRegistrationSuccess(info);
	}
}
private boolean isWeekPassWord()
{
	return false;
}
private boolean ifAlreadyExist(String userName) {
    return false;
}
public void validateCredentials(String userName,String password)
{
	if(BookWalletDb.getInstance().validateLoginInfo(userName,password))
	{
		view.onSuccessLogin(userName);
    } else{
        view.onInvalidCredentials();
	}
}
}
