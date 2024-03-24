package com.example.helloworld.presenter.view

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.helloworld.R
import com.example.helloworld.databinding.ActivityMainBinding
import com.example.helloworld.presenter.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        replaceFragment(Profile())

        viewModel.getData()

        mBinding.bottomnavigation.setOnItemSelectedListener {
            when(it.itemId){
                R.id.profile -> replaceFragment(Profile())
                R.id.email -> replaceFragment(Email())
                R.id.calendar -> replaceFragment(Calendar())
                else ->{}
            }
            true
        }
    }

    private fun replaceFragment(fragment: Fragment){
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout, fragment)
        fragmentTransaction.commit()
    }

}