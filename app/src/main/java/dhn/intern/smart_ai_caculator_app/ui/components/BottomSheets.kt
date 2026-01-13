package dhn.intern.smart_ai_caculator_app.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import dhn.intern.smart_ai_caculator_app.R
import dhn.intern.smart_ai_caculator_app.data.entity.CalculatorHistoryEntity
import dhn.intern.smart_ai_caculator_app.data.menu_home.MenuData
import dhn.intern.smart_ai_caculator_app.model.MenuUI
import dhn.intern.smart_ai_caculator_app.ui.components.history.CaculatorHistory
import dhn.intern.smart_ai_caculator_app.ui.screen.MenuItemRow
import dhn.intern.smart_ai_caculator_app.util.toDateTimeString
import kotlin.div
import kotlin.times

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HalfScreenBottomSheet(
    show: Boolean,
    history: CalculatorHistoryEntity?,
    onDismiss: () -> Unit,
) {
    val menuList = MenuData.getSettingHistoryData()
    val sheetState = rememberModalBottomSheetState(
        skipPartiallyExpanded = true
    )
    if (show && history != null) {
        ModalBottomSheet(
            onDismissRequest = onDismiss,
            sheetState = sheetState,
            containerColor = MaterialTheme.colorScheme.background,
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .navigationBarsPadding(),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Row(
                    modifier =  Modifier
                        .background(MaterialTheme.colorScheme.background),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = history.timestamp.toDateTimeString(),
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.weight(1f))

                    Icon(
                        painter = painterResource(id = R.drawable.close),
                        modifier = Modifier
                            .size(15.dp)
                            .clickable{
                                onDismiss()
                            },
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.onBackground
                    )
                }

                CaculatorHistory(
                    history = history,
                    onClick = {}
                )
                LazyColumn(
                    modifier = Modifier.wrapContentHeight(),
                    userScrollEnabled = false
                ) {
                    itemsIndexed(menuList) { index, item ->
                        BottomItemRow(item) {
                        }
                        if(index < menuList.lastIndex)
                        HorizontalDivider(
                            modifier = Modifier.padding(start = 10.dp, end = 10.dp),
                            color = MaterialTheme.colorScheme.outline.copy(alpha = 0.2f)
                        )
                    }
                }
            }
        }
    }
}
@Composable
fun BottomItemRow(
    item: MenuUI,
    onClick: () -> Unit,
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp, vertical = 4.dp),
        shape = RoundedCornerShape(10.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.background,
            contentColor = MaterialTheme.colorScheme.onSurface
        ),
        onClick = onClick
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(id = item.icon.toInt()),
                contentDescription = null,
                modifier = Modifier.size(30.dp),
            )
            Spacer(modifier = Modifier.width(12.dp))
            Text(
                text = stringResource(id = item.name),
                style = MaterialTheme.typography.bodyLarge,
                fontWeight = FontWeight.Medium
            )
        }
    }
}