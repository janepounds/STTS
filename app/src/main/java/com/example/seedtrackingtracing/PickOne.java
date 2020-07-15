package com.example.seedtrackingtracing;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

public class PickOne extends LinearLayout {
    String tag = PickOne.class.getName();
    TextView label;
    ArrayAdapter<String> aa;
    Spinner spinner;

    public PickOne(Context context, String labelText, String options) {
        super(context);
        label = new TextView(context);
        label.setText(labelText);
        spinner = new Spinner(context);
        String []opts = options.split("\\|");
        aa = new ArrayAdapter<String>( context,
                android.R.layout.simple_spinner_item,opts);
        spinner.setAdapter(aa);
        this.addView(label);
        this.addView(spinner);
    }

    public PickOne(Context context, AttributeSet attrs) {
        super(context, attrs);
        // TODO Auto-generated constructor stub
    }

    public String getValue()
    {
        return (String) spinner.getSelectedItem().toString();
    }
}
