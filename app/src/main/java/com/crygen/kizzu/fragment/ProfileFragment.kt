package com.crygen.kizzu.fragment


import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.crygen.kizzu.ApiClient
import com.crygen.kizzu.ApiInterface

import com.crygen.kizzu.R
import com.crygen.kizzu.model.UserData
import com.crygen.kizzu.viewmodel.ProfileViewModel
import com.crygen.kizzu.viewmodel.SignUpViewModel
import kotlinx.android.synthetic.main.fragment_profile.*

class ProfileFragment : Fragment() {
    companion object {
        fun newInstance() = SignUpFragment()
    }

    private lateinit var apiInterface: ApiInterface

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        apiInterface = ApiClient.getApiService()
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        updateBtn.setOnClickListener{
            apiInterface.update(extractModel())
        }


    }

    private lateinit var viewModel: ProfileViewModel

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(ProfileViewModel::class.java)
        viewModel.userInfoLiveData.observe(this, Observer<UserData> { t ->
            if(t != null){
                populateView(t)
            }
        })
    }

    private fun populateView(userData: UserData) {
        firstNameEt.setText(userData.firstName)
        lastNameEt.setText(userData.lastName)
        emailEt.setText(userData.email)
        phoneEt.setText(userData.phone)
        birthdayEt.setText(userData.birthday)
    }

    private fun extractModel() : UserData {
        var userData = UserData()
        userData.firstName = firstNameEt.text.toString()
        userData.lastName = lastNameEt.text.toString()
        userData.email = emailEt.text.toString()
        userData.phone = phoneEt.text.toString()
        userData.birthday = birthdayEt.text.toString()
        return  userData
    }


}
