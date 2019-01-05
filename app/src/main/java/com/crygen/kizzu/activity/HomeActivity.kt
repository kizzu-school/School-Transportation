package com.crygen.kizzu.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.crygen.kizzu.R
import com.crygen.kizzu.fragment.ProfileFragment

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.container, ProfileFragment.newInstance())
                    .commitNow()
        }
    }

    public fun navigateTo(screenName : String) {
        when(screenName){
            ProfileFragment::class.java.simpleName -> {
                supportFragmentManager.beginTransaction()
                        .replace(R.id.container, ProfileFragment.newInstance())
                        .addToBackStack(screenName)
                        .commit()
            }
        }
    }
}
