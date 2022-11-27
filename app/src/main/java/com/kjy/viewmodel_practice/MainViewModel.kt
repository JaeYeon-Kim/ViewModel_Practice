package com.kjy.viewmodel_practice

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

// 뷰 모델 정의
class MainViewModel: ViewModel() {

    // LiveData로 score 변수 선언
    /*
    안드로이드에서 Observer는 데이터가 변경되는지 감시하고 있다가 UI컨트롤러 (Activity)에게 알려준다.
    알림을 들은 UI 컨트롤러는 그 데이터를 가지고 UI를 업데이트 하는 그런 개념이다.
    단, 여기서 Observer는 아무 데이터나 감시할 수 있는게 아니라 LiveData라는 데이터 홀더 클래스가 가지고 있는
    데이터만 감시가 가능 하다.
     */
    var score = MutableLiveData<Int>()

    // 객체 생성시 실행됨.
    init {
        Log.d("MainViewModel", "MainViewModel 생성")
        score.value = 0         // init(초기화 부분에) 스코어 값 설정 => 옵저버가 감시할 수 있는 데이터가 됨.
    }

    override fun onCleared() {
        super.onCleared()
        Log.d("MainViewModel", "MainViewModel 종료")
    }

    // 스코어 더하기
    fun scorePlus() {
        score.value = score.value?.plus(1)
    }

    // 스코어 빼기
    fun scoreMinus() {
        score.value = score.value?.minus(1)
    }
}