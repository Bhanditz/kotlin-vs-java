package com.basecamp.kotlin.activities;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.basecamp.kotlin.R;
import com.basecamp.kotlin.extensions.ViewExtensionKt;
import com.basecamp.kotlin.helpers.AndroidHelperKt;

public class MainActivityJava extends AppCompatActivity {
    Button button;
    View overlay;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.button);
        overlay = findViewById(R.id.overlay);

        ViewExtensionKt.backgroundCircle(button, R.color.colorAccent);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                ViewExtensionKt.alphaAnimator(button, 0f, 1f, 500, 0).start();
            }
        }, 2000);

        if (AndroidHelperKt.atleastLollipop()) {
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    reveal();
                }
            });
        }
    }

    void reveal() {
        Animator anim = ViewExtensionKt.circularRevealAnimator(overlay, centerX(), centerY(), 300, 0);
        anim.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        hide();
                    }
                });
            }
        });
        anim.start();
    }

    void hide() {
        Animator anim = ViewExtensionKt.circularHideAnimator(overlay, centerX(), centerY(), 300, 0);
        anim.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        reveal();
                    }
                });
            }
        });
        anim.start();
    }

    int centerX() {
        return overlay.getWidth() / 2;
    }

    int centerY() {
        return overlay.getHeight() / 2;
    }
}
