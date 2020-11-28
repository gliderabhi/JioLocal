package com.example.jiolocal.fragment
import android.graphics.Typeface
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager.widget.ViewPager
import com.example.jiolocal.R
import com.example.jiolocal.adapters.ViewPagerAdapterImages
import com.example.jiolocal.databinding.ServiceDetailsPageFragmentBinding
import com.example.jiolocal.fragment.viewModels.ServiceDetailsPageViewModel
import java.time.DayOfWeek
import java.time.LocalDateTime

class ServiceDetailsPage : Fragment() {

    companion object {
        fun newInstance() = ServiceDetailsPage()
    }

    private lateinit var viewModel: ServiceDetailsPageViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding : ServiceDetailsPageFragmentBinding =
            DataBindingUtil.inflate(
                inflater,
                R.layout.service_details_page_fragment,
                container,
                false
            )
        return binding.root
    }


    @RequiresApi(Build.VERSION_CODES.O)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory()).get(
            ServiceDetailsPageViewModel::class.java
        )
        val smallSummary = view.findViewById<ConstraintLayout>(R.id.smallSummaryLay)
        val largeSummary = view.findViewById<ConstraintLayout>(R.id.largeSummaryLay)
        val showLargeSummary = view.findViewById<ImageView>(R.id.showLargeSummary)
        showLargeSummary.setOnClickListener {
            largeSummary.visibility = View.VISIBLE
            smallSummary.visibility = View.GONE
        }

        val dayText : TextView
        val datStatusText : TextView
        val localtDateTime = LocalDateTime.now().dayOfWeek
        //Toast.makeText(context, "$localtDateTime", Toast.LENGTH_SHORT).show()
        when(localtDateTime) {
            DayOfWeek.MONDAY -> {
                dayText = view.findViewById(R.id.mondayText)
                datStatusText = view.findViewById(R.id.mondayOpenStatus)
                dayText.setTypeface(null ,Typeface.BOLD)
                datStatusText.setTypeface(null, Typeface.BOLD)
            }

            DayOfWeek.TUESDAY -> {
                dayText = view.findViewById(R.id.TuesdayText)
                datStatusText = view.findViewById(R.id.tuesdayOpenStatus)
                dayText.setTypeface(null ,Typeface.BOLD)
                datStatusText.setTypeface(null, Typeface.BOLD)
            }

            DayOfWeek.WEDNESDAY -> {
                dayText = view.findViewById(R.id.WednesdayText)
                datStatusText = view.findViewById(R.id.wednesdayOpenStatus)
                dayText.setTypeface(null ,Typeface.BOLD)
                datStatusText.setTypeface(null, Typeface.BOLD)
            }

            DayOfWeek.THURSDAY -> {
                dayText = view.findViewById(R.id.ThursdayText)
                datStatusText = view.findViewById(R.id.thursdayOpenStatus)
                dayText.setTypeface(null ,Typeface.BOLD)
                datStatusText.setTypeface(null, Typeface.BOLD)
            }
            DayOfWeek.FRIDAY -> {
                dayText = view.findViewById(R.id.FridayText)
                datStatusText = view.findViewById(R.id.fridayOpenStatus)
                dayText.setTypeface(null ,Typeface.BOLD)
                datStatusText.setTypeface(null, Typeface.BOLD)
            }

            DayOfWeek.SATURDAY -> {
                dayText = view.findViewById(R.id.SaturdayText)
                datStatusText = view.findViewById(R.id.saturdayOpenStatus)
                dayText.setTypeface(null ,Typeface.BOLD)
                datStatusText.setTypeface(null, Typeface.BOLD)
            }
            DayOfWeek.SUNDAY -> {
                dayText = view.findViewById(R.id.SundayText)
                datStatusText = view.findViewById(R.id.SundayOpenStatus)
                dayText.setTypeface(null ,Typeface.BOLD)
                datStatusText.setTypeface(null, Typeface.BOLD)
            }
        }

        val pager = view.findViewById<ViewPager>(R.id.serviceImages)
        pager.adapter = ViewPagerAdapterImages(context!!, viewModel.getImageLists())

        val showSmallSummary = view.findViewById<ImageView>(R.id.showSmallSummary)
        showSmallSummary.setOnClickListener {
            largeSummary.visibility = View.GONE
            smallSummary.visibility = View.VISIBLE
        }

    }


}