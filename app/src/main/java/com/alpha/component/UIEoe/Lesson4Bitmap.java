package com.alpha.component.UIEoe;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.alpha.component.app.R;

import java.io.InputStream;

public class Lesson4Bitmap extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_lesson4_bitmap);
        setContentView(new MyView(this));
    }

    private static class MyView extends View {

        private Bitmap bitmap1;
        private Bitmap bitmap2;
        private Bitmap bitmap3;
        private Bitmap bitmap4;
        private Drawable drawable;

        public MyView(Context context){

            super(context);
            setBackgroundColor(Color.BLUE);
            InputStream is = context.getResources().openRawResource(R.raw.shou);

            BitmapFactory.Options opts = new BitmapFactory.Options();
            opts.inSampleSize = 3;
            bitmap1 = BitmapFactory.decodeStream(is,null,opts);

            is = context.getResources().openRawResource(R.raw.th);
            bitmap2 = BitmapFactory.decodeStream(is);

            int w = bitmap2.getWidth();
            int h = bitmap2.getHeight();
            int[] pixel = new int [w*h];
            bitmap2.getPixels(pixel,0,w,0,0,w,h);

            bitmap3 = Bitmap.createBitmap(pixel,0,w,w,h, Bitmap.Config.ARGB_8888);
            bitmap4 = Bitmap.createBitmap(pixel,0,w,w,h, Bitmap.Config.ARGB_4444);

            drawable = context.getResources().getDrawable(R.drawable.ic_launcher);
            drawable.setBounds(50,300,180,420);
        }

        @Override
        protected void onDraw(Canvas canvas){

            canvas.drawBitmap(bitmap1,10,10,null);
            canvas.drawBitmap(bitmap2,10,500,null);
            canvas.drawBitmap(bitmap3,300,500,null);
            canvas.drawBitmap(bitmap4,600,500,null);
            drawable.draw(canvas);


        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.lesson4_bitmap, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
