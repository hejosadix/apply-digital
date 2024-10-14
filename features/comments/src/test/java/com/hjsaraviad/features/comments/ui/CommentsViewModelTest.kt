package com.hjsaraviad.features.comments.ui

import com.hjsaraviad.core.data.comments.repositories.CommentsRepository
import com.hjsaraviad.features.comments.utils.FakeComments
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain

import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations

class CommentsViewModelTest {

    @Mock
    private lateinit var repository: CommentsRepository
    private lateinit var viewModel: CommentsViewModel

    @OptIn(ExperimentalCoroutinesApi::class)
    @Before
    fun setup() {
        MockitoAnnotations.openMocks(this)
        Dispatchers.setMain(Dispatchers.Unconfined)
        viewModel = CommentsViewModel(repository)
    }


    @Test
    fun `fetchComments returns expected data`() = runTest {
        val data = FakeComments.generateFakeComments()
        `when`(repository.fetchComments()).thenReturn(
            flowOf(data)
        )
        val comments = repository.fetchComments().firstOrNull()
        assert(comments == data)
    }
}