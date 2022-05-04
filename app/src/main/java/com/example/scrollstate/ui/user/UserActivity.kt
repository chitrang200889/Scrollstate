package com.example.scrollstate.ui.user

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.scrollstate.data.repository.UserLocalDataSource
import com.example.scrollstate.ui.theme.ScrollStateTheme
import com.example.scrollstate.ui.user.page.FormAPage
import com.example.scrollstate.ui.user.page.UserListPage
import com.example.scrollstate.ui.user.page.UserRoute

class UserActivity : ComponentActivity() {
    val userViewModel: UserViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ScrollStateTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    UserRoute(
                        userViewModel = userViewModel,
                        goBack = { onBackPressed() },
                        closeActivity = { finish() }
                    )
                }
            }
        }
    }
}

