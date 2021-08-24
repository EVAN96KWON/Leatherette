package com.buttup.leatherette

import android.os.Bundle
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.buttup.leatherette.main_fragments.Community
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.imaec.forblog.BottomNavigationHelper
import com.buttup.leatherette.main_fragments.*

class MainActivity : AppCompatActivity() {

    private val myinfo by lazy { Myinfo() }
    private val community by lazy { Community() }
    private val home by lazy { Home() }
    private val matching by lazy { Matching()}
    private val option by lazy { Option()}
    // 추가된 라인
    private lateinit var bnv_main: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val actionBar: ActionBar? = supportActionBar

        if (actionBar != null) actionBar.hide()

        // 추가된 라인. bottomNavigationView -> bnv_main 변수명 변경함.
        bnv_main = findViewById<BottomNavigationView>(R.id.bnv_main)

        BottomNavigationHelper.disableShiftMode(bnv_main)
        changeFragment(home)
        initNavigationBar()
    }

    private fun initNavigationBar(){
        bnv_main.run{
            setOnNavigationItemSelectedListener{
                when(it.itemId){
                    R.id.Myinfo     -> changeFragment(myinfo)
                    R.id.Community  -> changeFragment(community)
                    R.id.Homekey    -> changeFragment(home)
                    R.id.Matching   -> changeFragment(matching)
                    R.id.Option     -> changeFragment(option)
                }
                true
            }
            selectedItemId = R.id.home
        }
    }

    private fun changeFragment(fragment : Fragment){
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fl_container,fragment)
            .commit()
    }
}


