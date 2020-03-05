package com.urtisi.baget

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.urtisi.baget.dashboard.DashboardFragment
import com.urtisi.baget.databinding.ActivityMainBinding
import com.urtisi.baget.files.FilesFragment
import com.urtisi.baget.profile.ProfileFragment
import com.urtisi.baget.umk.UmkFragment


class MainActivity : AppCompatActivity() {

    private val newsFragment = MainNewsFragment()
    private val dashboardFragment = DashboardFragment()
    private val filesFragment = FilesFragment()
    private val umkFragment = UmkFragment()
    private val profileFragment = ProfileFragment()
    private lateinit var binding: ActivityMainBinding
    private val fm = supportFragmentManager
    private var activeFragment: Fragment = newsFragment
    private var lastNavigationItem: Int = R.id.navigation_news_main

    /**
     * activity after logging in, contains all bottom menu screens fragments
     * (handling bottom navigation clicks and top right corner "profile" button)
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        supportActionBar!!.title = "News"

        fm.beginTransaction().add(R.id.nav_host_fragment, profileFragment, "profile").hide(profileFragment).commit()
        fm.beginTransaction().add(R.id.nav_host_fragment, umkFragment, "4").hide(umkFragment).commit()
        fm.beginTransaction().add(R.id.nav_host_fragment, filesFragment, "3").hide(filesFragment).commit()
        fm.beginTransaction().add(R.id.nav_host_fragment, dashboardFragment, "2").hide(dashboardFragment).commit()
        fm.beginTransaction().add(R.id.nav_host_fragment, newsFragment, "1").commit()

    }

    private val mOnNavigationItemSelectedListener =
        object : BottomNavigationView.OnNavigationItemSelectedListener {
            override fun onNavigationItemSelected(item: MenuItem): Boolean {

                if (item.itemId == lastNavigationItem) return true
                //TODO: add backstack class/handling
                when (item.itemId){

                    R.id.navigation_news_main ->{
                        fm.beginTransaction().hide(activeFragment).show(newsFragment).commit()
                        activeFragment = newsFragment
                        lastNavigationItem = R.id.navigation_news_main
                        supportActionBar!!.title = "News"
                        return true
                    }

                    R.id.navigation_dashboard ->{
                        fm.beginTransaction().hide(activeFragment).show(dashboardFragment).commit()
                        activeFragment = dashboardFragment
                        lastNavigationItem = R.id.navigation_dashboard
                        supportActionBar!!.title = "Dashboard"
                        return true
                    }

                    R.id.navigation_files -> {
                        fm.beginTransaction().hide(activeFragment).show(filesFragment).commit()
                        activeFragment = filesFragment
                        lastNavigationItem = R.id.navigation_files
                        supportActionBar!!.title = "Files"
                        return true
                    }

                    R.id.navigation_umk -> {
                        fm.beginTransaction().hide(activeFragment).show(umkFragment).commit()
                        activeFragment = umkFragment
                        lastNavigationItem = R.id.navigation_umk
                        supportActionBar!!.title = "Umk"
                        return true
                    }
                }

                return false
            }
        }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.menu, menu)

        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {

        if (item!!.itemId == R.id.action_bar_profile){

            if (item.itemId == lastNavigationItem) return true

            fm.beginTransaction().hide(activeFragment).show(profileFragment).commit()
            activeFragment = profileFragment
            lastNavigationItem = R.id.action_bar_profile
            supportActionBar!!.title = "Profile"
            return true
        }

        return super.onOptionsItemSelected(item)
    }

}
