package com.example.data.repository.language

import java.util.Locale

class LanguageRepositoryImpl : LanguageRepository {

    override fun getCurrentLanguage(): String {
        return Locale.getDefault().toLanguageTag()
    }
}