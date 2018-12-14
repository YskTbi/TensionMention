package adapter

import entity.ListData
import org.jetbrains.anko.db.MapRowParser

class ListDataParser : MapRowParser<ListData> {
    override fun parseRow(columns: Map<String, Any?>): ListData {
        return ListData(columns["date"] as String, columns["tension"] as String, columns["comment"] as String)
    }
}