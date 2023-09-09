package redouane.elaouni.iibdcc.listscontactsiibdcc;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {

    private static final int SPLASH_TIMOUT = 5000;
    private static final String WELCOME_MESSAGE= "ENSET CONTACTS APP";
    Animation animation;

    TextView welcomeMessage;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_splash);
        welcomeMessage= findViewById(R.id.splashMessage);
        welcomeMessage.setText(WELCOME_MESSAGE);


        new Handler().postDelayed( () -> {
            Intent intent = new Intent(SplashActivity.this, MainActivity.class);

            startActivity(intent);

        } ,SPLASH_TIMOUT);

        animation= AnimationUtils.loadAnimation(this, R.anim.splash_animation);
        welcomeMessage.setAnimation(animation);
    }
}
