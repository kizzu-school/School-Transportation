package com.crygen.kizzu.fragment

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
import com.crygen.kizzu.viewmodel.SignUpViewModel
import kotlinx.android.synthetic.main.sign_up_fragment.*


class SignUpFragment : Fragment() {

    companion object {
        fun newInstance() = SignUpFragment()
    }

    private lateinit var viewModel: SignUpViewModel

    private lateinit var apiInterface: ApiInterface

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        apiInterface = ApiClient.getApiService()
        return inflater.inflate(R.layout.sign_up_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(SignUpViewModel::class.java)
        // TODO: Use the ViewModel
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        signUpBtn.setOnClickListener {
            apiInterface.signUp(extractModel())
        }
    }

    private fun extractModel() : UserData {
        val userData = UserData()
        userData.firstName = firstNameEt.text.toString()
        userData.lastName = lastNameEt.text.toString()
        userData.email = emailEt.text.toString()
        userData.phone = phoneEt.text.toString()
        userData.birthday = birthdayEt.text.toString()
        return  userData
    }

}
