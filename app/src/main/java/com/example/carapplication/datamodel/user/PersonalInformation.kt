package com.example.carapplication.datamodel.user

import android.os.Parcel
import android.os.Parcelable
import androidx.room.PrimaryKey



data class PersonalInformation(
    val name:String,
    val phone:Long,
    val eMail:String,
    val Password:String,



):Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString()!!,
        parcel.readLong(),
        parcel.readString()!!,
        parcel.readString()!!
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeLong(phone)
        parcel.writeString(eMail)
        parcel.writeString(Password)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<PersonalInformation> {
        override fun createFromParcel(parcel: Parcel): PersonalInformation {
            return PersonalInformation(parcel)
        }

        override fun newArray(size: Int): Array<PersonalInformation?> {
            return arrayOfNulls(size)
        }
    }
}



