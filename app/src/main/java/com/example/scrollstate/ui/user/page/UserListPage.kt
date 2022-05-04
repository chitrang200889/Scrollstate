package com.example.scrollstate.ui.user.page

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.scrollstate.data.repository.UserLocalDataSource
import com.example.scrollstate.model.User
import com.example.scrollstate.ui.user.UserViewModel

@Composable
fun UserListPage(
    userViewModel: UserViewModel,
    userListPageLazyListState: LazyListState,
    onClickNext: () -> Unit
) {
    LazyColumn(
        modifier = Modifier.fillMaxWidth(),
        state = userListPageLazyListState
    ) {
        items(userViewModel.userList) { user ->
            UserRowItem(user = user,
                onClickNext = {
                    userViewModel.currentUser = user
                    onClickNext()
                })
        }
    }
}

@Composable
fun UserRowItem(user: User, onClickNext: () -> Unit) {
    Text(
        text = user.name,
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClickNext)
            .padding(16.dp)
    )
}

//@Preview
//@Composable
//fun PreviewUserListPage(userList: List<User> = UserLocalDataSource.users) {
//    UserListPage(userList = userList )
//}