package com.koleshop.appkoleshop.listeners;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by Gundeep on 23/02/15.
 */
public class KolRecyclerTouchListener implements RecyclerView.OnItemTouchListener
{
    String TAG = "RecyclerViewTouch";
    KolClickListener clickListener;
    GestureDetector gestureDetector;
    public KolRecyclerTouchListener(Context context, final RecyclerView rv, final KolClickListener clickListener)
    {
        //Log.d(TAG, "Recycler Touch Listener constructor");
        this.clickListener = clickListener;
        gestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener(){
            @Override
            public boolean onSingleTapUp(MotionEvent e) {
                Log.d(TAG, "Gesture Detector single tap up");
                return true;
            }

            @Override
            public void onLongPress(MotionEvent e) {
                Log.d(TAG, "Gesture Detector long press");
                View child = rv.findChildViewUnder(e.getX(), e.getY());
                if(child!=null && clickListener!=null)
                {
                    RecyclerView.ViewHolder holder = rv.getChildViewHolder(child);
                    clickListener.onItemLongClick(child, holder.getAdapterPosition());
                }
                super.onLongPress(e);
            }
        });

    }

    @Override
     public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
    //Log.d(TAG, "on intercept touch event");
    View child = rv.findChildViewUnder(e.getX(), e.getY());
    boolean gestureDetected = gestureDetector.onTouchEvent(e);
    if(child!=null && rv!=null && gestureDetected)
    {
        RecyclerView.ViewHolder holder = rv.getChildViewHolder(child);
        clickListener.onItemClick(child, holder.getAdapterPosition());
    }
    return false;
}

    @Override
    public void onTouchEvent(RecyclerView rv, MotionEvent e) {

    }

    @Override
    public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

    }
}