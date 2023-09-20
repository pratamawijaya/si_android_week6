package id.pratama.deepdive6.ui.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import id.pratama.deepdive6.ui.OnboardingContentFragment
import id.pratama.deepdive6.ui.OnboardingData

// viewpager adapter

// data untuk viewpager dipassing melalui constructor onboardingAdapter
class OnboardingAdapter(fragment: FragmentActivity, private val listData: List<OnboardingData>) :
    FragmentStateAdapter(fragment) {


    // menentukan berapa banyak halaman viewpager yang akan ditampilkan
    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        return OnboardingContentFragment.newInstance(
            title = listData[position].title,
            desc = listData[position].desc,
            illustration = listData[position].illustration
        )
    }
}