package com.google.gwt.sample.ContactApplication.client;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class NewUser extends ContactApplication{
	public NewUser(){
		dialog= new DialogBox();
		dialog.setGlassEnabled(true);
		dialog.setText("New Contact Details : ");
		  
		HorizontalPanel HP=new HorizontalPanel();  
		VerticalPanel panel= new VerticalPanel();
		panel.setSpacing(10);
		panel.setHeight("100");
		panel.setWidth("300");
	      
	    //NAME TEXTBOX
	    newSymbolTextBox = new TextBox();
	    Label label= new Label("Name: ");
	    panel.add(label);
	    newSymbolTextBox.setWidth("220");    
	    HP.add(label);
		  
	    newSymbolTextBox.setName("textBoxFormElement");
	    HP.add(newSymbolTextBox);
	    panel.add(HP);
	
	    //JOB TEXTBOX
	    HP=new HorizontalPanel();
	    label= new Label("Job Title: "); 
	    HP.add(label); 
	   
	    job = new TextBox();
	    job.setWidth("220");

	    HP.add(job);
	    job.setName("textBoxFormElement");
	    panel.add(HP);

	    HP=new HorizontalPanel();      
	    label= new Label("Age: ");
	    HP=new HorizontalPanel();
	    
	    //AGE DROPDOWN
	    lb = new ListBox();
	    lb.setName("Age:");
	    for (int i=15;i<=100;i++) {
	   	  String ll= ""+i;
	   	  lb.addItem(ll);
	    }
	    
	    lb.setWidth("220");
	      
	    HP.add(label);
	    HP.add(lb);
	    panel.add(HP);
	    
	    //GROUP DROPDOWN
	    HP=new HorizontalPanel();
	    label= new Label("Group: ");
	    HP.add(label);
	  
	    group = new ListBox();
	    group.setName("Group");
	    group.addItem("Engineering");
	    group.addItem("Finance");
	    group.addItem("Front Office");
	    group.addItem("Management");
	    group.addItem("IT");
	    group.addItem("Sales");
	      
	    HP.add(group);
	    panel.add(HP);
	    
	    //MANAGER CHECKBOX
	      
	    check= new CheckBox("Manager");
	    check.setValue(false);
	    panel.add(check);
	      
	    buttonPanel.clear();
		Button submit=new Button("Submit");
		buttonPanel.add(submit);
			      
		Button cancel=new Button("Cancel");
		buttonPanel.add(cancel);
		buttonPanel.setSpacing(10);
		panel.add(buttonPanel);
				     
		addPanel.add(panel);
		dialog.addStyleName("displayed");
		dialog.add(panel);	      
		addPanel.add(dialog);
		
		dialog.show();
		dialog.center();
				     
		dialog.addStyleDependentName("buttonstyle");
		newSymbolTextBox.setFocus(true);
			      
		//ONClick Method for Cancel Button
				  
		cancel.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				dialog.hide();  
			}
		});
	  
		// ONClick method for SUBMIT BUTTON		  
		submit.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {	        	 
				dialog.hide();
	        	if (newSymbolTextBox.getText().length() == 0 || job.getText().length() == 0  ) {
	        		 if (newSymbolTextBox.getText().length() == 0) {
	        			 Window.alert("The Name Field must not be empty");
	        		 } else {
	        			 Window.alert("The Job Field must not be empty");
		        		 }
		        		 dialog.show();
		        	} else {
		        		final String names= newSymbolTextBox.getText();
		        		final String jobs= job.getText();
		        		final String age= lb.getSelectedItemText();
		        		final String gr=group.getSelectedItemText();
		        		String manager= "N";
		   	     
		        		if (check.getValue()) {
		        			final String val= "Y";
		        			manager= val;
		        		} else {
		        			final String val= "N";
		        			manager= val;
		        		}
		   		if (Sorted.containsKey(names)) {
						Window.alert("Contact Already Present");
						dialog.show();
				} else {
	        		contacts=parsearraylist(jobs,age,gr,manager);
	        		Sorted.put(names, contacts);
	        		contactsFlexTable.clear();
	        		int row=1;
	        		for(String key : Sorted.keySet()) {
	        			contacts= Sorted.get(key);
	        			contactsFlexTable.setText(row, 0, key);
						contactsFlexTable.setText(row, 1, contacts.get(0));
						contactsFlexTable.setText(row, 2, contacts.get(1));
						contactsFlexTable.setText(row, 3, contacts.get(2));
						contactsFlexTable.setText(row, 4, contacts.get(3));
						ExistingUser del = new ExistingUser();
						del.putdelete(row);
						ExistingUser ed = new ExistingUser();
						ed.putedit(row);
						row=row+1;
	        		}
				 }	
		       }		
		    }
	     });
	}
}
