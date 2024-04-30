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
import kotlin.random.Random

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

        setUpRepasModels()
        println(repasArrayList)

        // Remplacement initial du fragment
        replaceFragment(fragment_accueil())

        navView.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.nav_home -> { replaceFragment(fragment_accueil()) }
                R.id.nav_profile -> { replaceFragment(fragment_profil()) }
                R.id.nav_week -> {
                    // Passer les données du repas au fragment "FragmentWeek"
                    val bundle = Bundle()
                    bundle.putParcelableArrayList("repasList", repasArrayList)
                    replaceFragment(fragment_week(), bundle)
                }
                R.id.nav_meals -> { replaceFragment(fragment_meals()) }
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

    private fun replaceFragment(fragment: Fragment, data: Bundle? = null) {
        // Créer une transaction pour remplacer le fragment
        val transaction: FragmentTransaction = supportFragmentManager.beginTransaction()

        // Passer les données au fragment s'il y en a
        if (data != null) {
            fragment.arguments = data
        }

        // Remplacer le fragment actuel par le nouveau fragment
        transaction.replace(R.id.activity2_fragmentContainerView, fragment)

        // Valider et terminer la transaction
        transaction.commit()
    }

    private fun setUpRepasModels() {
        repasArrayList = ArrayList()
        val repasNames = ArrayList(resources.getStringArray(R.array.repas_name_txt).toList())
        val repasImage = ArrayList(resources.getIntArray(R.array.repas_image_txt).toList())
        var isInList = false
        while (repasArrayList.size < 7) {
            val randomNumber = Random.nextInt(repasNames.size)
            val repas = Repas(repasNames[randomNumber], repasImage[randomNumber])
            if(!repasArrayList.contains(repas)){
                repasArrayList.add(repas)
                println(repas)
            }
        }

    }
}

