package me.cassiano.savethepokemons.base;

import android.databinding.BindingAdapter;
import android.support.annotation.DrawableRes;
import android.view.View;
import android.widget.ImageView;

import com.github.florent37.viewanimator.ViewAnimator;
import com.squareup.picasso.Picasso;


public class DataBinder {

    @BindingAdapter("fadeVisible")
    public static void setFadeVisible(final View view, boolean visible) {

        if (view.getTag() == null) {
            view.setTag(true);
            view.setVisibility(visible ? View.VISIBLE : View.GONE);
        } else {
            view.animate().cancel();

            if (visible) {
                view.setVisibility(View.VISIBLE);

                ViewAnimator
                        .animate(view)
                        .fadeIn()
                        .duration(300)
                        .start();

            } else {

                view.setVisibility(View.GONE);

                ViewAnimator
                        .animate(view)
                        .fadeOut()
                        .duration(300)
                        .start();
            }
        }
    }

    @BindingAdapter("imageRes")
    public static void setImageRes(ImageView imageView, @DrawableRes int res) {

        Picasso.with(imageView.getContext())
                .load(res)
                .into(imageView);

    }
}