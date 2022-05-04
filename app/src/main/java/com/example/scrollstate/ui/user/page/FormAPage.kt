package com.example.scrollstate.ui.user.page

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.scrollstate.ui.user.UserViewModel

@Composable
fun FormAPage(userViewModel: UserViewModel, formAPageScrollSate: ScrollState, onClickNext: () -> Unit) {
    Column(modifier = Modifier.verticalScroll(formAPageScrollSate)) {
        LargeText(message = "${userViewModel.currentUser?.name} - FormA - Top")
        LargeText(message = "${userViewModel.currentUser?.name} - FormA - Middle")
        LargeText(message = "${userViewModel.currentUser?.name} - FormA - Bottom")
        Button(
            onClick = onClickNext,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentWidth(Alignment.CenterHorizontally)
        ) {
            Text(text = "Next")
        }
    }
}

@Composable
fun LargeText(message: String) {
    Text(
        text = message, modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 200.dp)
            .wrapContentHeight(Alignment.CenterVertically)
            .wrapContentWidth(Alignment.CenterHorizontally)
    )
}

//@Preview
//@Composable
//fun PreviewFormAPage() {
//    FormAPage(scrollState = rememberScrollState())
//}

