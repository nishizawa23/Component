package com.alpha.component.UIEoe;


import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.TextView;

import com.alpha.component.app.R;

/**
 * Created by pete_doherty on 14-5-27.
 */
public class LabelEditTextRecouse extends TextView {

    private int resourceId = 0;
    private int iconPosition = 0;
    private Bitmap bitmap;
    final static String TAG = "LabelEditTextRecouse";


    public LabelEditTextRecouse(Context context, AttributeSet attrs) {
        super(context, attrs);

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.IconTextView);
        resourceId = typedArray.getResourceId(R.styleable.IconTextView_iconSrc,0);

        if(resourceId > 0)
            bitmap = BitmapFactory.decodeResource(getResources(),resourceId);
        iconPosition = typedArray.getInt(R.styleable.IconTextView_iconPosition,0);
    }

    @Override
    protected void onDraw(Canvas canvas){

        if(bitmap != null){

            Rect src = new Rect();
            Rect target = new Rect();
            src.left = 0;
            src.top = 0;
            src.right = bitmap.getWidth();
            src.bottom = bitmap.getHeight();

            int textHeight = (int)getTextSize();
            int left = 0;
            if(iconPosition == 1){
                left = (int)getPaint().measureText(getText().toString())+2;
            }
            target.left = left;
            target.top = (int)((getMeasuredHeight()-getTextSize())/2)+1;
            target.bottom = target.top + textHeight;
            target.right = left + (int)(textHeight*(bitmap.getWidth()/(float)bitmap.getHeight()));

            canvas.drawBitmap(bitmap,src,target,getPaint());
            if(iconPosition == 0)
                canvas.translate(target.right+2,0);

        }
        super.onDraw(canvas);

    }
}
