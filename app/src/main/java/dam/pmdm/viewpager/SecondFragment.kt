package dam.pmdm.viewpager

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import dam.pmdm.viewpager.databinding.FirstBinding
import dam.pmdm.viewpager.databinding.SecondBinding

class SecondFragment : Fragment() {
    private lateinit var binding : SecondBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = SecondBinding.inflate(inflater, container, false)
        return binding.root
    }
}