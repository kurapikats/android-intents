package com.idooh.explicitintent;

import android.os.Parcel;
import android.os.Parcelable;

public class Person implements Parcelable {
    public Person() {
        super();
    }

    public Person(Parcel parcel) {
        this.firstName=parcel.readString();
        this.lastName=parcel.readString();
        this.qualification=parcel.readString();
    }

    private String firstName;
    private String lastName;
    private String qualification;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.firstName);
        dest.writeString(this.lastName);
        dest.writeString(this.qualification);
    }

    public static final Creator<Person> CREATOR=new Creator<Person>() {
        @Override
        public Person createFromParcel(Parcel parcel) {
            return new Person(parcel);
        }

        @Override
        public Person[] newArray(int i) {
            return new Person[i];
        }
    };

    public void setFirstName(String firstName) { this.firstName = firstName; }

    public void setLastName(String lastName) { this.lastName = lastName; }

    public void setQualification(String qualification) { this.qualification = qualification; }

    public String getFirstName() { return firstName; }

    public String getLastName() { return lastName; }

    public String getQualification() { return qualification; }
}
