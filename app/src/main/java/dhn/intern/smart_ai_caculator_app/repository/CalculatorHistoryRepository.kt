package dhn.intern.smart_ai_caculator_app.repository

import dhn.intern.smart_ai_caculator_app.data.dao.CalculatorHistoryDao
import dhn.intern.smart_ai_caculator_app.data.entity.CalculatorHistoryEntity
import kotlinx.coroutines.flow.Flow

class CalculatorHistoryRepository(
    private val dao: CalculatorHistoryDao
) {

    fun getHistory(): Flow<List<CalculatorHistoryEntity>> =
        dao.getAllHistory()

    suspend fun save(expression: String, result: String) {
        dao.insert(
            CalculatorHistoryEntity(
                expression = expression,
                result = result
            )
        )
    }

    suspend fun clearAll() {
        dao.clearAll()
    }
}
