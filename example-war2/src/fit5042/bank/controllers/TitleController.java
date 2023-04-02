package fit5042.bank.controllers;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named(value = "titleController")
@RequestScoped
public class TitleController {
	private String pageTitle;

    public TitleController() {
        // Set the page title 
        pageTitle = "Indian Bank System";
    }

	public String getPageTitle() {
		return pageTitle;
	}

	public void setPageTitle(String pageTitle) {
		this.pageTitle = pageTitle;
	}
	
	@PostConstruct
	public void init() {
		pageTitle = "Online Bank System";
		
	}
}
