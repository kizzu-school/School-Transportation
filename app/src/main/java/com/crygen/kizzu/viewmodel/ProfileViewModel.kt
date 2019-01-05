package com.crygen.kizzu.viewmodel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.crygen.kizzu.model.UserData

class ProfileViewModel : ViewModel() {
    val userInfoLiveData : MutableLiveData<UserData> = MutableLiveData<UserData>()

}