package univ.tours.webuy.views.stats;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.webuy.R;

public class LiveStatView extends ConstraintLayout {

    public LiveStatView(Context context) {
        super(context);
        init(context);
    }

    public LiveStatView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public LiveStatView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void init(Context context) {
        View.inflate(context, R.layout.frg_stats, this);
        //traitement
    }
}
