package com.github.florent37.materialtextfield;

import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by florentchampigny on 27/08/15.
 */
public class MaterialTextField extends FrameLayout implements View.OnClickListener {

    protected static final int ANIMATION_DURATION = 400;
    protected static final boolean OPEN_KEYBOARD_ON_FOCUS = true;

    protected TextView label;
    protected View card;
    protected ImageView image;
    protected EditText editText;

    protected int labelTopMargin = -1;
    protected boolean expanded = false;

    public MaterialTextField(Context context) {
        super(context);
    }

    public MaterialTextField(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MaterialTextField(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }




    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();

        addView(LayoutInflater.from(getContext()).inflate(R.layout.mtf_layout, this, false));

        label = (TextView) findViewById(R.id.mtf_label);
        label.setPivotX(0);
        label.setPivotY(0);

        card = findViewById(R.id.mtf_card);

        image = (ImageView) findViewById(R.id.mtf_image);
        ((View)image).setAlpha(0);
        image.setScaleX(0.4f);
        image.setScaleY(0.4f);

        editText = (EditText)findViewById(R.id.mtf_editText);
        editText.setAlpha(0f);

        this.setOnClickListener(this);

        labelTopMargin = FrameLayout.LayoutParams.class.cast(label.getLayoutParams()).topMargin;
    }


    @Override
    public void onClick(View v) {
        if(expanded) {
            label.animate().alpha(1).setDuration(ANIMATION_DURATION).start();
            label.animate().scaleX(1).setDuration(ANIMATION_DURATION).start();
            label.animate().scaleY(1).setDuration(ANIMATION_DURATION).start();

            label.animate().translationY(0).setDuration(ANIMATION_DURATION).start();

            image.animate().alpha(0).scaleX(0.4f).scaleY(0.4f).setDuration(ANIMATION_DURATION).start();
            editText.animate().alpha(1).setDuration(ANIMATION_DURATION).start();
            editText.clearFocus();

            if(OPEN_KEYBOARD_ON_FOCUS)
                ((InputMethodManager)getContext().getSystemService(Context.INPUT_METHOD_SERVICE)).hideSoftInputFromWindow(editText.getWindowToken(), InputMethodManager.SHOW_IMPLICIT);


            ValueAnimator expand = ValueAnimator.ofInt(card.getHeight(), getContext().getResources().getDimensionPixelOffset(R.dimen.mtf_cardHeight_initial));
            expand.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator animation) {
                    Integer value = (Integer) animation.getAnimatedValue();
                    card.getLayoutParams().height = value.intValue();
                    card.requestLayout();
                }
            });
            expand.setDuration(ANIMATION_DURATION).start();

        }else {
            label.animate().alpha(0.4f).setDuration(ANIMATION_DURATION).start();
            label.animate().scaleX(0.7f).setDuration(ANIMATION_DURATION).start();
            label.animate().scaleY(0.7f).setDuration(ANIMATION_DURATION).start();

            label.animate().translationY(-labelTopMargin).setDuration(ANIMATION_DURATION).start();

            image.animate().alpha(0.3f).scaleX(1).scaleY(1).setDuration(ANIMATION_DURATION).start();
            editText.animate().alpha(1).setDuration(ANIMATION_DURATION).start();
            editText.requestFocus();

            if(OPEN_KEYBOARD_ON_FOCUS)
                ((InputMethodManager)getContext().getSystemService(Context.INPUT_METHOD_SERVICE)).showSoftInput(editText, InputMethodManager.SHOW_IMPLICIT);

            ValueAnimator expand = ValueAnimator.ofInt(0, getContext().getResources().getDimensionPixelOffset(R.dimen.mtf_cardHeight_final));
            expand.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator animation) {
                    Integer value = (Integer) animation.getAnimatedValue();
                    card.getLayoutParams().height = value.intValue();

                    card.requestLayout();
                }
                    });
            expand.setDuration(ANIMATION_DURATION).start();
        }

        expanded = !expanded;
    }
}
