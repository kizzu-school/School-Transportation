package com.crygen.kizzu.fragment

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.crygen.kizzu.ApiClient
import com.crygen.kizzu.ApiInterface
import com.crygen.kizzu.activity.LoginActivity
import com.crygen.kizzu.R
import com.crygen.kizzu.model.ResultResponse
import com.crygen.kizzu.viewmodel.LoginViewModel
import kotlinx.android.synthetic.main.login_fragment.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginFragment : Fragment() {

    companion object {
        fun newInstance() = LoginFragment()
    }

    private lateinit var viewModel: LoginViewModel

    private lateinit var apiInterface: ApiInterface

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        apiInterface = ApiClient.getApiService()
        return inflater.inflate(R.layout.login_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(LoginViewModel::class.java)
        // TODO: Use the ViewModel
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        signUpTv.setOnClickListener {
            if(activity is LoginActivity) {
                (activity as LoginActivity).navigateTo(SignUpFragment::class.java.simpleName)
            }
        }

        loginBtn.setOnClickListener {
            apiInterface.login(Login(emailEt.text.toString(), passwordEt.text.toString())).enqueue(
                    object : Callback<ResultResponse>{
                        override fun onFailure(call: Call<ResultResponse>?, t: Throwable?) {

                        }

                        override fun onResponse(call: Call<ResultResponse>?,
                                                response: Response<ResultResponse>?) {
                            if(response != null && response.isSuccessful){
                                //todo handle login api call success
                            }
                        }

                    }
            )
        }
    }


    data class Login(val email : String, val passwordHash : String)

}
