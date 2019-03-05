package ru.dudin.drawwithfinger;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class MySurfaceView extends SurfaceView {

    private Path mPath;
    private Paint mPaint;
    private SurfaceHolder mSurfaceHolder;

    public MySurfaceView(Context context) {
        super(context);
        initPaint();
        initSurfaceHolder();
    }

    private void initPaint() {
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(3);
        mPaint.setColor(Color.BLUE);
    }

    private void initSurfaceHolder() {
        mSurfaceHolder = getHolder();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if(event.getAction() == MotionEvent.ACTION_DOWN) {
            mPath = new Path();
            mPath.moveTo(event.getX(), event.getY());
        } else if(event.getAction() == MotionEvent.ACTION_MOVE) {
            mPath.lineTo(event.getX(), event.getY());
        } else if(event.getAction() == MotionEvent.ACTION_UP) {
            mPath.lineTo(event.getX(), event.getY());
        }

        if(mPath != null) {
            Canvas canvas = mSurfaceHolder.lockCanvas();
            canvas.drawPath(mPath, mPaint);
            mSurfaceHolder.unlockCanvasAndPost(canvas);
        }

        return true;
    }
}