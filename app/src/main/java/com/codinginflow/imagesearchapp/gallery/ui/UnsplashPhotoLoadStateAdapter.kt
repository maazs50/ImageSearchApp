package com.codinginflow.imagesearchapp.gallery.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.paging.LoadState
import androidx.paging.LoadStateAdapter
import androidx.recyclerview.widget.RecyclerView
import com.codinginflow.imagesearchapp.databinding.UnsplashPhotoLoadStateFooterBinding

class UnsplashPhotoLoadStateAdapter(private val retry: () -> Unit):
    LoadStateAdapter<UnsplashPhotoLoadStateAdapter.DesignViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, loadState: LoadState): DesignViewHolder {
        val binding = UnsplashPhotoLoadStateFooterBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return DesignViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DesignViewHolder, loadState: LoadState) {
        holder.bind(loadState)
    }

   inner class DesignViewHolder(private val binding: UnsplashPhotoLoadStateFooterBinding): RecyclerView.ViewHolder(binding.root){

        init {
            binding.buttonRetry.setOnClickListener{
                //From the constructor agrs, make the ViewHolder inner class
                retry.invoke()
            }
        }

        fun bind(loadState: LoadState){
             binding.apply {
                 progressBar.isVisible = loadState is LoadState.Loading
                 textViewError.isVisible = loadState !is LoadState.Loading
                 buttonRetry.isVisible = loadState !is LoadState.Loading
             }
        }

    }
}