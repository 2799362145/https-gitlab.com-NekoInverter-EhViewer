/*
 * Copyright 2016 Hippo Seven
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.hippo.ehviewer.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.util.AttributeSet;

import com.hippo.drawerlayout.DrawerLayoutChild;

public class EhNavigationView extends NavigationView implements DrawerLayoutChild {

    private static final int SCRIM_COLOR = 0x44000000;
    private Paint mPaint;
    private int mFitPaddingTop;

    public EhNavigationView(Context context) {
        super(context);
        init();
    }

    public EhNavigationView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public EhNavigationView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        setWillNotDraw(false);
    }

    @SuppressLint("RestrictedApi")
    @Override
    public void draw(@NonNull Canvas canvas) {
        super.draw(canvas);

        if (mFitPaddingTop > 0) {
            if (null == mPaint) {
                mPaint = new Paint();
                mPaint.setColor(SCRIM_COLOR);
            }
            canvas.drawRect(0, 0, getWidth(), mFitPaddingTop, mPaint);
        }
    }

    @Override
    public void setFitPadding(int top, int bottom) {
        mFitPaddingTop = top;
    }

    @Override
    public int getLayoutPaddingTop() {
        return 0;
    }

    @Override
    public int getLayoutPaddingBottom() {
        return 0;
    }
}
