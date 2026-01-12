package dhn.intern.smart_ai_caculator_app.ui.components.keypad

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dhn.intern.smart_ai_caculator_app.data.keypad.key_values

@Composable
fun SimpleKeypad(
    onKeyPress: (String) -> Unit
) {
    val keys = key_values.keys

    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        keys.forEach { row ->
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                row.forEach { key ->
                    CalcButton_simple(
                        text = key,
                        modifier = Modifier.weight(1f),
                        background = keyBackgroundColor(key),
                        contentColor = if (key == "=")
                            MaterialTheme.colorScheme.onPrimary
                        else
                            MaterialTheme.colorScheme.onBackground
                    ) {
                        onKeyPress(key)
                    }
                }
            }
        }
    }
}
