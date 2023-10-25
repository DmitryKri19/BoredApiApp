package com.example.hse

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.hse.databinding.MainFragmentBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainFragment:Fragment(R.layout.main_fragment) {

    private var _binding: MainFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = MainFragmentBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var url = ""
        binding.buttonGetIdea.setOnClickListener {
            Network.boredApi.getActivity().enqueue(object : Callback<Activity> {
                override fun onResponse(call: Call<Activity>, response: Response<Activity>) {
                    if(response.isSuccessful){
                        val idea = response.body()
                        binding.textViewIdea.text = idea?.activity
                        if (idea?.link?.isNotBlank() == true) {
                            binding.linkTextView.text = idea.link
                            binding.linkTextView.visibility = View.VISIBLE
                            url = idea.link
                        } else {
                            binding.linkTextView.text = ""
                        }
                    }
                }

                override fun onFailure(call: Call<Activity>, t: Throwable) {
                    TODO("Not yet implemented")
                }
            })


        }
        binding.linkTextView.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(intent)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}