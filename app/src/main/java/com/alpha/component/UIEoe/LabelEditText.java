package com.alpha.component.UIEoe;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;

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
    }
}
