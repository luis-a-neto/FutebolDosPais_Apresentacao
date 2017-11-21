package br.com.futeboldospais.futeboldospais.util;

import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;

/**
 * Created by ThirdSystem on 20/11/2017.
 */

public class CustomGestureDetector implements GestureDetector.OnGestureListener,
        GestureDetector.OnDoubleTapListener {

    @Override
    public boolean onSingleTapConfirmed(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onDoubleTap(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onDoubleTapEvent(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onDown(MotionEvent e) {
        return false;
    }

    @Override
    public void onShowPress(MotionEvent e) {
    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        return false;
    }

    @Override
    public void onLongPress(MotionEvent e) {
    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        if (e1.getX() < e2.getX()) {
            Log.d("teste", "Left to Right swipe performed");
        }

        if (e1.getX() > e2.getX()) {
            Log.d("teste", "Right to Left swipe performed");
        }

        if (e1.getY() < e2.getY()) {
            Log.d("teste", "Up to Down swipe performed");
        }

        if (e1.getY() > e2.getY()) {
            Log.d("teste", "Down to Up swipe performed");
        }

        return true;
    }
}