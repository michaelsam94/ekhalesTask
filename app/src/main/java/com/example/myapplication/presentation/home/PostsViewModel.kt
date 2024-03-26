package com.example.myapplication.presentation.home


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.data.remote.dto.Post
import com.example.myapplication.domain.repository.DataRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class PostsViewModel @Inject constructor(
    private val dataRepo: DataRepo
) : ViewModel() {


    private val _posts = MutableLiveData<List<Post>>()

    val posts: LiveData<List<Post>> get() = _posts
    fun getData() {
        viewModelScope.launch(IO) {
            val res = dataRepo.getPosts()
            withContext(Dispatchers.Main) {
                _posts.value = res.data ?: emptyList()
            }
        }
    }





}
