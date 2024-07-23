package com.example.macinmuebles.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.macinmuebles.model.PostModel
import com.example.macinmuebles.repository.PostRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class PostViewModel @Inject constructor(private val repo: PostRepository): ViewModel(){
    private val _posts = MutableStateFlow<List<PostModel>>(emptyList())
    private val _loading = MutableStateFlow<Boolean>(false)
    val posts = _posts.asStateFlow()
    val loading = _loading.asStateFlow()

    init {
        fetchPosts()
    }

    private fun fetchPosts(){
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                _loading.value = true
                val result = repo.getProperties()
                println(result)
                _posts.value = result?.data ?: emptyList()
                _loading.value = false
            }
        }
    }
}