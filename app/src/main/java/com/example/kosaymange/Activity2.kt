package com.example.kosaymange

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.navigation.NavigationView

class Activity2 : AppCompatActivity() {

    // Déclaration des propriétés
    lateinit var toggle: ActionBarDrawerToggle
    lateinit var drawerLayout: DrawerLayout
    private lateinit var newRecyclerView: RecyclerView
    private lateinit var repasArrayList: ArrayList<Repas>
    private lateinit var repasImage: ArrayList<Int>
    private lateinit var repasNames: ArrayList<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_2)

        drawerLayout = findViewById(R.id.drawerLayout)
        val navView: NavigationView = findViewById(R.id.nav_view)

        toggle = ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        // Remplacement initial du fragment
        replaceFragment(fragment_accueil())

        navView.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.nav_home -> { replaceFragment(fragment_accueil()) }
                R.id.nav_profile -> { replaceFragment(fragment_profil()) }
                R.id.nav_week -> { replaceFragment(fragment_week()) }
                R.id.nav_meals -> {
                    val frag = fragment_meals()
                    replaceFragment(frag)
                }
                R.id.nav_ingredients -> { replaceFragment(fragment_ingredients()) }
                R.id.nav_settings -> { replaceFragment(fragment_settings()) }
            }
            drawerLayout.close()
            true
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item)) {
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    private fun replaceFragment(fragment: Fragment) {
        val transaction: FragmentTransaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.activity2_fragmentContainerView, fragment)
        transaction.commit()
    }
}