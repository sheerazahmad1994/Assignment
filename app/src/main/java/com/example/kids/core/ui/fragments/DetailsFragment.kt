package com.example.kids.core.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.NavController
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.kids.R
import com.example.kids.databinding.FragmentDetailsBinding
import com.example.kids.databinding.FragmentHomeBinding

class DetailsFragment : Fragment() {

    private lateinit var binding: FragmentDetailsBinding
    private lateinit var data: com.example.kids.core.model.getarticles.Result

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        data = DetailsFragmentArgs.fromBundle(arguments!!).data
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment

        binding = FragmentDetailsBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setData()
    }

    private fun setData() {
        binding.tvTitle.text = data.title
        binding.tvByLine.text = data.byline
        binding.tvSource.text = data.source
        binding.tvDate.text = data.published_date
        binding.tvSection.text = data.section
        binding.tvAbstract.text = data.abstract
        if (data.media.size > 0) {
            Glide.with(requireContext()).load(data.media[0].media_metadata[2].url)
                .apply(RequestOptions().centerCrop())
                .placeholder(R.drawable.ic_baseline_camera)
                .error(R.drawable.ic_baseline_camera)
                .into(binding.ivBanner)
        }
    }
}