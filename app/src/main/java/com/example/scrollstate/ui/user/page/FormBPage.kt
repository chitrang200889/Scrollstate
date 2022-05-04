package com.example.scrollstate.ui.user.page

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.scrollstate.ui.user.UserViewModel

@Composable
fun FormBPage(userViewModel: UserViewModel, formBPageScrollSate: ScrollState, onClickNext: () -> Unit) {
    Column(modifier = Modifier.verticalScroll(formBPageScrollSate)) {
        LargeText(message = "${userViewModel.currentUser?.name} - FormB - Top")
        LargeText(message = "${userViewModel.currentUser?.name} - FormB - Middle")
        LargeText(message = "${userViewModel.currentUser?.name} - FormB - Bottom")
        Button(onClick = onClickNext) {
            Text(text = "Submit")
        }
    }
}