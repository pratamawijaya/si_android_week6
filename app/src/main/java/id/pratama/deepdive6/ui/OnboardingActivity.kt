package id.pratama.deepdive6.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.zhpan.indicator.IndicatorView
import com.zhpan.indicator.enums.IndicatorSlideMode
import com.zhpan.indicator.enums.IndicatorStyle
import id.pratama.deepdive6.R
import id.pratama.deepdive6.ui.adapter.OnboardingAdapter

class OnboardingActivity : AppCompatActivity() {

    lateinit var viewPager: ViewPager2
    lateinit var adapter: OnboardingAdapter
    lateinit var indicator: IndicatorView

    private var listDataOnboarding =
        listOf(
            OnboardingData(
                title = "All your favorites",
                desc = "Order from the best local restaurants with easy, on-demand delivery.",
                illustration = R.drawable.illustrations_satu
            ),
            OnboardingData(
                title = "Free delivery offers",
                desc = "Free delivery for new customers via Apple Pay and others payment methods.",
                illustration = R.drawable.illustrations_satu
            ),
            OnboardingData(
                title = "Choose your food",
                desc = "Easily find your type of food craving and you’ll get delivery in wide range.",
                illustration = R.drawable.illustrations_satu
            )
        )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onboarding)

        viewPager = findViewById(R.id.viewpagerOnboarding)
        indicator = findViewById(R.id.indicator_view)

        adapter = OnboardingAdapter(this, listDataOnboarding)
        viewPager.adapter = adapter

        indicator.apply {
            setSliderWidth(resources.getDimension(R.dimen.dimen_10))
            setSliderHeight(resources.getDimension(R.dimen.dimen_5))
            setSlideMode(IndicatorSlideMode.WORM)
            setIndicatorStyle(IndicatorStyle.CIRCLE)
            setupWithViewPager(viewPager)
        }
    }
}

data class OnboardingData(
    val title: String,
    val desc: String,
    val illustration: Int
)


// step untuk mebuat viewpager

//1. buat fragment untuk menampilkan content onboardingnya
// 2. buat adapter
// 3. set data ke adapter
// 4. set adapter ke viewpagernya


