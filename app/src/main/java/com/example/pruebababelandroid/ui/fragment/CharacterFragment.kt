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
import com.example.pruebababelandroid.databinding.CharacterFragmentBinding
import com.example.pruebababelandroid.domain.model.Characters
import com.example.pruebababelandroid.ui.adapter.ListCharactersAdapter
import com.example.pruebababelandroid.ui.viewmodel.CharacterViewModel
import dagger.hilt.android.AndroidEntryPoint

/**
 * FRagmento de personajes
 */
@AndroidEntryPoint
class CharacterFragment : Fragment() {

    private val characterViewModel: CharacterViewModel by viewModels()
    private val characters:MutableList<Characters> = ArrayList()
    private lateinit var mRecyclerView : RecyclerView
    private lateinit var listCharactersAdapter : ListCharactersAdapter
    companion object {
        fun newInstance(): CharacterFragment = CharacterFragment()
    }
    private var _binding: CharacterFragmentBinding? = null
    private val binding get() = _binding!!
    /**
     * onCreateView
     */
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        _binding = CharacterFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }
    /**
     * onViewCreated
     */
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViewModel()
    }
    /**
     * metodo para configurar el view model
     */
    private fun initViewModel(){
        characterViewModel.characters.observe(viewLifecycleOwner){
            characters.addAll(it)
            setUpRecyclerView(characters)
        }
        characterViewModel.isLoading.observe(viewLifecycleOwner) {
            binding.loadingProfile.isVisible = it
        }
        characterViewModel.getAllCharacters()
    }
    /**
     * metodo para configurar el adaptador
     */
    @SuppressLint("NotifyDataSetChanged")
    private fun setUpRecyclerView(characters:MutableList<Characters>?){
        listCharactersAdapter = ListCharactersAdapter()
        mRecyclerView = binding.rvListMoviesProfile
        mRecyclerView.setHasFixedSize(true)
        mRecyclerView.layoutManager = LinearLayoutManager(context)
        mRecyclerView.addItemDecoration(DividerItemDecoration(context, LinearLayoutManager.VERTICAL))
        mRecyclerView.adapter = listCharactersAdapter
        listCharactersAdapter.submitList(characters)
        mRecyclerView.adapter?.notifyDataSetChanged()
    }

}