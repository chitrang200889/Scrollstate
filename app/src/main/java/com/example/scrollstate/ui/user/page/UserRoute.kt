package com.example.scrollstate.ui.user.page

import androidx.activity.compose.BackHandler
import androidx.compose.animation.Crossfade
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import com.example.scrollstate.data.repository.UserLocalDataSource
import com.example.scrollstate.ui.user.UserViewModel

enum class Pages {
    UserList,
    FormA,
    FormB
}

@Composable
fun UserRoute(
    userViewModel: UserViewModel,
    goBack: () -> Unit,
    closeActivity: () -> Unit
) {
    val userListPageLazyListState: LazyListState = rememberLazyListState()
    val formAPageScrollSate: ScrollState = rememberScrollState()
    val formBPageScrollSate: ScrollState = rememberScrollState()

    val activePage = rememberSaveable {
        mutableStateOf(Pages.UserList)
    }

    val onClickBack: () -> Unit = {
        when (activePage.value) {
            Pages.UserList -> goBack()
            Pages.FormA -> activePage.value = Pages.UserList
            Pages.FormB -> activePage.value = Pages.FormA
        }
    }


    val onClickNext: () -> Unit = {
        when (activePage.value) {
            Pages.UserList -> {
                activePage.value = Pages.FormA
            }
            Pages.FormA -> {
                activePage.value = Pages.FormB
            }
            Pages.FormB -> closeActivity()
        }
    }

    BackHandler(enabled = (activePage.value != Pages.UserList)) {
        onClickBack()
    }

    Scaffold(
        content = {
            Crossfade(
                targetState = activePage.value
            ) {
                when (it) {
                    Pages.UserList -> UserListPage(
                        userViewModel = userViewModel,
                        onClickNext = onClickNext,
                        userListPageLazyListState = userListPageLazyListState
                    )
                    Pages.FormA -> FormAPage(
                        userViewModel = userViewModel,
                        formAPageScrollSate = formAPageScrollSate,
                        onClickNext = onClickNext
                    )
                    Pages.FormB -> FormBPage(
                        userViewModel = userViewModel,
                        formBPageScrollSate = formBPageScrollSate,
                        onClickNext = onClickNext
                    )
                }
            }
        })
}