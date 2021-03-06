package com.gitonway.fineday.widget.magicviews.preference;

import android.content.Context;
import android.preference.Preference;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

import com.gitonway.fineday.widget.magicviews.enums.PreferenceType;
import com.gitonway.fineday.widget.magicviews.utils.FontUtils;

/**
 * Created by ivankocijan on 22.05.2014..
 */
public class MagicPreference extends Preference {

    private Context context;
    private String fontStyle;

    public MagicPreference (Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context, attrs);
    }

    public MagicPreference (Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public MagicPreference (Context context) {
        super(context);
    }

    private void init (Context ctx, AttributeSet attrs) {

        this.context = ctx;
        fontStyle = FontUtils.getPrefFontStyle(ctx, attrs, PreferenceType.SIMPLE_PREFERENCE);

    }

    @Override
    protected void onBindView (View view) {
        super.onBindView(view);

        TextView titleView = (TextView) view.findViewById(android.R.id.title);
        TextView summary = (TextView) view.findViewById(android.R.id.summary);

        if (titleView != null && summary != null && context != null) {
            FontUtils.setPreferenceTypeface(context, fontStyle, titleView, summary);
        }

    }
}
