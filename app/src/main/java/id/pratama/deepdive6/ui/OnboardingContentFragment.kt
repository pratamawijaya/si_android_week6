package id.pratama.deepdive6.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import id.pratama.deepdive6.R

private const val ARG_TITLE = "title"
private const val ARG_DESC = "desc"
private const val ARG_ILLUSTRATION = "illustration"

/**
 * A simple [Fragment] subclass.
 * Use the [OnboardingContentFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class OnboardingContentFragment : Fragment() {
    // variable untuk menampung data yang dikirim dari activity
    private var title: String? = null
    private var desc: String? = null
    private var illustration: Int? = null

    lateinit var tvTitle: TextView
    lateinit var tvDesc: TextView
    lateinit var imgIllustration: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            title = it.getString("key_title")
            desc = it.getString("key_desc")
            illustration = it.getInt("key_illustration")
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d("debug", "fragment onCreateView")
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_onboarding_content, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // inisiasi view dilakukan disini
        tvTitle = view.findViewById(R.id.tvTitle)
        tvDesc = view.findViewById(R.id.tvDesc)
        imgIllustration = view.findViewById(R.id.imgIllustration)

        tvTitle.text = title
        tvDesc.text = desc
        illustration?.let {
            imgIllustration.setImageResource(it)
        }
    }

    companion object {
        @JvmStatic
        fun newInstance(title: String, desc: String, illustration: Int) =
            OnboardingContentFragment().apply {
                arguments = Bundle().apply {
                    putString("key_title", title)
                    putString("key_desc", desc)
                    putInt("key_illustration", illustration)
                }
            }
    }
}

