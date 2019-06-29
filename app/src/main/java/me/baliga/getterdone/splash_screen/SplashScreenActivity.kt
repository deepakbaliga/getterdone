package me.baliga.getterdone.splash_screen


import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import me.baliga.getterdone.R
import me.baliga.getterdone.databinding.ActivitySplashScreenBinding

class SplashScreenActivity : AppCompatActivity() {

    var animationForTopLayer: Animation? = null
    var animationForMiddleLayer: Animation? = null
    var animationForBottomLayer: Animation? = null

    var animationForGetterText: Animation? = null
    var animationForDoneText: Animation? = null


    private lateinit var binding: ActivitySplashScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Set activity to a fullscreen activity
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN

        //Bind layout to activity
        binding = DataBindingUtil.setContentView(this, R.layout.activity_splash_screen)

        //Load all animations with delays
        loadAnimations()

        //Animated Views
        startAnimations()


    }

    private fun loadAnimations() {
        animationForTopLayer = AnimationUtils.loadAnimation(this, R.anim.slide_from_right)
        animationForMiddleLayer = AnimationUtils.loadAnimation(this, R.anim.slide_from_right)
            .apply { startOffset = 300 }
        animationForBottomLayer = AnimationUtils.loadAnimation(this, R.anim.slide_from_right)
            .apply { startOffset = 600 }

        animationForGetterText = AnimationUtils.loadAnimation(this, R.anim.slide_splashscreen_text_from_left)
            .apply { startOffset = 900 }
        animationForDoneText = AnimationUtils.loadAnimation(this, R.anim.slide_splashscreen_text_from_right)
            .apply { startOffset = 900 }
    }

    private fun startAnimations() {
        binding.logoTopLayer.startAnimation(animationForTopLayer)
        binding.logoMiddleLayer.startAnimation(animationForMiddleLayer)
        binding.logoBottomLayer.startAnimation(animationForBottomLayer)
        binding.textGetter.startAnimation(animationForGetterText)
        binding.textDone.startAnimation(animationForDoneText)
    }


}
