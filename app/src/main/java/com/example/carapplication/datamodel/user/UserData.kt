package com.example.carapplication.datamodel.user

import android.os.Parcel
import android.os.Parcelable
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.carapplication.datamodel.user.PersonalInformation
import com.example.carapplication.datamodel.user.VahicleInfo
@Entity(tableName = "user_data_table")
data class UserData(
    @Embedded
    val personalInfo: PersonalInformation,
    @Embedded
    val vahicleInfo: VahicleInfo,
    @PrimaryKey(autoGenerate = false) val id: Int?=null

):Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readParcelable(PersonalInformation::class.java.classLoader)!!,
        parcel.readParcelable(VahicleInfo::class.java.classLoader)!!,
        parcel.readValue(Int::class.java.classLoader) as? Int
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeParcelable(personalInfo, flags)
        parcel.writeParcelable(vahicleInfo, flags)
        parcel.writeValue(id)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<UserData> {
        override fun createFromParcel(parcel: Parcel): UserData {
            return UserData(parcel)
        }

        override fun newArray(size: Int): Array<UserData?> {
            return arrayOfNulls(size)
        }
    }
}