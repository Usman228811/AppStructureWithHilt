package com.example.myfirstapp.ui.activities

import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myfirstapp.data.room.Word
import com.example.myfirstapp.data.room.WordViewModel
import com.example.myfirstapp.ui.adapters.DeleteListener
import com.example.myfirstapp.ui.adapters.TestAdapter
import com.example.myfirstapp.ui.base.BaseActivity
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class RoomDbTestActivity : BaseActivity() {

    private val wordViewModel: WordViewModel by viewModels()

    @Inject
    lateinit var testAdapter: TestAdapter


    @Inject
    lateinit var binding: com.example.myfirstapp.databinding.ActivityRoomDbTestBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

//        wordViewModel = ViewModelProvider(this)[WordViewModel::class.java]

        with(binding) {

            btnInsert.setOnClickListener {
                val word = Word()
                word.word = etWord.text.toString().trim()

                wordViewModel.insert(
                    word
                )
                etWord.setText("")

            }

            recView.layoutManager = LinearLayoutManager(mContext)
            recView.adapter = testAdapter
            testAdapter.initDeleteListener(object :DeleteListener{
                override fun onDelete(id: Int) {
                    wordViewModel.deleteById(id)
                }

            })

            wordViewModel.allWords.observe(this@RoomDbTestActivity) {
                testAdapter.initAdapter(it as ArrayList<Word>)
            }
        }
    }
}