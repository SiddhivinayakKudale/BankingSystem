package fit5042.bank.controllers;

import java.util.ArrayList;

import javax.el.ELContext;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import fit5042.bank.repository.entities.Users;

@Named(value = "transController")
@RequestScoped
public class TransController {

	private int transId; // this propertyId is the index, don't confuse with the Property Id

	public int getTransId() {
		return transId;
	}

	public void setTransId(int transId) {
		this.transId = transId;
	}

	private fit5042.bank.repository.entities.Transactions transaction;

	public TransController() {
		transId = Integer
				.valueOf(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("transactionID"));
		// Assign property based on the id provided
		transaction = getTransaction();
	}

	public fit5042.bank.repository.entities.Transactions getTransaction() {
		if (transaction == null) {
			// Get application context bean PropertyApplication
			ELContext context = FacesContext.getCurrentInstance().getELContext();
			TransactionApplication app = (TransactionApplication) FacesContext.getCurrentInstance().getApplication().getELResolver()
					.getValue(context, null, "transactionApplication");
			// -1 to propertyId since we +1 in JSF (to always have positive property id!)
			return app.getTransaction().get(--transId); // this propertyId is the index, don't confuse with the Property Id
		}
		return transaction;
	}

}
