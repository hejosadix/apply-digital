package com.hjsaraviad.features.comments.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hjsaraviad.core.data.comments.models.Comment
import com.hjsaraviad.core.data.comments.repositories.CommentsRepository
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class CommentsViewModel(private val repository: CommentsRepository) : ViewModel() {
    var job: Job? = null
    private val _state = MutableStateFlow(CommentsUiState())
    val state: StateFlow<CommentsUiState> = _state.onStart {
        onEvent(CommentsUiEvent.LoadData)
    }.stateIn(
        viewModelScope,
        started = SharingStarted.WhileSubscribed(),
        initialValue = CommentsUiState()
    )

    fun onEvent(event: CommentsUiEvent) {
        when (event) {
            CommentsUiEvent.LoadData -> loadData()
            is CommentsUiEvent.OnCommentDelete -> deleteComment(event.key)
        }
    }

    /**
     * Fetches the comments from the repository and updates the state
     * with the new comments
     * comments = emptyList() is just just to show that the comments are being loaded
     */
    private fun loadData() {
        _state.value = state.value.copy(isLoading = true, comments = emptyList())
        job?.cancel()
        job = viewModelScope.launch {
            repository.fetchComments().collectLatest { data ->
                _state.value = state.value.copy(isLoading = false, comments = data)
            }
        }
    }

    private fun deleteComment(key: String) {
        viewModelScope.launch {
            val selectedComment = state.value.comments.firstOrNull { it.objectID == key }
            _state.value = state.value.copy(comments = state.value.comments.filter { it.objectID != key })
            selectedComment?.let {
                repository.deleteLocalComment(it)
            }
        }
    }
}

//this is the single source of truth for the comments screen
data class CommentsUiState(
    val isLoading: Boolean = false,
    val comments: List<Comment> = emptyList()
)

// this is the intent section for the comments screen
sealed interface CommentsUiEvent {
    data object LoadData : CommentsUiEvent
    data class OnCommentDelete(val key: String) : CommentsUiEvent
}