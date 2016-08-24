package com.google.gwt.sample.ContactApplication.client;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;

//All imports 
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.FormPanel;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

//Entry Class
public class ContactApplication implements EntryPoint{
	  		
	// All Buttons and Panels Initialised
	  protected static VerticalPanel mainPanel = new VerticalPanel();
	  protected static FlexTable contactsFlexTable = new FlexTable();
	  protected static HorizontalPanel addPanel = new HorizontalPanel();
	  protected static HorizontalPanel buttonPanel = new HorizontalPanel();
	  protected static HorizontalPanel buttonPaneledit = new HorizontalPanel();	 
	  protected static HorizontalPanel addcontactPanel = new HorizontalPanel(); 
	  
	  private Button addcontactButton = new Button("Add Contact");
	  static FormPanel form= new FormPanel();
	  public static DialogBox dialog=new DialogBox();
	  public static DialogBox dialogedit=new DialogBox();
	  TextBox newSymbolTextBox = new TextBox();
	  static TextBox newTextBox = new TextBox();
	  TextBox job = new TextBox();
	  static TextBox jobedit = new TextBox();
	  ListBox lb = new ListBox();
	  ListBox group= new ListBox();
	  static ListBox groupedit= new ListBox(); 
	  static ListBox lbedit = new ListBox();
	  static CheckBox checkedit= new CheckBox();
	  CheckBox check= new CheckBox();
	  
	  //DataStructures Used
	  static ArrayList<String> contacts = new ArrayList<String>();
	  private static HashMap<String, ArrayList<String>> Datastore= new HashMap<String, ArrayList<String>>();
	  static TreeMap<String, ArrayList<String>> Sorted= new TreeMap<String, ArrayList<String>>(Datastore);
	 
	  final String removal = new String("");
	 
	  //MAIN METHOD
	  public void onModuleLoad() {
				 
		  contactsFlexTable.getColumnFormatter().setWidth(0, "100px");
		  contactsFlexTable.getColumnFormatter().setWidth(1, "100px");
		  contactsFlexTable.getColumnFormatter().setWidth(2, "100px");
		  contactsFlexTable.getColumnFormatter().setWidth(3, "100px");
		  contactsFlexTable.getColumnFormatter().setWidth(4, "100px");
		  contactsFlexTable.getColumnFormatter().setWidth(5, "100px");

		  	contactsFlexTable.setText(0, 0, "Name  ");
		    contactsFlexTable.setText(0, 1, "Job Title");
		    contactsFlexTable.setText(0, 2, "Age");
		    contactsFlexTable.setText(0, 3, "Group");  
		    contactsFlexTable.setText(0, 4, "Manager");
		    contactsFlexTable.getRowFormatter().addStyleName(0, "watchListHeader");
		    contactsFlexTable.addStyleName("watchList");
		  
		    addcontactButton.removeStyleName("gwt-Button");
		    addcontactButton.addStyleName("addcontactButton");
		   
		    //addPanel (Add Contact Button)
		    addPanel.add(addcontactButton);
		    addPanel.setCellHorizontalAlignment(addcontactButton,HasHorizontalAlignment.ALIGN_RIGHT);
		    addPanel.add(addcontactPanel);
		    addPanel.addStyleName("addPanel");
		    
		    // Assemble Main panel.
		    mainPanel.add(addPanel); 
		    mainPanel.add(contactsFlexTable);
		    mainPanel.addStyleName("displayed");
		   
		    // Add to Root
		    RootPanel.get("Contacts").add(mainPanel);
		   
		    
		    //INITIALISE WITH 3 CONTACTS
		    String currentname= "Contact 1";
		    contacts= new ArrayList<String>();
		    contacts.add("Managing Director");
		    contacts.add("34");
		    contacts.add("Management");
		    contacts.add("Y");
		  
		    Sorted.put(currentname, contacts);
		    
		    currentname="Contact 2";
		    contacts= new ArrayList<String>();
		    contacts.add("CFO");
		    contacts.add("44");
		    contacts.add("Management");
		    contacts.add("Y");
		  
		    Sorted.put(currentname, contacts);
			     
		    currentname= "Contact 3";
		    contacts= new ArrayList<String>();
		    contacts.add("Engineering Intern");
		    contacts.add("21");
		    contacts.add("Engineering");
		    contacts.add("N");
		  
		    Sorted.put(currentname, contacts);
			
		    // Entries in the FLEX TABLE
		    for(String key : Sorted.keySet()) {
    			final int row1 = contactsFlexTable.getRowCount();
    			
		    	contacts= Sorted.get(key);
    			contactsFlexTable.setText(row1, 0, key);
				contactsFlexTable.setText(row1, 1, contacts.get(0));
				contactsFlexTable.setText(row1, 2, contacts.get(1));
				contactsFlexTable.setText(row1, 3, contacts.get(2));
				contactsFlexTable.setText(row1, 4, contacts.get(3));
				
				delContact del = new delContact();
				del.putdelete(row1);   
				editContact ed = new editContact();
				ed.putedit(row1);	
		    }

		    //ONClick Method for Add Contact Method
		  		addcontactButton.addClickHandler(new ClickHandler() {
		        public void onClick(ClickEvent event) {
		         addindata();
		        }
		      });
		    
		    }
	  
	// Data Structure Update....
	  public static ArrayList<String> parsearraylist(String a, String b, String c,String d) {
			contacts= new ArrayList<String>();
		  	contacts.add(a);
			contacts.add(b);
			contacts.add(c);
			contacts.add(d);
			return contacts;
	  		}
	  
	  // Add Method : After you click Add Contact 
	  public void addindata(){
		  addContact n = new addContact();   
	  }
	 	  	  	
}


