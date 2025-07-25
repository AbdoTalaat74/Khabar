package com.loc.newsapp.domain.uscases.app_entry

import com.loc.newsapp.domain.manager.LocalUserManager
import kotlinx.coroutines.flow.Flow

class ReadAppEntry(
    private val localUserManager: LocalUserManager
) {
     operator fun invoke(): Flow<Boolean> = localUserManager.readAppEntry()

}