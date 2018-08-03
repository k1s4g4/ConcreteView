package com.example.vasilis.concreteview;



import android.content.Context;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.widget.Toast;

public class MyGLSurfaceView extends GLSurfaceView {

    private MyGLRenderer mRenderer;
    private float mPreviousX;
    private float mPreviousY;


    public MyGLSurfaceView(Context context){

        super(context);
    }
    public MyGLSurfaceView(Context context, AttributeSet attrs)
    {
        super(context, attrs);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event)
    {
        if (event != null)
        {
            float x = event.getX();
            float y = event.getY();
            int count = event.getPointerCount();

            if (event.getAction() == MotionEvent.ACTION_MOVE)
            {
                if(count==1){

                    if (mRenderer != null) {
                        if (Math.abs(x - mPreviousX) > 1) {
                            float deltaX = (x - mPreviousX) / 2 / 2f;
                            mRenderer.mDeltaX += deltaX;
                        }
                        if (Math.abs(y - mPreviousY) > 1) {
                            float deltaY = (y - mPreviousY) / 2 / 2f;
                            mRenderer.mDeltaY += deltaY;
                        }

                    }



                }else{


                }
                mPreviousX = x;
                mPreviousY = y;
            }

            if(event.getAction() == MotionEvent.ACTION_UP){

            }

            if(event.getAction() == MotionEvent.ACTION_DOWN){

                if(count==1){
                    mPreviousX = x;
                    mPreviousY = y;
                }else{

                }


            }


            return true;
        }
        else
        {
            return super.onTouchEvent(event);
        }
    }


    public void setRenderer(MyGLRenderer renderer)
    {
        mRenderer = renderer;
        super.setRenderer(mRenderer);
    }

}

