package com.example.seedtrackingtracing;

import java.net.URLEncoder;
import java.util.ListIterator;
import java.util.Vector;

public class Form {
    private String formNumber;
    private String formName;
    private String submitTo;
    public Vector<FormField> fields;


    public Form()
    {
        this.fields = new Vector<FormField>();
        formNumber = "";
        formName = "";
       // submitTo = "loopback"; // ie, do nothing but display the results
    }
    // getters & setters
    public String getFormNumber() {
        return formNumber;
    }

    public void setFormNumber(String formNumber) {
        this.formNumber = formNumber;
    }


    public String getFormName() {
        return formName;
    }
    public void setFormName(String formName) {
        this.formName = formName;
    }

    public String getSubmitTo() {
        return submitTo;
    }

    public void setSubmitTo(String submitTo) {
        this.submitTo = submitTo;
    }

    public Vector<FormField> getFields() {
        return fields;
    }

    public void setFields(Vector<FormField> fields) {
        this.fields = fields;
    }

    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("Form:\n");
        sb.append("Form Number: " + this.formNumber + "\n");
        sb.append("Form Name: " + this.formName + "\n");
        sb.append("Submit To: " + this.submitTo + "\n");
        if (this.fields == null) return sb.toString();
        ListIterator<FormField> li = this.fields.listIterator();
        while (li.hasNext()) {
            sb.append(li.next().toString());
        }

        return sb.toString();
    }

    public String getFormattedResults()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("Results:\n");
        if (this.fields == null) return sb.toString();
        ListIterator<FormField> li = this.fields.listIterator();
        while (li.hasNext()) {
            sb.append(li.next().getFormattedResult() + "\n");
        }

        return sb.toString();
    }

    public String getFormEncodedData()
    {
        try {
            int i = 0;
            StringBuilder sb = new StringBuilder();
            if (this.fields == null) return sb.toString();
            ListIterator<FormField> li = this.fields.listIterator();
            while (li.hasNext()) {
                if (i != 0) sb.append("&");
                FormField thisField = li.next();
                sb.append(thisField.name + "=");
                String encstring = new String();
                String rawString = (String) thisField.getData();
                encstring = URLEncoder.encode(rawString);
                sb.append(encstring);
                i++;
            }
            return sb.toString();
        }
        catch (Exception e) {
            e.printStackTrace();
            return "ErrorEncoding " + e.getMessage();
        }
    }
}
