package com.example.helloworld.presenter.view

import android.annotation.SuppressLint
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.helloworld.databinding.FragmentCalendarBinding
import com.example.helloworld.presenter.viewmodel.MainViewModel
import java.util.concurrent.Executors

class Calendar : Fragment() {

    private lateinit var mBinding: FragmentCalendarBinding
    private val binding get() = mBinding
    private val viewModel: MainViewModel by activityViewModels()

    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mBinding = FragmentCalendarBinding.inflate(layoutInflater)

        viewModel.person.observe(viewLifecycleOwner){
            if(it!=null){
                mBinding.tvBirthday.text = it.dob.date
                //Load Image
                var image: Bitmap?
                val executor = Executors.newSingleThreadExecutor()
                val handler = Handler(Looper.getMainLooper())

                executor.execute{

                    val stream = java.net.URL(it.picture.large).openStream()

                    image = BitmapFactory.decodeStream(stream)

                    handler.post{
                        mBinding.cardView.ivUserImage.setImageBitmap(image)
                    }
                }
            }
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mBinding.btnLoadNewUser.btnLoadNewUser.setOnClickListener {
            viewModel.getData()
        }
    }
}