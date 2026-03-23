package com.mobius.pbl.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.mobius.pbl.data.ItemEntity
import com.mobius.pbl.domain.TitleValidator

/**
 * @file ItemsScreen.kt
 * @fn ItemsScreen
 * @brief Compose UI (목록/추가/삭제/flag 토글)를 구성합니다.
 * @param viewModel UI 로직 및 데이터 처리를 담당하는 ViewModel
 * @date 2026-03-23
 * @author Gemini
 */
@Composable
fun ItemsScreen(
    viewModel: ItemsViewModel,
) {
    val items by viewModel.items.collectAsState()
    var titleInput by rememberSaveable { mutableStateOf("") }

    val isValid = TitleValidator.isValid(titleInput)

    Card(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
    ) {
        androidx.compose.foundation.layout.Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp),
        ) {
            OutlinedTextField(
                value = titleInput,
                onValueChange = { titleInput = it },
                modifier = Modifier.fillMaxWidth(),
                label = { Text("Title") },
                singleLine = true,
            )

            Button(
                onClick = {
                    viewModel.addTitle(titleInput)
                    titleInput = ""
                },
                enabled = isValid,
                modifier = Modifier.fillMaxWidth(),
            ) {
                Text("추가")
            }

            Spacer(modifier = Modifier.height(8.dp))

            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(360.dp),
            ) {
                items(
                    items,
                    key = { it.id },
                ) { item ->
                    ItemRow(
                        item = item,
                        onToggle = {
                            viewModel.setFlag(item.id, !item.flag)
                        },
                        onDelete = {
                            viewModel.deleteItem(item.id)
                        }
                    )
                }
            }
        }
    }
}

/**
 * @fn ItemRow
 * @brief 하나의 아이템 행을 표시합니다.
 * @param item 표시할 아이템 엔티티
 * @param onToggle flag 스위치 토글 시 콜백
 * @param onDelete 삭제 버튼 클릭 시 콜백
 * @date 2026-03-23
 * @author Gemini
 */
@Composable
private fun ItemRow(
    item: ItemEntity,
    onToggle: () -> Unit,
    onDelete: () -> Unit,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            text = item.title,
            modifier = Modifier
                .weight(1f),
            style = MaterialTheme.typography.bodyLarge,
        )

        Switch(
            checked = item.flag,
            onCheckedChange = { onToggle() },
        )

        Button(
            onClick = onDelete,
            modifier = Modifier.padding(start = 8.dp),
        ) {
            Text("삭제")
        }
    }
}
