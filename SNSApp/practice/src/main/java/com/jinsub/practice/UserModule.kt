package com.jinsub.practice

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class UserModule {

    @Provides
    @UserQualifier(22, 177)
    fun provideSub(): User {
        return User("sub")
    }

    @Provides
    @UserQualifier(23, 187)
    fun provideJin(): User {
        return User("jin")
    }
}