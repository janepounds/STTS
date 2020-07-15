package com.example.seedtrackingtracing;

import android.content.Context;
import android.text.method.DigitsKeyListener;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class Dates extends LinearLayout{

    TextView label;
    EditText txtBox;
    public Dates(Context context, String labelText, String initialText) {
        super(context);
        label = new TextView(context);
        label.setText(labelText);
        txtBox = new EditText(context);
        txtBox.setText(initialText);
        txtBox.setLayoutParams(new LayoutParams(ViewGroup.LayoutParams
                .FILL_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT));
        this.addView(label);
        this.addView(txtBox);
    }

    public Dates(Context context, AttributeSet attrs) {
        super(context, attrs);
        // TODO Auto-generated constructor stub
    }


    public String getValue()
    {
        return txtBox.getText().toString();
    }
    public void setValue(String v)
    {
        txtBox.setText(v);
    }
}
