package com.ub.curvedbottomnavigationview.bottomNav

import android.graphics.Color
import android.os.Bundle
import androidx.activity.SystemBarStyle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.ub.bottomnavigationview.CurvedModel
import com.ub.curvedbottomnavigationview.R
import com.ub.curvedbottomnavigationview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var mainBinding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge(
            statusBarStyle = SystemBarStyle.light(Color.TRANSPARENT, Color.TRANSPARENT),
            navigationBarStyle = SystemBarStyle.light(Color.BLACK, Color.BLACK)
        )

        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }



        val menuItems = arrayOf(
            CurvedModel(
                R.drawable.ic_home,
                R.drawable.avd_home,
                -1,
                getString(R.string.home)
            ),
            CurvedModel(
                R.drawable.ic_notification,
                R.drawable.avd_notification,
                -1,
                getString(R.string.notifications)
            ),
            CurvedModel(
                R.drawable.ic_settings,
                R.drawable.avd_settings,
                -1,
                getString(R.string.settings_)
            ),
            CurvedModel(
                R.drawable.ic_profile,
                R.drawable.avd_profile,
                -1,
                getString(R.string.profile)
            ),
            CurvedModel(
                R.drawable.ic_dashboard,
                R.drawable.avd_dashboard,
                -1,
                getString(R.string.share)
            )
        )

        mainBinding.navView.setMenuItems(menuItems, 2)
        mainBinding.navView.setOnMenuItemClickListener { cbnMenuItem, index ->
            when(index){
                0 -> mainBinding.textView.text = getString(R.string.home)
                1 -> mainBinding.textView.text = getString(R.string.notifications)
                2 -> mainBinding.textView.text = getString(R.string.settings_)
                3 -> mainBinding.textView.text = getString(R.string.profile)
                4 -> mainBinding.textView.text = getString(R.string.share)
            }

        }


    }
}