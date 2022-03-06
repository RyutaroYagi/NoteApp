package com.ryu.noteapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ryu.noteapp.model.Article
import com.ryu.noteapp.repository.HomeRepository
import com.ryu.noteapp.utils.Future
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: HomeRepository) : ViewModel() {

    val articleLiveData = MutableLiveData<Future<List<Article>>>(Future.Proceeding)

    init {
        refresh()
    }

    private fun refresh() = viewModelScope.launch {
        repository.fetchArticles()
            .collectLatest { articleLiveData.value = it }
    }
}
