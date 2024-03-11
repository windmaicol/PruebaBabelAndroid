package com.example.pruebababelandroid.ui.fragment


import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pruebababelandroid.databinding.EpisodeFragmentBinding
import com.example.pruebababelandroid.domain.model.Episode
import com.example.pruebababelandroid.ui.adapter.ListEpisodeAdapter
import com.example.pruebababelandroid.ui.viewmodel.EpisodeViewModel
import dagger.hilt.android.AndroidEntryPoint

/**
 * FRagmento de episodios
 */
@AndroidEntryPoint
class EpisodesFragment : Fragment() {

    private val episodeViewModel: EpisodeViewModel by viewModels()

    private val characters:MutableList<Episode> = ArrayList()
    private lateinit var mRecyclerView : RecyclerView
    private lateinit var listCharactersAdapter : ListEpisodeAdapter
    companion object {
        fun newInstance(): EpisodesFragment = EpisodesFragment()
    }
    private var _binding: EpisodeFragmentBinding? = null
    private val binding get() = _binding!!
    /**
     * onCreateView
     */
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View {
        _binding = EpisodeFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }
    /**
     * onViewCreated
     */
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViewModel()
        binding.ivSearch.setOnClickListener{
            episodeViewModel.getDataWithFilter(binding.etSearch.text.toString())
        }
    }
    /**
     * metodo para configurar el view model
     */
    private fun initViewModel(){

        episodeViewModel.episodes.observe(viewLifecycleOwner){
            characters.clear()
            characters.addAll(it)
            setUpRecyclerView(characters)
        }
        episodeViewModel.isLoading.observe(viewLifecycleOwner) {
            binding.loadingProfile.isVisible = it
        }
        episodeViewModel.getAllEpisodes()

    }
    /**
     * metodo para configurar el adaptador
     */
    @SuppressLint("NotifyDataSetChanged")
    private fun setUpRecyclerView(characters:MutableList<Episode>?){
        listCharactersAdapter = ListEpisodeAdapter()
        mRecyclerView = binding.rvListMoviesProfile
        mRecyclerView.setHasFixedSize(true)
        mRecyclerView.layoutManager = LinearLayoutManager(context)
        mRecyclerView.addItemDecoration(DividerItemDecoration(context, LinearLayoutManager.VERTICAL))
        mRecyclerView.adapter = listCharactersAdapter
        listCharactersAdapter.submitList(characters)
        mRecyclerView.adapter?.notifyDataSetChanged()
    }
}