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
import com.urtisi.baget.umk.UmkFragment


class MainActivity : AppCompatActivity() {

    private val newsFragment = MainNewsFragment()
    private val dashboardFragment = DashboardFragment()
    private val filesFragment = FilesFragment()
    private val umkFragment = UmkFragment()
    private lateinit var binding: ActivityMainBinding
    private val fm = supportFragmentManager
    private var active: Fragment = newsFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        supportActionBar!!.title = "News"

        fm.beginTransaction().add(R.id.nav_host_fragment, umkFragment, "4").hide(umkFragment).commit()
        fm.beginTransaction().add(R.id.nav_host_fragment, filesFragment, "3").hide(filesFragment).commit()
        fm.beginTransaction().add(R.id.nav_host_fragment, dashboardFragment, "2").hide(dashboardFragment).commit()
        fm.beginTransaction().add(R.id.nav_host_fragment, newsFragment, "1").commit()
    }

    private val mOnNavigationItemSelectedListener =
        object : BottomNavigationView.OnNavigationItemSelectedListener {
            override fun onNavigationItemSelected(item: MenuItem): Boolean {
                when (item.itemId){
                    R.id.navigation_news_main ->{
                        fm.beginTransaction().hide(active).show(newsFragment).commit()
                        active = newsFragment
                        supportActionBar!!.title = "News"
                        return true
                    }

                    R.id.navigation_dashboard ->{
                        fm.beginTransaction().hide(active).show(dashboardFragment).commit()
                        active = dashboardFragment
                        supportActionBar!!.title = "Dashboard"
                        return true
                    }

                    R.id.navigation_files -> {
                        fm.beginTransaction().hide(active).show(filesFragment).commit()
                        active = filesFragment
                        supportActionBar!!.title = "Files"
                        return true
                    }

                    R.id.navigation_umk -> {
                        fm.beginTransaction().hide(active).show(umkFragment).commit()
                        active = umkFragment
                        supportActionBar!!.title = "Umk"
                        return true
                    }
                }

                return false
            }
        }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.bottom_nav_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

}
