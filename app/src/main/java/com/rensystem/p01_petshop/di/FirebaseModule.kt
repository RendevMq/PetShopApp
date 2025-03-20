package com.rensystem.p01_petshop.di

import com.google.firebase.database.FirebaseDatabase
import com.rensystem.p01_petshop.data.FirebaseRepository
import com.rensystem.p01_petshop.domain.Repository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object FirebaseModule {

    // Proveemos la instancia de FirebaseDatabase
    @Singleton
    @Provides
    fun provideFirebaseDatabase(): FirebaseDatabase {
        return FirebaseDatabase.getInstance()
    }

    //Proveemos el Repositorio
    @Singleton
    @Provides
    fun providesRepository(firebaseDatabase: FirebaseDatabase):Repository{
        return FirebaseRepository(firebaseDatabase)// Inyectamos FirebaseDatabase en el repositorio
    }
}