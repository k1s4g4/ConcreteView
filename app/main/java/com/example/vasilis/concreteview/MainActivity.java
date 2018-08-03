package com.example.vasilis.concreteview;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;
import android.widget.Toast;

public class MainActivity extends Activity {

    private MyGLSurfaceView myGLView;
    private MyGLRenderer mRenderer;
    private SeekBar mSeekBar;
    private int mProgress=50;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //myGLView=new MyGLSurfaceView(this);
        //setContentView(myGLView);

        setContentView(R.layout.activity_main);

        myGLView=(MyGLSurfaceView)findViewById(R.id.gl_surface_view);

        myGLView.setEGLContextClientVersion(2);

        mRenderer=new MyGLRenderer(this,myGLView);
        myGLView.setRenderer(mRenderer);

        findViewById(R.id.button_perspective).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeView();
            }
        });
        mSeekBar= (SeekBar) findViewById(R.id.seek_bar);
        mSeekBar.setMax(100);
        mSeekBar.setProgress(50);
        mSeekBar.refreshDrawableState();
        mSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if(mRenderer.persp==true){
                    mRenderer.mScale=((float)progress)/60.f;
                    mProgress=progress;
                }else{
                    mProgress=progress;
                    mRenderer.mScale=((float)progress)/100.f;
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    @Override
    protected void onResume()
    {
        // The activity must call the GL surface view's onResume() on activity onResume().
        super.onResume();
        myGLView.onResume();
    }

    @Override
    protected void onPause()
    {
        // The activity must call the GL surface view's onPause() on activity onPause().
        super.onPause();
        myGLView.onPause();
    }

    private void changeView(){

        myGLView.queueEvent(new Runnable() {
            @Override
            public void run() {
                if(mRenderer.persp){
                    mRenderer.persp=false;
                    mRenderer.mScale=((float)mProgress)/100.f;

                }else{
                    mRenderer.persp=true;
                    mRenderer.mScale=((float)mProgress)/60.f;
                }
            }
        });
        if(mRenderer.persp){
            Toast.makeText(this,"Orthographic",Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this,"Perspective",Toast.LENGTH_SHORT).show();
        }

    }
}
