package com.example.newlamp.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.newlamp.R
import com.example.newlamp.ui.theme.NewLampTheme
import com.example.newlamp.ui.theme.SampleData

data class Message(val author: String, val body: String)

@Composable
fun Conversation(
    navController: NavController,
    messages: List<Message>
) {
    NewLampTheme {
        LazyColumn {
            items(messages) { message ->
                MessageCard(msg = message)
            }
        }
    }
}

@Composable
fun MessageCard(msg: Message) {
    Row(modifier = Modifier.padding(all = 8.dp)) {
        Image(
            painter = painterResource(id = R.drawable.alcobot_2),
            contentDescription = "Test picture",
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .border(1.5.dp, MaterialTheme.colors.secondary, CircleShape)
        )
        Spacer(modifier = Modifier.width(8.dp))

        var isExpanded by remember { mutableStateOf(false) }

        Column {
            Text(
                text = msg.author,
                color = MaterialTheme.colors.secondaryVariant,
                style = MaterialTheme.typography.subtitle2
            )
            Spacer(modifier = Modifier.height(4.dp))

            Surface(
                shape = MaterialTheme.shapes.medium,
                modifier = Modifier.clickable { isExpanded = !isExpanded },
                elevation = 1.dp
            ) {
                Text(
                    text = msg.body,
                    modifier = Modifier.padding(all = 4.dp),
                    maxLines = if (isExpanded) Int.MAX_VALUE else 1,
                    style = MaterialTheme.typography.body2
                )
            }
        }
    }

}

@Preview
@Composable
fun PreviewConversation() {
    Conversation(rememberNavController(), messages = SampleData.conversationSample)
}

//@Preview(
//    name = "Light Mode",
//    uiMode = Configuration.UI_MODE_NIGHT_NO
//)
//@Preview(
//    name = "Dark Mode",
//    uiMode = Configuration.UI_MODE_NIGHT_YES,
//    showBackground = true
//)
@Composable
fun PreviewMessageCard() {
    NewLampTheme {
        MessageCard(
            msg = Message("Test", "Was geht'n")
        )
    }
}