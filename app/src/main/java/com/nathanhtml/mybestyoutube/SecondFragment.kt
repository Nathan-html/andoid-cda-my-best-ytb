package com.nathanhtml.mybestyoutube

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.nathanhtml.mybestyoutube.dao.VideoDAO
import com.nathanhtml.mybestyoutube.databinding.FragmentSecondBinding
import com.nathanhtml.mybestyoutube.model.Video

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null
    private val items : List<String> = listOf("Material", "Design", "Components", "Android")

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        val adapter = ArrayAdapter(requireContext(), R.layout.categories, items)
        binding.categories.setAdapter(adapter)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("test", "before if")
        binding.create.setOnClickListener {
            if(binding.title.text?.length!! > 3 &&
                binding.desc.text?.length!! > 3  &&
                binding.uri.text?.length!! > 3 ) {
                Log.d("test", "if est passer")
                VideoDAO(requireContext()).add(Video(
                    binding.title.text.toString(),
                    binding.desc.text.toString(),
                    binding.uri.text.toString(),
                    binding.categories.text.toString()
                ))
                findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}