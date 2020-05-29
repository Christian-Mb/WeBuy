package univ.tours.webuy.core.utils;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.webuy.R;

public class Toasts {

    public static void show(final Context context, final int message) {
        show(context, context.getString(message), Toast.LENGTH_SHORT);
    }

    public static void show(final Context context, final String message) {
        show(context, message, Toast.LENGTH_SHORT);
    }

    public static void show(final Context context, final String message, final int duration) {
        if (context != null) {
            new Handler(Looper.getMainLooper()).post(new Runnable() {
                @Override
                public void run() {
                    if (context != null) {
                        Toast.makeText(context, message, duration).show();
                    }
                }
            });
        }
    }

    public static void warnInternet(Context context) {
        warn(context, R.string.internt_is_not_available);
    }

    public static void ok(Context context, int message) {
        showMessageWithIcon(context, message, R.drawable.ic_done);
    }

    public static void warn(Context context, int message) {
        showMessageWithIcon(context, message, R.drawable.ic_warning);
    }

    public static void error(Context context, int message) {
        showMessageWithIcon(context, message, R.drawable.ic_error);
    }

    public static void showThanks(Context context) {
        showMessageWithIcon(context, R.string.common_thanks, R.drawable.ic_toasts_thanks);
    }

    public static void showMessageWithIcon(final Context context, final int message, final int icon) {
        try {
            if (context != null) {
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    @Override
                    public void run() {

                        if (context != null) {
                            View layout = LayoutInflater.from(context).inflate(R.layout.toa_with_icon, null);

                            // Add image
                            ImageView imgIcon = layout.findViewById(R.id.imgIcon);
                            imgIcon.setImageResource(icon);

                            // Add textView
                            TextView txtMessage = layout.findViewById(R.id.txtMessage);
                            txtMessage.setText(message);

                            Toast toast = new Toast(context);
                            toast.setGravity(Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 20);
                            toast.setDuration(Toast.LENGTH_SHORT);
                            toast.setView(layout);
                            toast.show();
                        }
                    }
                });
            }
        } catch (Exception e) {

        }
    }

}