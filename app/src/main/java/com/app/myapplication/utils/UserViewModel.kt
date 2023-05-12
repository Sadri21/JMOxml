package com.app.myapplication.utils

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.app.myapplication.realm.RealmConfig.createConfigRealm
import com.app.myapplication.realm.RealmConfig.inputUser
import com.app.myapplication.realm.User
import io.realm.kotlin.Realm
import io.realm.kotlin.ext.query
import io.realm.kotlin.query.RealmResults

class UserViewModel: ViewModel() {
    val user =  MutableLiveData<List<User>>()
    private val realm =  Realm.open(createConfigRealm())

    fun addUserToRealm() {
        val items: RealmResults<User> = realm.query<User>().find()
        realm.writeBlocking {
            for (data in inputUser()) {
                if (items.none { it._idUser == data._idUser }) {
                    copyToRealm(data)
                }
            }
        }
    }

    fun getUser() {
        val items: RealmResults<User> = realm.query<User>().find()
        user.postValue(items)
    }
}