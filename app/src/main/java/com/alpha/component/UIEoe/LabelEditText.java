package com.alpha.component.UIEoe;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.alpha.component.app.R;

/**
 * Created by pete on 14-5-23.
 */
public class LabelEditText extends LinearLayout{

    private TextView textView;
    private  String labelText;
    private int labelFontSize;
    private String labelPosition;

    public LabelEditText(Context context, AttributeSet attrs) {
        super(context, attrs);

        int resourceId = attrs.getAttributeResourceValue(null,"labelText",0);
/*
        if(resourceId == 0)
            labelText = attrs.getAttributeValue(null,"labelText");
        else
            labelText = getResources().getString(resourceId);

        if (labelText == null)
            throw new RuntimeException("you must set labelText attribute");
*/
        if(resourceId == 0)
            labelText = attrs.getAttributeValue(null,"labelText");
        else
            labelText = getResources().getString(resourceId);

        if (labelText == null)
            throw new RuntimeException("you must set labelText attribute");

        resourceId = attrs.getAttributeResourceValue(null,"labelFontSize",0);

        if(resourceId == 0)
            labelFontSize = attrs.getAttributeIntValue(null,"labelFontSize",14);
        else
            labelFontSize = getResources().getInteger(resourceId);

        resourceId = attrs.getAttributeResourceValue(null,"labelPosition",0);

        if(resourceId == 0)
            labelPosition = attrs.getAttributeValue(null,"labelPosition");
        else
            labelPosition = getResources().getString(resourceId);

        if (labelPosition == null)
            labelPosition = "left";

        String infService = Context.LAYOUT_INFLATER_SERVICE;
        LayoutInflater li;

        li = (LayoutInflater)context.getSystemService(infService);
        LinearLayout linearLayout = null;

        if("left".equals(labelPosition))
            linearLayout = (LinearLayout)li.inflate(R.layout.labeledittext_horizantal,this);
        else if("top".equals(labelPosition))
            linearLayout = (LinearLayout)li.inflate(R.layout.labeledittext_vertical,this);
        else
            throw new RuntimeException("labelPosition attr just set to left or top");

        textView = (TextView)findViewById(R.id.textview);
        textView.setTextSize(labelFontSize);
        textView.setText(labelText);
    }
}
