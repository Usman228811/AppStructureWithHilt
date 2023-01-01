package com.example.myfirstapp.ui.activities

import android.os.Bundle
import androidx.activity.viewModels
import com.example.myfirstapp.data.api.viewmodel.PostViewModel
import com.example.myfirstapp.databinding.ActivityRetrofitTestBinding
import com.example.myfirstapp.ui.adapters.RetrofitTestAdapter
import com.example.myfirstapp.ui.base.BaseActivity
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class RetrofitTestActivity : BaseActivity() {

    private val postViewModel: PostViewModel by viewModels()

    @Inject
    lateinit var retrofitTestAdapter: RetrofitTestAdapter


    @Inject
    lateinit var binding: ActivityRetrofitTestBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        with(binding) {


            recView.adapter = retrofitTestAdapter
            postViewModel.postsList.observe(this@RetrofitTestActivity) {

                retrofitTestAdapter.initAdapter(
                    it
                )
            }

        }
    }
}