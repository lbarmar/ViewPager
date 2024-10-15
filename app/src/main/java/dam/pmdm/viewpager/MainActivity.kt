package dam.pmdm.viewpager

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.PopupMenu
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.tabs.TabLayoutMediator
import dam.pmdm.viewpager.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private lateinit var viewPagerAdapter: TabPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        viewPagerAdapter = TabPagerAdapter(this)
        binding.viewPager.adapter = viewPagerAdapter

//        Crear un adaptador para el ViewPager
        configureTabPager();

//        Configurar un menu contextual en un botón flotante
        configureFloatingMenu();

    }

    private fun configureFloatingMenu() {
        val fabMenu = findViewById<FloatingActionButton>(R.id.fab_menu)
        fabMenu.setOnClickListener { view ->
            showPopupMenu(view)
        }
    }

    private fun configureTabPager() {
        val adapter = TabPagerAdapter(this)
        binding.viewPager.adapter = adapter

        // Configurar el TabLayout con el ViewPager
        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            tab.text = when (position) {
                0 -> getString(R.string.first_fragment)
                1 -> getString(R.string.second_fragment)
                else -> null
            }
        }.attach()
    }

    private fun showPopupMenu(view: View) {
        // Crea el objeto PopupMenu
        val popupMenu = PopupMenu(this, view)

        // Infla el menú desde el archivo XML
        popupMenu.menuInflater.inflate(R.menu.menu, popupMenu.menu)

        // Manejar los clics en los elementos del menú
        popupMenu.setOnMenuItemClickListener { menuItem: MenuItem ->
            when (menuItem.itemId) {
                R.id.about_us -> {
                    // Acción para Opción 1
                    AlertDialog.Builder(this)
                        .setTitle("Acerca de")
                        .setMessage("v.1.0.0")
                        .setPositiveButton("OK", null)
                        .show()
                    true
                }
                else -> false
            }
        }
        // Mostrar el menú
        popupMenu.show()
    }


}