package com.shobu95.basicmad.database

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize // enables objects to be sent to other screens
@Entity(tableName = "developer")
data class Developer(

    @PrimaryKey(autoGenerate = false)
    var id: Int? = null,
    var name: String? = null,
    var role: String? = null,
    var description: String? = null,

): Parcelable {
    override fun toString(): String {
        return "Developer(id=$id, name=$name, role=$role, description=$description)"
    }
}
