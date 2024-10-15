package dam.pmdm.viewpager

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import dam.pmdm.viewpager.databinding.FirstBinding

class FirstFragment : Fragment() {
    private lateinit var binding : FirstBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Establecer el título de la Toolbar a vacío
//        (activity as AppCompatActivity).supportActionBar?.title = ""

        binding = FirstBinding.inflate(inflater, container, false)
        return binding.root
    }
}