package com.kjy.viewmodel_practice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.kjy.viewmodel_practice.databinding.ActivityMainBinding


/*
- 기존에 있던 score 변수 삭제, MainViewModel에서 score값 가져옴.
- scorePlus 함수에 MainViewModel에 있는 scorePlus 함수 가져옴.
- scoreMinus 함수에 MainViewModel에 있는 scoreMinus 함수 가져옴.
 */
class MainActivity : AppCompatActivity() {

    // 데이터 바인딩 변수
    private lateinit var binding: ActivityMainBinding

    // 뷰 모델 변수
    private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // binding 초기화
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        // 뷰 모델 초기화
        mainViewModel = ViewModelProvider(this)[MainViewModel::class.java]

        // 생명주기 셋팅, 생명주기 소유자 지정을 해야 LiveData가 작동
        binding.lifecycleOwner = this

        // 변수에 viewModel 초기화
        binding.myVar = mainViewModel

        /*
        레이아웃에 직접 LiveData를 적용했기 때문에 버튼 이벤트를 필요가 없음.
         */

//        // score 변수의 변화를 감지
//        mainViewModel.score.observe(this, Observer {
//            binding.scoreText.text = mainViewModel.score.value.toString()
//        })
//
//
//        binding.plusBtn.setOnClickListener {
//            mainViewModel.scorePlus()
//
//        }
//
//        binding.minusBtn.setOnClickListener {
//            mainViewModel.scoreMinus()
//        }
    }
}