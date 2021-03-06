package com.crygen.kizzu.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.crygen.kizzu.R
import com.crygen.kizzu.fragment.LoginFragment
import com.crygen.kizzu.fragment.SignUpFragment

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.container, LoginFragment.newInstance())
                    .commitNow()
        }
    }

    public fun navigateTo(screenName : String) {
        when(screenName){
            SignUpFragment::class.java.simpleName -> {
                supportFragmentManager.beginTransaction()
                        .replace(R.id.container, SignUpFragment.newInstance())
                        .addToBackStack(screenName)
                        .commit()
            }
        }
    }

}
